package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

    public String user = "root";
    public String password = "root";
    public String connectionString = "localhost:3306";

    private Connection connection;

    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private int dbConnectionTimeOut = 10000;

    public Database() {

    }

    public Database(String dbUser, String dbPassword, String connectionHost, int dbConnectionTimeOut) {
        user = dbUser;
        password = dbPassword;
        connectionString = connectionHost;
        this.dbConnectionTimeOut = dbConnectionTimeOut;
    }

    public String[] getArrayFromDB(String table, String[] args) {
        return getArrayFromDB(table, args, "");
    }

    /**
     * @param table name of table
     * @param args columns
     * @param where
     * @return
     */
    public String[] getArrayFromDB(String table, String[] args, String where) {
        String[] result = new String[args.length];
        String query = "SELECT ";
        for (String arg : args)
            query += arg + ", ";
        query = query.substring(0, query.length() - 2) + " FROM " + table;
        if (!where.equals(""))
            query = query + " WHERE " + where;
        query = query + ";";
        ResultSet resultSet = getResultSet(query);
        try {
            if (resultSet.next()) {
                for (int i = 0; i < args.length; i++)
                    result[i] = resultSet.getString(args[i]);
            } else
                for (int i = 0; i < args.length; i++)
                    result[i] = "null";
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList getEntities(String table){
        String baseQuery = "SELECT * FROM " + table;
        ArrayList entities = new ArrayList<>();
        try {
            entities = (ArrayList)
                    loadObjectFromResultSet(getResultSet(baseQuery));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  entities;
    }

    public Object loadObjectFromResultSet(ResultSet resultSet) throws Exception
    {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while(resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i < columnCount -1 ; i++) {
                String columnName = metaData.getColumnName(i);
                Object objectValue = resultSet.getObject(i);
                map.put(columnName, objectValue);
            }
            objectArrayList.add(map);
        }
        return objectArrayList;
    }


    public void connect() {
        try {
            Class.forName(DB_DRIVER);
            setConnection(DriverManager.getConnection("jdbc:mysql://" + connectionString + "?zeroDateTimeBehavior=convertToNull", user, password));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getResultSet(String sqlQuery) {
        ResultSet resultSet = null;
        try {
            Statement statement = getConnection().createStatement();
            resultSet = statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
