package com.company.ch5.ch8;

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
    }
}
