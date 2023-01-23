/**
 packageName    : com.company.ch5.ch7
 fileName       : NumberTypeStream
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
package com.company.ch5.ch7;

import com.company.ch5.ch1.Dish;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.company.ch5.ch1.Filter.menu;

/**
 packageName    : com.company.ch5.ch7
 fileName       : NumberTypeStream
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
public class NumberTypeStream {
    public static void main(String[] args) {
        int calories = menu.stream()
                           .map(Dish::getCalories)
                           .reduce(0, Integer::sum);
        //reduce 메서드로 스트림 요소의 합을 구할 수 있습니다.
        //해당 코드는  reduce 연산시 내부적으로 합계를 구하기전에 Integer를 기본형으로 언박싱해야하는 ``박싱비용``이 숨어있습니다.
        
        //스트림 API 숫자 스트림을 효율적으로 처리할 수 있는 ``기본 특화 스트림``을 제공합니다.
        
        //5.7.1 기본형 특화 스트림
        //스트림은 박싱 비용을 피할 수 있도록
        // `int 요소에 특화된 IntStream`
        // `long 요소에 특화된 LongStream`을 제공한다.
        // 각각의 인터페이스는 숫자 스트림의 합계를 계산하는 sum, 최댓값 요소를 검색하는 max 같이 자주 사용하는 숫자 관련 리듀싱 연산 수행을 제공한다.
        // + 다시 객체 스트림으로 복원하는 기능도 제공함.
        
        //숫자 스트림으로 매핑
        
        int caloriesIntStream = menu.stream()
                                    .mapToInt(Dish::getCalories)
                                    .sum();
        // mapToInt 메서드는 각 요리에서 모든 칼로리 (Integer 형식)를 추출한 다음에 IntStream 을 반환한다.
        System.out.println("caloriesIntStream = " + caloriesIntStream);
        
        //객체 스트림으로 복원하기
        IntStream intStream = menu.stream()
                                  .mapToInt(Dish::getCalories); // 스트림을 숫자 스트림으로 변환
        Stream<Integer> stream = intStream.boxed(); // 숫자 스트림을 스트림으로 변환
        
        //기본값 : OptionalInt
        /*
        IntStream에서 최댓값을 찾을 때 0이라는 기본값때문에 잘못된 값이 도출될 수 있음.
        스트림에 요소가 없는 상황과 실제 최댓값이 0인 상황을 어떻게 구별할 수 있을까?
        
        Optional을 Integer,  String 등의 참조형식으로 파라미터화 가능
        */
        //OptionalInt
        OptionalInt maxCalories = menu.stream()
                                      .mapToInt(Dish::getCalories)
                                      .max();
        
        int max = maxCalories.orElse(1); // 값이 없는 경우 기본 최댓값을 명시적으로 설정이 가능하다.
        
        System.out.println("maxCalories = " + maxCalories);
        
        //5.7.2 숫자 범위
        /*
        특정 1 에서 100까지 숫자를 생성하는 경우
        */
        IntStream evenNumbeers = IntStream.rangeClosed(1, 100) // [1 , ~ 100] 의 범위를 나타냅니다.
                                          .filter(n -> n % 2 == 0);
        System.out.println(evenNumbeers.count()); // 1 ~ 100 까지는 50개의 짝수가 존재함.
        
        //5.7.3 숫자 스트림 활용 : 피타고라스 수
        
        // 피타고라스 수
        /*
        ! 안녕
        ? 안녕
        * 안녕
        */
        // a*a + b*b = c*c 공식을 만족하는 세 개의 정수 (a,b,c) ..
        
        //세 수 표현하기
        //(3, 4, 5) => new int[]{3, 4, 5}
        
        //좋은 필터링 조합
        // a*a + b*b 제곱근이 정수인지 체크함으로 피타고라스 수의 일부가 될 수 있는 좋은 조합 가능
        
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                                                    .boxed()
                                                    .flatMap(a ->
                                                        IntStream.rangeClosed(a, 100)
                                                                 .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                                                 .mapToObj(b ->
                                                                     new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        
        pythagoreanTriples.limit(5)
                          .forEach(t ->
                              System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        
        // 개선점
        // 현재 코드는 제곱근을 두 번 계산합니다.
        //따라서 (a*a b*b a*a + b*b ) 의 형식을 만족하는 세 수를 만든 다음에
        // 우리가 원하는 조건에 맞는 결과만 필터링하는 것이 더 최적화된 방법이라고 볼 수 있습니다.
        Stream<double[]> pythagoreanTriple2 =
            IntStream.rangeClosed(1, 100)
                     .boxed()
                     .flatMap(a -> IntStream.rangeClosed(a, 100)
                                            .mapToObj(
                                                b -> new double[]{a, b, Math.sqrt(a * a + b * b)}
                                            ) // 만들어진 세 수를 나타냅니다.
                                            .filter(t -> t[2] % 1 == 0)
                     ); // 세 수의 세번째 요소는 반드시 정수여야합니다.
        
    }
}
