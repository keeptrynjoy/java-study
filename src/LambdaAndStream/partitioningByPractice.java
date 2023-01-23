package LambdaAndStream;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

class Sawon{
    String name;

    boolean isMale;

    String division;

    int rank;

    int age;

    LocalDate startDate;

    public Sawon(String name, boolean isMale, String division, int rank, int age, LocalDate startDate) {
        this.name = name;
        this.isMale = isMale;
        this.division = division;
        this.rank = rank;
        this.age = age;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getDivision() {
        return division;
    }

    public int getRank() {
        return rank;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %s, %d세, %1d점, %s]",
        name, isMale? "남":"여", division, age, rank, startDate);
    }
}


public class partitioningByPractice {
    public static void main(String[] args) {
        Sawon[] sawonArr = {
            new Sawon("침착맨",true, "기획부",9,43, LocalDate.of(2022,1,1)),
            new Sawon("주호민",true, "재정부",2,45, LocalDate.of(2023,2,1)),
            new Sawon("김풍",true, "인사부",3,48, LocalDate.of(2018,5,1)),
            new Sawon("김혜린",false, "마케팅부",1,37, LocalDate.of(2016,7,1)),
            new Sawon("이혜린",false, "재정부",5,22, LocalDate.of(2019,11,1)),
            new Sawon("장하니",false, "인사부",7,25, LocalDate.of(2011,9,1)),
            new Sawon("이말년",true, "기술부",8,29, LocalDate.of(2012,12,1)),
            new Sawon("주우재",true, "기술부",2,31, LocalDate.of(2020,3,1)),
            new Sawon("손다인",false, "마케팅부",6,33, LocalDate.of(2022,5,1)),
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Sawon>> sawonBySex = Stream.of(sawonArr)
                .collect(partitioningBy(Sawon::isMale));
        List<Sawon> maleSawon = sawonBySex.get(true);
        List<Sawon> falmaleSawon = sawonBySex.get(false);
        for(Sawon s : maleSawon) System.out.println(s);
        for(Sawon s : falmaleSawon) System.out.println(s);


        System.out.printf("%n2. 단순 분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> sawonNumBySex = Stream.of(sawonArr)
                .collect(partitioningBy(Sawon::isMale,counting()));
        System.out.println("남자사원 수 : "+ sawonNumBySex.get(true));
        System.out.println("여자사원 수 : "+ sawonNumBySex.get(false));


        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Sawon>> topRankBySex = Stream.of(sawonArr)
                .collect(partitioningBy(Sawon::isMale,
                        maxBy(comparingInt(Sawon::getRank))
                        )
                );
        System.out.println("남자사원 1등 : " + topRankBySex.get(true));
        System.out.println("여자사원 1등 : " + topRankBySex.get(false));


        System.out.printf("%n4. 다중분할(성별 불합격자, 6점 이하)%n");
        Map<Boolean, Map<Boolean,List<Sawon>>> failedSawonBySex =
                Stream.of(sawonArr).collect(partitioningBy(Sawon::isMale,
                        partitioningBy(s->s.getRank() <=6)));
        List<Sawon> failedMaleSawon = failedSawonBySex.get(true).get(true);
        List<Sawon> failedFemaleSawon = failedSawonBySex.get(false).get(true);

        for(Sawon s : failedMaleSawon) System.out.println(s);
        for(Sawon s : failedFemaleSawon) System.out.println(s);
    }
}
