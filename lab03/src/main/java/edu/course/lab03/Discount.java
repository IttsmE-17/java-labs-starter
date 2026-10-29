package edu.course.lab03;

public class Discount {

    public interface DiscountPolicy {
        double apply(double price);
    }

    public static class NoDiscount implements DiscountPolicy {
        @Override
        public double apply(double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price can't be below 0");
            }

            return price;
        }
    }
    
    public static class PercentDiscount implements DiscountPolicy {
        private final double percent;

        public PercentDiscount(int percent) {
            if (0 > percent || percent > 100) {
                throw new IllegalArgumentException("percent must be bigger than 0 and less than 100");
            }

            this.percent = percent;
        }

        @Override
        public double apply(double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price can't be below 0");
            }

            return price * ( 1 - (percent / 100));
        }
    }

}
