package jungsunk.ch7;


class Parant1 {
    int x = 100;

    void method(){
        System.out.println("Parant Method");
    }
}

class Child1 extends Parant1 {
    int x = 200;

    void method(){
        System.out.println("Child Method");
    }
}

public class BindingTest {
    public static void main(String[] args) {
        Parant1 p = new Child1();
        Child1 c = new Child1();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}
