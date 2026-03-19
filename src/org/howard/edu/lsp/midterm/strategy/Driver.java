package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to test strategies
 */
public class Driver {
    public static void main(String[] args) {
        double price = 100.0;

        PriceCalculator regular = new PriceCalculator(new 
RegularStrategy());
        PriceCalculator member = new PriceCalculator(new 
MemberStrategy());
        PriceCalculator vip = new PriceCalculator(new VipStrategy());
        PriceCalculator holiday = new PriceCalculator(new 
HolidayStrategy());

        System.out.println("REGULAR: " + regular.calculatePrice(price));
        System.out.println("MEMBER: " + member.calculatePrice(price));
        System.out.println("VIP: " + vip.calculatePrice(price));
        System.out.println("HOLIDAY: " + holiday.calculatePrice(price));
    }
}
