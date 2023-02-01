/**
 packageName    : com.company.ch6.ch2
 fileName       : ReducingAndSum
 author         : ipeac
 date           : 2023-01-29
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-29        ipeac       최초 생성 */
package com.company.ch6.ch2;

import com.company.ch5.ch1.Dish;
import com.company.ch5.ch1.Filter;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.company.ch5.ch1.Filter.menu;
import static java.util.stream.Collectors.*;

/**
 packageName    : com.company.ch6.ch2
 fileName       : ReducingAndSum
 author         : ipeac
 date           : 2023-01-29
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-29        ipeac       최초 생성 */
public class ReducingAndSum {
    public static void main(String[] args) {
        Long howManyDishes = menu.stream()
                                 .collect(counting());
        System.out.println("howManyDishes = " + howManyDishes);
        
        System.out.println("======================================================");
        
        long howManyDishes1 = menu.stream()
                                  .count();
        System.out.println("howManyDishes1 = " + howManyDishes1);
        
        //!6.2.1 스트림 값에서 최댓값과 최솟값의 검색
        
        //메뉴에서 칼로리가 가장 높은 요리를 찾는다.
        // Collectors.maxBy , Collectors.minBy 두 개의 메서드드 이용해서 스트림의 최댓값과 최솟값 계산가능
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
                                             .collect(maxBy(dishCaloriesComparator));
        
        //Optional<Dish> 는 무슨 역할을 수행하는가?
        /*
        자바 8의 경우 포함하거나 또는 포함하지 않을 수 있는 컨테이너 Optional 제공.
        */
        
        //! 6.2.2 요약 연산
        /*
        Collectors.summingInt 라는 특별한 요약 팩토리 메서드를 제공함.
        summingInt는 객체를 int 로 매핑하는 함수를 인수로 받습니다.
        summingInt의 인수로 전달된 함수는 객체를 int로 매핑한 컬렉터를 반환함.
        */
        //메뉴 리스트의 총 칼로리 계산하는 코드
        int totalCalories = menu.stream()
                                .collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories = " + totalCalories);
        
        //joininng 메서드는는 내부적으로 StringBuilder 를 이용해 문자열을 하나로 만듬.
        String shortMenu = menu.stream()
                               .collect(joining());
        
    }
}
