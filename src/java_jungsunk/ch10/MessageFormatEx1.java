package java_jungsunk.ch10;

import java.text.MessageFormat;

public class MessageFormatEx1 {
    public static void main(String[] args) {
        String msg = "Name : {0} \nTel: {1} \nAge:{2} \nBrithday:{3}";

        Object[] arguments = {
          "김성민", "010-111-1111", "31", "01-16"
        };

        String result = MessageFormat.format(msg, arguments);
        System.out.println(result);
    }
}
