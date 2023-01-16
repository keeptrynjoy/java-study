package LambdaAndStream;

@FunctionalInterface
interface TestFunction {
    void test();
}

public class LambdaPractice1 {

    static void execute(TestFunction t) {t.test();}

    static TestFunction getTestFunction(){
        TestFunction t = () -> System.out.println("t3.test()");
        return t;
    }

    public static void main(String[] args) {

        TestFunction t1 = () -> System.out.println("test1");

        TestFunction t2 = new TestFunction() {
            public void test(){
                System.out.println("t2.test()");
            }
        };

        t1.test();
        t2.test();

        TestFunction t3 = getTestFunction();
        t3.test();

        execute(t1);
        execute( () -> System.out.println("test()"));

    }
}
