package polymorphism;

class Samsung{
    String product = "ElectronicProducts";
}

class Naver{
    String product = "OnlinePlatform";
}

class Hynudai{
    String product = "Car";
}

class Product{

    void product(Samsung samsung){
        System.out.println(samsung.product);
    }

    void product(Naver naver){
        System.out.println(naver.product);
    }

    void product(Hynudai hynudai){
        System.out.println(hynudai.product);
    }
}

public class Main3 {

    public static void main(String[] args) {
        /* 매개변수 다형성 : 메서드 오버로딩 */
        Samsung samsung = new Samsung();
        Naver naver = new Naver();
        Hynudai hynudai = new Hynudai();

        Product company = new Product();
        company.product(samsung);
        company.product(naver);
        company.product(hynudai);

    }
}
