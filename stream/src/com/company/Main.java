/**
 packageName    : com.company
 fileName       : Main
 author         : ipeac
 date           : 2023-01-19
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-19        ipeac       최초 생성 */
package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 packageName    : com.company
 fileName       : Main
 author         : ipeac
 date           : 2023-01-19
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-19        ipeac       최초 생성 */
public class Main {

    
    
    
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));
    
        List<String> threeHighCaloricDishNames = menu.stream()// 요리에서 스트림을 얻는다.
            .filter(dish -> dish.getCalories()>300) // 파이프라인 연산 만들기, 첫 번째로 고칼로리의 요리를 필터링함.
            .map(Dish::getName) // 요리명을 추출한다.
            .limit(3) // 선착순 3개만 선택한다.
            .collect(Collectors.toList()); // 결과를 리스트로 저장한다.
    }
    
}