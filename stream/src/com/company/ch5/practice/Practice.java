/**
 packageName    : com.company.ch5.practice
 fileName       : Practice
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
package com.company.ch5.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 packageName    : com.company.ch5.practice
 fileName       : Practice
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
public class Practice {
    
    public static void main(String[] args) {
        
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
        
        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        
        List<Transaction> number1 = transactions.stream()
                                                .filter(transaction -> transaction.getYear() == 2011)
                                                .sorted(Comparator.comparing(Transaction::getValue))
                                                .collect(Collectors.toList());
        System.out.println("number1 = " + number1);
        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> number2 = transactions.stream()
                                           .map(transaction -> transaction.getTrader()
                                                                          .getCity())
                                           .distinct()
                                           .collect(Collectors.toList());
        System.out.println("number2 = " + number2);
        
        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        List<Trader> number3 = transactions.stream()
                                           .map(Transaction::getTrader)
                                           .filter(trader -> trader.getCity()
                                                                   .equals("Cambridge"))
                                           .distinct()
                                           .sorted(Comparator.comparing(Trader::getName))
                                           .collect(Collectors.toList());
        
        System.out.println("number3 = " + number3);
        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        List<String> number4 = transactions.stream()
                                           .map(transaction -> transaction.getTrader()
                                                                          .getName())
                                           .distinct()
                                           .sorted()
                                           .collect(Collectors.toList());
        
        System.out.println("number4 = " + number4);
        // 5. 밀라노에 거래자가 있는가?
        boolean number5 = transactions.stream()
                                      .anyMatch(transaction -> transaction.getTrader()
                                                                          .getCity()
                                                                          .equals("Milan"));
        System.out.println("number5 = " + number5);
        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        transactions.stream()
                    .filter(transaction -> transaction.getTrader()
                                                      .getCity()
                                                      .equalsIgnoreCase("cambridge"))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);
        // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
        Optional<Integer> maxValue = transactions.stream()
                                                 .map(Transaction::getValue)
                                                 .reduce(Integer::max);
        System.out.println("maxValue = " + maxValue);
        // 8. 전체 트랜잭션 중 최솟값은 얼마인가?
        Optional<Integer> minValue = transactions.stream()
                                                 .map(Transaction::getValue)
                                                 .reduce(Integer::min);
        System.out.println("minValue = " + minValue);
    }
}
