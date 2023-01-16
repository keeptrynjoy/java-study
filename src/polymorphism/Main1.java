package polymorphism;

class Programmer {
    void writeSourceCode(){};

}

class JrProgrammer extends Programmer{
    void helloWorld(){};
    void hardCoding(){};
}

public class Main1 {
    public static void main(String[] args) {

        Programmer programmerWork = new Programmer();
        JrProgrammer jrProgrammerWork = new JrProgrammer();

        Programmer programmerWork1 = new JrProgrammer();

        //JrProgrammer programmerWork2 = new Programmer(); <-- 에러발생, 부모클래스는 자손클래스의 메서드가 없기 때문

    }
}