package org.howard.edu.lsp.midterm.strategy;

/**
 * VIP discount (20%)
 */
public class VipStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
