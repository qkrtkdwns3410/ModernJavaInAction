package com.company.ch5.ch4;

import com.company.ch5.ch1.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.company.ch5.ch1.Filter.menu;

/**
 packageName    : com.company.ch5.ch4
 fileName       : Saerching
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
public class Searching {
    public static void main(String[] args) {
        // 검색과 매칭
        // 특정 속성이 데이터 집합에 있는지 여부를 검색하는 데이터 처리
        //5.4.1 프레디케이트가 적어도 한 요소와 일치하는지 확인
        if (menu.stream()
                .anyMatch(Dish::isVegetarian)) {
            System.out.println("메뉴는 채식임 ㅇㅇ");
        } // 주어진 스트림에서 menu에 채식요리가 있는지 확인한다.
        // 불리언 반환
        
        // 5.4.2 프레디케이트가 모든 요소와 일치하는지 검사
        boolean isHealthy = menu.stream()
                                .allMatch(dish -> dish.getCalories() < 1000);
        //모든 요리가 1000칼로리 이하면 건강식으로 간주.
        
        //NONEMATCH
        boolean isHealthy2 = menu.stream()
                                 .noneMatch(d -> d.getCalories() >= 1000);
        //모두 1000이상의 칼로리를 가진 메뉴가 없다면 boolean true 반환
        // 앞의 allMatch와 반대되는 체인메서드임.
        /*anyMatch, allMatch, noneMatch 세 메서드는 스트림 쇼트서킷 기법, 즉 자바의 &&, ||와 같은 연산을 활용한다.*/
        
        //쇼트서킷 =>  모든 스트림의 요소를 돌지않고 중간에 해당하지않는 요소가 등장하는경우 내부순회를 멈추고 결과를 반환한다
        
        //5.4.3. 요소 검색
        Optional<Dish> dish = menu.stream()
                                  .filter(Dish::isVegetarian)
                                  .findAny();
        System.out.println("dish = " + dish);
        //findAny 메서드는 현재 스트림에서 임의의 요소를 반환
        //스트림 파이프라인은 내부적으로 단일 과정으로 실행할 수 있도록 최적화된다.
        // 즉, 쇼트서킷을 이용해서 결과를 찾는 즉시 실행을 종료한다
        
        //5.4.4 첫번째 요소 찾기
        // 논리적인 아이템 순서가 정해진 경우 해당 스트림에서 어떻게 첫번쨰 요소를 찾을까?
        //findFirst() 사용
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        //숫자 리스트에서 3으로 나누어떨어지는  첫번째 제곱값을 반환하는 코드
        Optional<Integer> firstSquareDibisibleByThree = someNumbers.stream()
                                                                   .map(n -> n * n)
                                                                   .filter(n -> n % 3 == 0)
                                                                   .findFirst();
        System.out.println("firstSquareDibisibleByThree = " + firstSquareDibisibleByThree);
        
        /*
        findFirst와 findAny 언제 사용할까?
        findFirst의 경우 논리적인 아이템 순서가 있는 경우 사용한다. 하지만 findAny 의 경우 순서가 상관없이 임의의 요소를 추출한다.
        
        둘은 병렬성에 차이가 있다. 병렬 실행에서는 첫 번째 요소를 탐색하기 어렵기에 제약이 적은 findAny를 주로 사용하며, 순차가 중요한 경우 findFirst를 사용한다.
        */
        
    }
}
