package com.company.ch5.ch8;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.stream.Stream;

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
        
    }
}
