package polymorphism;

import java.util.ArrayList;

class Clothes {

}

class Top extends Clothes {

    public Top(String top) {
    }
}

class Pants extends Clothes {

    public Pants(String pants) {
    }
}



public class Main2 {
    public static void main(String[] args) {

        /* 자료형 다형성 : Clothes 라는 자료형으로 묶어 코드를 압축 */
        ArrayList<Clothes> clothes = new ArrayList<>();
        clothes.add(new Top("T-shirt"));
        clothes.add(new Pants("jean"));
        clothes.forEach(each-> System.out.println(each));
    }
}
