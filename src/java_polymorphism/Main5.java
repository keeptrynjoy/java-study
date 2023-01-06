package java_polymorphism;

class Lv1{
    //overloading
    public void print(int value){
        System.out.println("숫자 출력 = " + value);
    }

    //overloading
    public void print(String value){
        System.out.println("문자 출력 = " + value);
    }

    public void add(int x, int y) {
        System.out.println(x+y);
    }
}

class Lv2 extends Lv1{
    //overriding
    public void add(int x, int y){
        System.out.println((x + y) * 2);
    }
}


public class Main5 {
    public static void main(String[] args) {
        /* 메서드 다형성 : 오버로딩과 오버라이딩 */
        Lv1 lv1 = new Lv1();
        lv1.print(100); // 결과 : 숫자 출력 = 100 (오버로딩)
        lv1.print("test"); // 결과 : 문자 출력 = test (오버로딩)
        lv1.add(1,2);// 결과 : 3

        Lv1 lv2 = new Lv2();
        lv2.add(1,2);// 결과 : 6 (오버라이딩)
    }
}
