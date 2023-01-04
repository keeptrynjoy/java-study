package java_jungsunk.ch10;

import java.io.File;
import java.text.MessageFormat;
import java.util.Scanner;

public class MessageFormatEx4 {
    public static void main(String[] args) throws Exception {
        String tableName = "CUST_INFO";
        String fileName = "Data4.txt";
        String msg = "INSERT INTO "+ tableName
                + " VALUES ({0},{1},{2},{3});";
        Scanner s = new Scanner(new File("/Users/kimsungmin/Desktop/study/java_study/src/java_jungsunk/ch10/Data4.txt"));

        String pattern = "{0},{1},{2},{3}";
        MessageFormat mf = new MessageFormat(pattern);

        while (s.hasNextLine()){
            String line = s.nextLine();
            Object[] objs = mf.parse(line);
            System.out.println(MessageFormat.format(msg,objs));
        }
        s.close();
    }
}
