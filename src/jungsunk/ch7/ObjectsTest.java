package jungsunk.ch7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static java.util.Objects.*;

public class ObjectsTest {
    public static void main(String[] args) {
        String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D_2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        System.out.println("str2D = {");
        for(String[] tmp : str2D)
            System.out.println(Arrays.toString(tmp));
        System.out.println("}");

        System.out.println("str2D_2={");
        for (String[] tmp : str2D_2)
            System.out.println(Arrays.toString(tmp));
        System.out.println("}");

        System.out.println("equals(str2D, str2D_2)="+ Objects.equals(str2D, str2D_2));
        //deepEquals() : 다차원배열 비교 가능
        System.out.println("deepEquals(str2D, str2D_2)="+ Objects.deepEquals(str2D,str2D_2));
        System.out.println("isNull(null) = " + isNull(null));
        System.out.println("nonNull(null) = " + nonNull(null));
        System.out.println("hashCode(null) = " + Objects.hashCode(null));
        System.out.println("toString(null) = " + Objects.toString(null));
        System.out.println("toString(null, \"\")=" + Objects.toString(null,"ㅌ"));

        Comparator c = String.CASE_INSENSITIVE_ORDER; // 대소문자 구분 안하는 비교
        System.out.println("compare(\"aa\",\"bb\") = " + compare("aa","bb", c));
        System.out.println("compare(\"bb\",\"aa\") = " + compare("bb","aa", c));
        System.out.println("compare(\"ab\",\"AB\") = " + compare("ab","AB", c));
    }
}
