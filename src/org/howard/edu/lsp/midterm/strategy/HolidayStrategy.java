package org.howard.edu.lsp.midterm.strategy;

/**
 * Holiday discount (15%)
 */
public class HolidayStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}
