package edu.course.lab03;

public class PriceCalculator {
    private final Discount.DiscountPolicy policy;

    public PriceCalculator(Discount.DiscountPolicy policy) {
        this.policy = policy;
    }

    public double calculate(double price) {
        return policy.apply(price);
    }
}
