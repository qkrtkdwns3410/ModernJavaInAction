package com.company.ch5.ch3;

import com.company.ch5.ch1.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 packageName    : com.company.ch5.ch3
 fileName       : Mapping
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
public class Mapping {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));
        // 특정 객체에서 특정 데이터를 선택하는 작업.
        //스트림 API map과 flatMap 메서드는 특정 데이터를 선택하는 기능 제공.
        
        //5.3.1 스트림의 각 요소에 함수 적용하기
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        
        //각 요리명의 길이 파악
        List<Integer> dishNameLengths = specialMenu.stream()
                                                   .map(Dish::getName)
                                                   .map(String::length)
                                                   .collect(Collectors.toList());
        
        System.out.println("dishNameLengths = " + dishNameLengths);
        
        // 5.3.2 스트림 평면화
        // 리스트에서 고유 문자로 이루어진 리스트 반환
        List<String[]> returnString = words.stream()
                                           .map(word -> word.split(""))
                                           .distinct()
                                           .collect(Collectors.toList());
        
        //해당 returnString 은 String[] 를 반환하기에..
        String[] arrayOfWords = {"GoodBye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        
        //Arrays.stream() 메서드 적용 ->
        List<Stream<String>> returnStream = words.stream()
                                                 .map(word -> word.split("")) // 각 단어를 개별 문자열 배열로 변환
                                                 .map(Arrays::stream) // 각 배열을 별도의 스트림으로 생성
                                                 .distinct()
                                                 .collect(Collectors.toList());
        
        System.out.println("returnStream = " + returnStream);
        
        // 스트림 리스트가.. 생성된.. 문제가 해결되지 않음.
        //문제 해결을 위해 각 단어를 개별 문자열로 이루어진 배열로 만든 후 각 배열을 별도의 스트림으로 만들어야함.
        
        //flatMap
        List<String> uniqueCharacters = words.stream()
                                             .map(word -> word.toLowerCase()
                                                              .split(""))// 각 단어를 개별 문자를 포함하는 배열로 변환
                                             .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
                                             .distinct()
                                             .collect(Collectors.toList());
        System.out.println("uniqueCharacters = " + uniqueCharacters);
        
        //퀴즈
        //1. 숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오.
        // 예를 들어 [1, 2, 3, 4, 5]가 주어지면 [1, 4, 9, 16, 25]를 반환해야 한다
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());
        System.out.println("squares = " + squares);
        
        //두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오.
        // 예를 들어 두 개의 리스 트 [1, 2, 3]과 [3, 4]가 주어지면 [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]를 반환해야 한 다.
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> pairs = number1.stream()
                                   .flatMap(i -> number2.stream()
                                                        .map(j -> new int[]{i, j}))
                                   .collect(Collectors.toList());
        
        System.out.println("pairs = " + pairs);
        
        // 이전 예제에서 합이 3으로 나누어떨어지는 쌍만 반환하려면..? (2,4) , (3,3)
        List<int[]> pairs2 = number1.stream()
                                    .flatMap(i -> number2.stream()
                                                         .filter(j -> (i + j) % 3 == 0)
                                                         .map(j -> new int[]{i, j}))
                                    .collect(Collectors.toList());
        
        System.out.println("pairs2 = " + pairs2);
        
    }
}
