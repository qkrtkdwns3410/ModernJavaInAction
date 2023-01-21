/**
 packageName    : com.company.ch5.practice
 fileName       : Transaction
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
package com.company.ch5.practice;

/**
 packageName    : com.company.ch5.practice
 fileName       : Transaction
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    
    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    
    public Trader getTrader() {
        return this.trader;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}
