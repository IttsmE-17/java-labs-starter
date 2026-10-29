package edu.course.lab03;

public class Normalizer {
    private final NormalizationStrategy strategy;
    
    public interface NormalizationStrategy {
        double[] normalize(double[] values);
    }

    public Normalizer(NormalizationStrategy strategy) {
        this.strategy = strategy;
    }
    public double[] process(double[] values) {
        return strategy.normalize(values);
    }
    // min-max
    public static class MinMaxNormalization implements NormalizationStrategy {
        @Override
        public double[] normalize(double[] values) {
            double[] result = new double[values.length];

            if (values.length == 0) {
                return result;
            }

            double min = values[0];
            double max = values[0];

            for (double value : values) {
                min = Math.min(min, value);
                max = Math.max(max, value);
            }

            if (max == min) {
                return result;
            }

            for (int i = 0; i < values.length; i++) {
                result[i] = (values[i] - min) / (max - min);
            }

            return result;
        }
    }
    // mean centering
    public static class MeanCenteringNormalization implements NormalizationStrategy {
        @Override
        public double[] normalize(double[] values) {
            double[] result = new double[values.length];
            if (values.length == 0) {
                return result;
            }

            double sum = 0;

            for (double value : values) {
                sum += value;
            }
            double mean = sum / values.length;

            for (int i = 0; i < values.length; i++) {
                result[i] = values[i] - mean;
            }

            return result;
        }
    }    
}
