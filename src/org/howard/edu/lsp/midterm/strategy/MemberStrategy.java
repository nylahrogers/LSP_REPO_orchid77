package org.howard.edu.lsp.midterm.strategy;

/**
 * Member discount (10%)
 */
public class MemberStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}
