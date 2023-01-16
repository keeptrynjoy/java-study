package jungsunk.ch10;

import java.text.*;

public class MessageFormatEx3 {
    public static void main(String[] args) throws Exception {
        String[] data ={
                "INSERT INFO CUST_INFO VALUES ('김성민','010-111-1111','31','01-16');",
                "INSERT INFO CUST_INFO VALUES ('허선이','010-222-2222','61','06-25');"
        };

        String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";
        MessageFormat mf = new MessageFormat(pattern);

        for(int i=0; i < data.length; i++){
            System.out.println(data[i]);
            Object[] objs = mf.parse(data[i]);
            for(int j=0; j < objs.length; j++){
                System.out.println( objs[j]+ ",");
            }
            System.out.println();
        }
    }
}
