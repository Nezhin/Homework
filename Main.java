public class Main {
    public static void main(String[] args) {
    String[][] s=new String[4][4];
    String[][] s1=new String[4][4];
    String[][] s2=new String[2][3];
    String[][] s3=new String[4][4];
    fill(s);
    fill(s1);
    fill(s2);
    fill(s3);
    s3[1][2]="A random symbol";
    check(s);
    check(s1);
    check(s2);
    check(s3);
    }

    public static void fill(String[][] array ){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                array[i][j]= i * j + "";
            }
        }
}
public static void sum(String[][] array)throws MyArraySizeException, MyArrayDataException{
        int a=0;
        for(String[] e:array ){
            if(array.length!=4 || e.length!=4){
                throw new MyArraySizeException("Размер массива некорректный");
            }
        }
for (int i=0;i< array.length;i++){
    for(int j=0;j<array[i].length;j++){
        try{
            a += Integer.parseInt(array[i][j]);
        }catch (NumberFormatException e){
            throw new MyArrayDataException("В ячейке массива {" + i + "," + j + "} " +
                    "содержатся неверные данные: " + array[i][j]);
        }
    }
}
    System.out.println("Сумма элементов массива: "+ a);

    }

    public static void check(String [][] array){
        try{
            sum(array);
        }catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }
    }


}
