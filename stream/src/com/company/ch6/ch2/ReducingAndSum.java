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

import com.company.ch5.ch1.Filter;

import java.util.stream.Collectors;

import static com.company.ch5.ch1.Filter.menu;
import static java.util.stream.Collectors.counting;

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
        
    }
}
