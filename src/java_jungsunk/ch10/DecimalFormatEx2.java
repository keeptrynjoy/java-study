package java_jungsunk.ch10;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatEx2 {

    public static void main(String[] args) {
        double number = 1234567.89;
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#.###E0");

        Number num = null;
        try {
            num = df.parse("1,234,567.89");

        System.out.print("1,234,567.89 " + " -> ");

        double d = num.doubleValue();
        System.out.print(df2.format(num));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
     }
}
