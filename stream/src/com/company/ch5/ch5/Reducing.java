/**
 packageName    : com.company.ch5.ch5
 fileName       : Reducing
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
package com.company.ch5.ch5;

import com.company.ch5.ch1.Filter;

import java.util.Optional;

import static com.company.ch5.ch1.Filter.numbers;

/**
 packageName    : com.company.ch5.ch5
 fileName       : Reducing
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
public class Reducing {
    public static void main(String[] args) {
        /*
        리듀스 연산으로 `메뉴의 모든 칼로리의 합계를 구하시오` 혹은
        `메뉴에서 칼로리가 가장 높은 요리는 ? ` 스트림요소들을 조합해 더 복잡한 질의를 표현하는 방법을 공부한다.
        
        `리듀싱 연산` - > 모든 스트림 요소를 처리해서 값으로 도출한다.
        
        함수형 프로그래밍 언어 용어로는 이 과정이 마치 종이 (스트림) 를 작은 조각이 될 때까지 반복해서 접는 것과 비슷하다는 의미로 ``폴드`` 라고 부린다.
        */
        //5.5.1 요소의 합
        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);
        //identity : sum 변수의 초깃값
        // accumalator -> 두 요소를 조합해서 새로운 값을 만드는 BinaryOperator<T>. 예제에서는 람다 표현식 (a, b) -> a + b를 사 용했다.
        System.out.println("sum = " + sum);
        
        //모든 요소를 곱셈하는 경우
        int product = numbers.stream()
                             .reduce(1, (a, b) -> a * b);
        //1, 2, 1, 3, 3, 2, 4 모두 곱한 값임.
        System.out.println("product = " + product);
        
        // 메서드 참조를 이용한 코드의 간결화
        sum = numbers.stream()
                     .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        
        //초깃값이 없는 reduce
        Optional<Integer> sumOptional = numbers.stream()
                                               .reduce((a, b) -> (a + b));
        
        /*
        왜 Optional을 반환하는가?
        스트림에 아무 요소도 없다면 초기값은 아무값도 없다.. reduce도 합계를 반환할수없어서 NPE 발생함.
        */
        System.out.println("sumOptional = " + sumOptional);
        
        //5.5.2 최댓값과 최솟값
        Optional<Integer> max = numbers.stream()
                                       .reduce(Integer::max);
        System.out.println("max = " + max);
        
        Optional<Integer> min = numbers.stream()
                                       .reduce(Integer::min);
        System.out.println("min = " + min);
        
        //퀴즈
        //map과 reduce 메서드를 이용해서 스트림의 요리 개수를 계산하시오
        Integer cookCount = numbers.stream()
                                   .map(d -> 1)
                                   .reduce(0, (a, b) -> (a + b));
        System.out.println("cookCount = " + cookCount);
        
    }
}
