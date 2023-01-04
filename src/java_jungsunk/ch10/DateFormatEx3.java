package java_jungsunk.ch10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx3 {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");


        try {
            //substring 을 사용하지 않고 parse 로 간단하게 문자열해석
           Date d = df.parse("2015년 11월 23일");
            System.out.println(df2.format(d));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
