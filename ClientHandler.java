package server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {

    private ConsoleServer server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nickname;

    // черный список у пользователя, а не у сервера
    List<String> blackList;

    public ClientHandler(ConsoleServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.blackList = new ArrayList<>();

            new Thread(() -> {
                boolean isExit = false;
                try {
                    socket.setSoTimeout(12000);
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String nick = AuthService.getNicknameByLoginAndPass(tokens[1], tokens[2]);
                            if (nick != null) {
                                if (!server.isNickBusy(nick)) {
                                    sendMsg("/auth-OK");
                                    setNickname(nick);
                                    socket.setSoTimeout(0);
                                    server.subscribe(ClientHandler.this);
                                    readHistory(100);
                                    break;
                                } else {
                                    sendMsg("Учетная запись уже используется");
                                }
                            } else {
                                sendMsg("Неверный логин/пароль");
                            }
                        }
                        // регистрация
                        if (str.startsWith("/signup ")) {
                            String[] tokens = str.split(" ");
                            int result = AuthService.addUser(tokens[1], tokens[2], tokens[3]);
                            if (result > 0) {
                                sendMsg("Successful registration");
                            } else {
                                sendMsg("Registration failed");
                            }
                        }
                        // выход
                        if ("/end".equals(str)) {
                            isExit = true;
                            break;
                        }
                    }

                    if (!isExit) {
                        while (true) {
                            String str = in.readUTF();
                            // для всех служебных команд и личных сообщений
                            if (str.startsWith("/") || str.startsWith("@")) {
                                if ("/end".equalsIgnoreCase(str)) {
                                    // для оповещения клиента, т.к. без сервера клиент работать не должен
                                    out.writeUTF("/serverClosed");
                                    System.out.println("Client (" + socket.getInetAddress() + ") exited");
                                    break;
                                }
                                // вторая часть ДЗ. выполнение
                                if (str.startsWith("@")) {
                                    String[] tokens = str.split(" ", 2);
                                    server.sendPrivateMsg(this, tokens[0].substring(1), tokens[1]);
                                }
                                // черный список для пользователя. но пока что только в рамках одного запуска программы
                                if (str.startsWith("/blacklist ")) {
                                    String[] tokens = str.split(" ");
                                    blackList.add(tokens[1]);
                                    sendMsg("You added " + tokens[1] + " to blacklist");
                                }
                            } else {
                                server.broadcastMessage(this, nickname + ": " + str);
                                writeHistory(msg);
                            }
                            System.out.println("Client (" + socket.getInetAddress() + "): " + str);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {

        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean checkBlackList(String nickname) {
        return blackList.contains(nickname);
    }
    public void readHistory(int n){                                                // <-- чтение файла истории сообщений
        File file =new File("test.txt");
        try{
            RandomAccessFile raf=new RandomAccessFile(file,"r");
            long length = file.length()-1;
            int readLine=0;
            StringBuilder sb =new StringBuilder();
            for(long i=length;i >=0; i--){
                raf.seek(i);
                char c=(char) raf.read();
                if(c == '\n'){
                    readLine++;
                    if(readLine == n){
                        break;
                    }
                }
                sb.append(c);
            }
            sendMessage(String.valueOf(sb.reverse()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String valueOf) {
    }

    public void writeHistory (String msg){                                       // <-- запись всех строк в файл истории
        try(FileWriter writer = new FileWriter("test.txt", true))
        {
            String nick;
            String text =(nick + ": " + msg + "\n");
            writer.write(text);
            writer.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

