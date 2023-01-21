package com.company.ch5.ch2;

import com.company.ch5.ch1.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 packageName    : com.company.ch5.ch2
 fileName       : StreamSlicing
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
public class StreamSlicing {
    public static void main(String[] args) {
        // 프레디케이트를 이용한 슬라이싱
        List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));
        
        // filter연산으로 전체 스트림을 반복하면서 각 요소에 프레디케이트를 적용한다.
        List<Dish> filteredMenu = specialMenu.stream()
                                             .filter(dish -> dish.getCalories() < 320)
                                             .collect(toList());
        System.out.println("filteredMenu = " + filteredMenu);
        
        //아주 많은 요소를 포함하는 큰 스트림은 어떻게 처리할까?
        //takeWhile 연산을 이용한다. -> 무한스트림 .. 등의 모든 스트림을 슬라이싱할수있다.
        List<Dish> slicedMenu1 = specialMenu.stream()
                                            .takeWhile(dish -> dish.getCalories() < 320)
                                            .collect(toList());
        System.out.println("slicedMenu1 = " + slicedMenu1);
        
        //DROPWHILE 활용
        //320칼로리보다 큰 요소는 어떻게 탐색하나?
        List<Dish> slicedMenu2 = specialMenu.stream()
                                            .dropWhile(dish -> dish.getCalories() < 320)
                                            .collect(toList());
        
        System.out.println("slicedMenu2 = " + slicedMenu2);
        //DROPWHILE은 takeWhile 과 정반대의 작업을 수행한다.
        //프레디케이트가 처음으로 거짓이 되는 지점까지 발견된 요소를 버린다.
        // 프레디케이트가 거짓이 되면 그 지점에서 작업을 중단하고 남은 모든 요소를 반환한다.
        //dropWhile은 무한한 남은 요소를 가진 무한 스트림에서 도 동작한다
        
        
        //5.2.2 스트림 축소
        List<Dish> dishes = specialMenu.stream()
                                       .filter(dish -> dish.getCalories() > 300)
                                       .limit(3)
                                       .collect(toList());
        // 스트림이 정렬되어있다면 최대 요소 n 개를 반환가능
        // 프레디케이트와 일치하는 처음 세 요소를 선택한 다음 즉시 결과 반환
        System.out.println("dishes = " + dishes);
        
        //정렬되지 않은 스트림(set) 에도 limit 사용가능 소스가  정렬되어 있지 않았다면 결과도 정렬 X
        
        //5.2.3 요소 건너뛰기
        // 처음 n 개 요소를 제외한 스트림을 반환하는 skip(n) 메서드를 지원. n 개 이하의 요소를 포함하는 스트림에 skip(n)호출시 빈 스트림 반환
    
        List<Dish> dishes2 = specialMenu.stream()
                                        .filter(d -> d.getCalories() > 300)
                                        .skip(2)
                                        .collect(toList());
    
        System.out.println("dishes2 = " + dishes2); // 앞에 2개 스킵함.
        
        // 퀴즈 - 스트림을 이용하여 처음 등장하는 두 고기 요리를 필터링하시오.
        List<Dish> quiz = specialMenu.stream()
                                     .filter(d -> d.getType() == Dish.Type.MEAT)
                                     .limit(2)
                                     .collect(toList());
    
        System.out.println("quiz = " + quiz);
    }
}
