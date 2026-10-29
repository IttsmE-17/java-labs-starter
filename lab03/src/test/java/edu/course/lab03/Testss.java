package edu.course.lab03;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class Testss {
    @Test 
    void exceptionForNeagtivePrice() {
        Discount.NoDiscount price = new Discount.NoDiscount();
        
        assertThrows(IllegalArgumentException.class,
                    () -> price.apply(-12.5)
                    );
    }
    @Test 
    void trueForNotNegativePrice() {
        Discount.NoDiscount price = new Discount.NoDiscount();
        double result = price.apply(12.0);
        
        assertEquals(12.0, result, 0.001);
    }
    @Test 
    void TrueForSuccessfulPercentDiscount() {
        Discount.PercentDiscount percent = new Discount.PercentDiscount(20);
        double price = percent.apply(100.0);

        assertEquals(80.0, price, 0.001);
    }
    @Test
    void exceptionForNeagtivePercent() {        
        assertThrows(IllegalArgumentException.class,
                    () -> new Discount.PercentDiscount(-20)
                    );
    }
    @Test 
    void calculatorNoDiscount() {
        var nodisc = new Discount.NoDiscount();
        var price = new PriceCalculator(nodisc);
        
        assertEquals(100.0, price.calculate(100.0));
    }
    @Test 
    void calculatorPercent() {
        var percent = new Discount.PercentDiscount(20);
        var price = new PriceCalculator(percent);

        assertEquals(80.0, price.calculate(100), 0.001);
    }
    @Test 
    void policySwitchTest() {
        var policy = new Discount.NoDiscount();
        var newPolicy = new Discount.PercentDiscount(25);
        var price = new PriceCalculator(policy);
        assertEquals(100.0, price.calculate(100.0), 0.001);

        price = new PriceCalculator(newPolicy);
        assertEquals(75.0, price.calculate(100.0), 0.001);
    }
// #################### Normalization ####################
    @Test
    void minMaxNormalizationTest() {
        var normalization = new Normalizer.MinMaxNormalization();

        double[] result = normalization.normalize(new double[]{10, 20, 30});

        assertArrayEquals(new double[]{0, 0.5, 1}, result, 0.001);
    }

    @Test
    void minMaxDoesNotChangeOriginalArrayTest() {
        var normalization = new Normalizer.MinMaxNormalization();
        double[] values = {10, 20, 30};

        normalization.normalize(values);

        assertArrayEquals(new double[]{10, 20, 30}, values, 0.001);
    }

    @Test
    void meanCenteringNormalizationTest() {
        var normalization = new Normalizer.MeanCenteringNormalization();

        double[] result = normalization.normalize(new double[]{10, 20, 30});

        assertArrayEquals(new double[]{-10, 0, 10}, result, 0.001);
    }

    @Test
    void meanCenteringDoesNotChangeOriginalArrayTest() {
        var normalization = new Normalizer.MeanCenteringNormalization();
        double[] values = {10, 20, 30};

        normalization.normalize(values);

        assertArrayEquals(new double[]{10, 20, 30}, values, 0.001);
    }

    @Test
    void strategySwitchTest() {
        var minMax = new Normalizer(new Normalizer.MinMaxNormalization());
        var meanCentering = new Normalizer(new Normalizer.MeanCenteringNormalization());

        assertArrayEquals(new double[]{0, 0.5, 1},
                        minMax.process(new double[]{10, 20, 30}), 0.001
                        );
        assertArrayEquals(new double[]{-10, 0, 10},
                        meanCentering.process(new double[]{10, 20, 30}), 0.001
                        );
    }
}
