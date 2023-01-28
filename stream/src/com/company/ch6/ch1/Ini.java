/**
 packageName    : com.company.ch6.ch1
 fileName       : Ini
 author         : ipeac
 date           : 2023-01-28
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-28        ipeac       최초 생성 */
package com.company.ch6.ch1;

import java.io.Serializable;

/**
 packageName    : com.company.ch6.ch1
 fileName       : Ini
 author         : ipeac
 date           : 2023-01-28
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-28        ipeac       최초 생성 */
public class Ini {
    public static void main(String[] args) {
        // ! 6-1 컬렉터란 무엇인가>
        /*
        Collector 인터페이스의 구현은 스트림의 요소를 어떤 식으로 도출할지 지정한다.
        */
        // ! 6.1.1 고급 리듀싱 기능을 수행하는 컬렉터
        /*
        함수형 API 의 장점으로 높은 수준의 조합성과 재사용성을 꼽을 수 있음
        collect 결과로 결과를 수집하느 과정을 간단하면서도 유연한 방식으로 정의가능
        
        collect에서는 리듀싱 연산을 이용하여 스트림의 각 요소를 방문하며 -> 컬렉터가 작업을 처리함
        */
        
        // ! 6.1.2. 미리 정의된 컬렉터
        /*
        groupingBy 같이 Collectors 클래스에서 제공하는 팩토리 메서드의 기능을 설명
        Collectors 에서 제공하는 메서드의 기능은 크게 3가지로 분류가능하다.
        1. 스트림 요소를 하나의 값으로 리듀스하고 요약
        2. 요소 그룹화
        3. 요소 분할
        
        
        */
    }
}
