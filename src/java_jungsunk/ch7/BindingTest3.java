package java_jungsunk.ch7;
class Parant3{
    int x = 100;

    void method(){
        System.out.println("Parant Method");
    }
}

class Child3 extends Parant3{
    int x = 200;

    void method(){
        System.out.println("x = " + x);
        System.out.println("super.x = " + super.x);
        System.out.println("this.x = " + this.x);
    }
}

public class BindingTest3 {
    public static void main(String[] args) {
        Parant3 p = new Child3();
        Child3 c = new Child3();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}
