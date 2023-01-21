/**
 packageName    : com.company.ch5.practice
 fileName       : Trader
 author         : ipeac
 date           : 2023-01-21
 description    :
 ===========================================================
 DATE              AUTHOR             NOTE
 -----------------------------------------------------------
 2023-01-21        ipeac       최초 생성 */
package com.company.ch5.practice;

/**
 *packageName    : com.company.ch5.practice
 * fileName       : Trader
 * author         : ipeac
 * date           : 2023-01-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-21        ipeac       최초 생성
 */
public class Trader {
    private final String name;
    private final String city;
    
    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String toString() {
        return "Trader:" + this.name +
    } " in "+this.city;
}
