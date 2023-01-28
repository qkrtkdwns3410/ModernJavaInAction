package com.company.ch5.ch8;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 packageName    : com.company.ch5.ch8
 fileName       : MakeStream
 author         : ipeac
 date           : 2023-01-23
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-23        ipeac       최초 생성 */
public class MakeStream {
    public static void main(String[] args) {
        //! 5 . 스트림 만들기
        
        //! 5.8.1 값으로 스트림 만들기
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase)
              .forEach(System.out::println);
        
        //! 5.8.2 null 이 될 수 있는 객체로 스트림 만들기
        // 자바 9에서는 null이 될 수 있는 개체를 스트림으로 만들 수 있는 새로운 메서드가 추가됨.
        // null
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);
        System.out.println("homeValueStream = " + homeValueStream);
        //==
        Stream<String> homeValueStreamNullSafe = Stream.ofNullable(System.getProperty("home"));
        System.out.println("homeValueStreamNullSafe = " + homeValueStreamNullSafe);
        
        //null  + flatMap
        Stream<String> values = Stream.of("config", "home", "user")
                                      .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        
        //! 5.8.3 배열로 스트림 만들기
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers)
                        .sum();
        System.out.println("sum = " + sum);
        
        //5.8.4 파일로 스트림 만들기
        /*
        파일을 처리하는 등의 I/O 연산에 사용하는 자바 NIO ( 논블로킹 IO ) 도 스트림 API를 활용가능..
        이건 쓸모없을거같아서 그냥 패스할게여
        */
        //! 5.8.5 함수로 무한 스트림 만들기
        /*
         크기가 고정되지 않은 스트림을 만들 수 있음.
         iterate 와 generate에서 만든 스트림은 요청시 마다 주어진 함수를 이용해서 값을 만듬.
         */
        
        // ! iterate 메서드
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);
        //무한 스트림임.
        /*
        0 부터 시작해서 +2 로 짝수의 값을 무한 스트림 형태로 .. 만들고 limit로 값을 제한해서 출력한다.
        무한 스트림  == 언바운드 스트림이라고도 한다.
        
        */
        System.out.println("======================================================");
        // ? 퀴즈 5-4 피보나치 수열 집합
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[1] + t[0]})
              .limit(20)
              .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
        
        //! generate 메서드
        Stream.generate(Math::random)
              .limit(5)
              .forEach(System.out::println);
        
        System.out.println("======================================================");
        
        /*
        generate 를 어떤 상황에서 사용하느냐?
        -> iterate와 달리 생성된 값을 연속적으로 계산하지 않음.
        
        연속된 일련의 값을 생성시 -> iterate 사용
        병렬 처리처럼 상태가 없어야하는 경우 -> generate 사용
        
        스트림을 병렬처리 + 올바른 값 얻으려면 -> 상태가 없어야함
        */
        /*! 정리*/
        /*
        filter(조건) , distinct(중복제거), takeWhile (무한 스트림을 포함한 모든 스트림에 `Predicate` 적용가능 :: 슬라이싱)
        dropWhile
        skip()
        limit()
        */
        // takeWhile
        System.out.println("======================================================");
        List<Integer> numberList = Arrays.asList(12, 11, 10, 13, 15, 41, 44, 50, 76, 80);
        List<Integer> collect = numberList.stream()
                                          .takeWhile(i -> i < 50) // 50 미만의 숫자만
                                          .collect(toList());
        
        System.out.println("collect = " + collect);
        System.out.println("======================================================");
        //dropWhile
        List<Integer> collect1 = numberList.stream()
                                           .dropWhile(i -> i < 50) // 50이상의 숫자 해당 조건 반대 조건만 다 들고온다.
                                           .collect(toList());
        System.out.println("collect1 = " + collect1);
        System.out.println("======================================================");
        //skip
        /*
        처음 n 개의 요소를 제외한 스트림 반환한다. limit() 와 상호 보완적
        */
        List<Integer> collect2 = numberList.stream()
                                           .filter(i -> i % 2 == 0)
                                           .skip(1)
                                           .collect(toList());
        numberList.stream()
                  .filter(i -> i % 2 == 0)
                  .skip(0)
                  .forEach(System.out::println);
        // 출력시 12 부분은 skip 된채 연산된다.
        System.out.println("collect2 = " + collect2);
        System.out.println("======================================================");
        
    }
}
