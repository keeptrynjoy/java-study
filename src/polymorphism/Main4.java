package polymorphism;

interface Company {
    void business();
}

class LG implements Company {
    String product = "ElectronicProducts";

    public void business(){
        System.out.println(this.product);
    }
}

class Daum implements Company {
    String product = "OnlinePlatform";

    public void business(){
        System.out.println(this.product);
    }
}

class Kia implements Company {
    String product = "Car";

    public void business(){
        System.out.println(this.product);
    }
}

class Content{
    void content(Company company){
        company.business();
    }
}

public class Main4 {

    public static void main(String[] args) {
        /* 매개변수 다형성 : 인터페이스 구현 */
       LG lg = new LG();
       Daum daum = new Daum();
       Kia kia = new Kia();

       Content company = new Content();
       company.content(lg);
       company.content(daum);
       company.content(kia);

    }
}
