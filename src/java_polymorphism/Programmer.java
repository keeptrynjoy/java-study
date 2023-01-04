package java_polymorphism;

class Programmer {
    void writeSourceCode(){};

}

class JrProgrammer extends Programmer{
    void helloWorld(){};
    void hardCoding(){};
}

class JustDoIt {
    Programmer programmerWork = new Programmer();
    JrProgrammer jrProgrammerWork = new JrProgrammer();

    Programmer programmerWorkLv1 = new JrProgrammer();
}