package org.howard.edu.lsp.midterm.strategy;

/**
 * Regular customer (no discount)
 */
public class RegularStrategy implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price;
    }
}
