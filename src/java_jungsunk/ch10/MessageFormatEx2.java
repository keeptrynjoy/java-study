package java_jungsunk.ch10;

import java.text.MessageFormat;

public class MessageFormatEx2 {
    public static void main(String[] args) {
        String tableName = "CUST_INFO";
        String msg = "INSERT INFO " + tableName +
                " VALUES (''{0}'',''{1}'',''{2}'',''{3}'')";
        Object[][] arguments= {
                {"김성민","010-111-1111","31","01-16"},
                {"허선이","010-222-2222","61","06-25"},
        };

        for(int i=0; i<arguments.length; i++){
            String result = MessageFormat.format(msg, arguments[i]);
            System.out.println(result);
        }
    }
}
