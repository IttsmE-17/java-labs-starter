package edu.course.lab02;

import java.util.Arrays;

public class DataSample {

    public enum SampleStatus {
    NEW,
    READY,
    PROCESSED
    }

    private final String id;
    private final String label;
    private SampleStatus status;
    private final double[] features;
    
    public DataSample(String id, String label, SampleStatus status, double[] features) {
        if (id == null || id.isBlank() || label == null || label.isBlank() || status == null || features == null) {
            throw new IllegalArgumentException("Обязательные к заполнению ID/Label/Status/Features пусты или равны null");
        }
        this.id = id;
        this.label = label;
        this.status = status;
        this.features = Arrays.copyOf(features, features.length);
    }

    public void changeStatus(SampleStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Status пуст или равен null");
        }
        
        status = newStatus;
    }

    public boolean checkIfReady() {
        return status == SampleStatus.READY;
    }
    
    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public SampleStatus getStatus() {
        return status;
    }

    public double[] getFeatures() {
        return Arrays.copyOf(features, features.length);
    }
    
    public double getAverageFeatures() {
        return Arrays.stream(features).average().orElseThrow();
    }

    public double[] normalization() {
        double mx = features[0];
        double mn = features[0];

        for (double feature : features) {
            if (mx < feature) {
                mx = feature;
            }

            if (mn > feature) {
                mn = feature;
            }
        }
        double[] normalized = new double[features.length];
        
        if (mx == mn) {
            return normalized;
        }

        for (int i = 0; i < features.length; i++) {
            normalized[i] = (features[i] - mn) / (mx - mn);
        }

        return normalized;
    }
}
