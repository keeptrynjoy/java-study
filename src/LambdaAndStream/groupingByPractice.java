package LambdaAndStream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Sawon2{
    String name;

    boolean isMale;

    String division;

    int rank;

    int age;

    LocalDate startDate;

    public Sawon2(String name, boolean isMale, String division, int rank, int age, LocalDate startDate) {
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

    enum Level{HIGH, MID, LOW} // rank 를 상, 중, 하 세 단계로 분류
}
public class groupingByPractice {
    public static void main(String[] args) {

        Sawon2[] sawonArr = {
                new Sawon2("침착맨",true, "기획부",9,43, LocalDate.of(2022,1,1)),
                new Sawon2("주호민",true, "기획부",8,45, LocalDate.of(2022,2,1)),
                new Sawon2("김풍",true, "인사부",7,48, LocalDate.of(2022,5,1)),
                new Sawon2("김혜린",false, "마케팅부",6,37, LocalDate.of(2022,7,1)),
                new Sawon2("이혜린",false, "기획부",9,22, LocalDate.of(2022,11,1)),
                new Sawon2("장하니",false, "인사부",7,25, LocalDate.of(2022,9,1)),
                new Sawon2("이말년",true, "기술부",8,29, LocalDate.of(2022,12,1)),
                new Sawon2("주우재",true, "기술부",8,31, LocalDate.of(2022,3,1)),
                new Sawon2("손다인",false, "마케팅부",9,33, LocalDate.of(2022,5,1)),

                new Sawon2("블랙맨",true, "기획부",1,43, LocalDate.of(2011,1,1)),
                new Sawon2("유하이",true, "기획부",2,45, LocalDate.of(2011,2,1)),
                new Sawon2("해스터",true, "인사부",1,48, LocalDate.of(2011,5,1)),
                new Sawon2("제임스",false, "마케팅부",3,37, LocalDate.of(2011,7,1)),
                new Sawon2("쿨제이",false, "기획부",1,22, LocalDate.of(2011,11,1)),
                new Sawon2("영한이",false, "인사부",5,25, LocalDate.of(2011,9,1)),
                new Sawon2("윤철이",true, "기술부",3,29, LocalDate.of(2011,12,1)),
                new Sawon2("승윤우",true, "기술부",4,31, LocalDate.of(2011,3,1)),
                new Sawon2("지순자",false, "마케팅부",5,33, LocalDate.of(2011,5,1)),
        };

        System.out.printf("1. 단순 그룹화(부서별 그룹화)%n");
        Map<String, List<Sawon2>> sawonByDivision = Stream.of(sawonArr)
                .collect(groupingBy(Sawon2::getDivision));
        for(List<Sawon2> division : sawonByDivision.values())
            for(Sawon2 s: division) System.out.println(s);

        System.out.printf("%n2. 단순 그룹화( rank 별로 그룹화)%n");
        Map<Sawon2.Level, List<Sawon2>>  sawonByLevel = Stream.of(sawonArr)
                .collect(groupingBy(s->{
                    if(s.getRank() >= 8) return Sawon2.Level.HIGH;
                    else if (s.getRank() >= 6) return Sawon2.Level.MID;
                    else return Sawon2.Level.LOW;
                }));
        TreeSet<Sawon2.Level> keySet = new TreeSet<>(sawonByLevel.keySet());
        for(Sawon2.Level key : keySet){
            System.out.println("["+key+"]");
            for(Sawon2 s : sawonByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }


        System.out.printf("%n3. 단순그룹화 + 통계(rank 별 사원수)%n");
        Map<Sawon2.Level, Long> sawonCntByLevel = Stream.of(sawonArr)
                .collect(groupingBy(s->{
                    if(s.getRank() >= 8) return Sawon2.Level.HIGH;
                    else if(s.getRank() >= 6) return Sawon2.Level.MID;
                    else return Sawon2.Level.LOW;
                },counting()));
        for(Sawon2.Level key : sawonCntByLevel.keySet())
            System.out.printf("[%s] - %d명 ", key, sawonCntByLevel.get(key));
        System.out.println();


        System.out.printf("%n4. 다중그룹화(부서별, 입사년도별)%n");
        Map<String, Map<Object,List<Sawon2>>> sawonByDivisionAndStart =
                Stream.of(sawonArr)
                        .collect(groupingBy(Sawon2::getDivision,
                                groupingBy(s->s.getStartDate().getYear())
                                ));
        for(Map<Object, List<Sawon2>> division : sawonByDivisionAndStart.values()){
            for(List<Sawon2> startDate : division.values()){
                System.out.println();
                for (Sawon2 s : startDate)
                    System.out.println(s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(부서별, 입사연차별 1등)%n");
        Map<String, Map<Object, Sawon2>> topSawonByDivisionAndStart =
                Stream.of(sawonArr)
                        .collect(groupingBy(Sawon2::getDivision,
                                groupingBy(s-> s.getStartDate().getYear(),
                                        collectingAndThen(
                                                maxBy(Comparator.comparingInt(Sawon2::getRank))
                                                ,Optional::get)
                                        )
                                ));
        for(Map<Object,Sawon2> division : topSawonByDivisionAndStart.values())
            for(Sawon2 s : division.values())
                System.out.println(s);

        System.out.printf("%n6. 다중그룹화 + 통계(부서별, 입사년도별 성적그룹)%n");
        Map<String, Set<Sawon2.Level>> sawonByRankGroup = Stream.of(sawonArr)
                .collect(groupingBy(s->s.getDivision() + " / " + s.getStartDate().getYear(),
                        mapping(s->{
                            if(s.getRank()>=8) return Sawon2.Level.HIGH;
                            else if(s.getRank() >= 6) return Sawon2.Level.MID;
                            else return Sawon2.Level.LOW;
                        },toSet())
                        ));
        Set<String> keySet2 = sawonByRankGroup.keySet();

        for(String key : keySet2){
            System.out.println("["+key+"]" + sawonByRankGroup.get(key));
        }
    }

}
