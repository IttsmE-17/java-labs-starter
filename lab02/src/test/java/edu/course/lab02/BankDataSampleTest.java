package edu.course.lab02;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class BankDataSampleTest {
// ########## BankAccount ###########
    @Test 
    void incorrectBalanceException() {      
        assertThrows(IllegalArgumentException.class,
                    () -> new BankAccount(-100)
                    );
    }
    @Test 
    void succesfulWithdraw() {
        BankAccount bank = new BankAccount(1000);

        bank.withdraw(250);

        assertEquals(750, bank.getBalance());
    }
    @Test 
    void overwithdrawException() {
        BankAccount bank = new BankAccount(1000);

        assertThrows(IllegalArgumentException.class,
                    () -> bank.withdraw(1100)
                    );
    }
// ########## DataSample ###########
    @Test 
    void nullIdException() {
        assertThrows(IllegalArgumentException.class,
                    () -> new DataSample(null, "Material", DataSample.SampleStatus.NEW, new double[]{2.0, 3.5, 4.5})
                    );
    }
    @Test 
    void emptyLabelException() {
        assertThrows(IllegalArgumentException.class,
                    () -> new DataSample("M1", "", DataSample.SampleStatus.NEW, new double[]{2.0, 3.5, 4.5})
                    );
    }
    @Test 
    void nullStatusException() {
        assertThrows(IllegalArgumentException.class,
                    () -> new DataSample("M1", "Material", null, new double[]{2.0, 3.5, 4.5})
                    );
    }
    @Test 
    void nullChangeStatusException() {
         DataSample dt = new DataSample("M1", "Material", DataSample.SampleStatus.NEW, new double[]{2.0, 3.5, 4.5});
         assertThrows(IllegalArgumentException.class,
                    () -> dt.changeStatus(null)
                    );
    }
    @Test 
    void nullFeatureslException() {
        assertThrows(IllegalArgumentException.class,
                    () -> new DataSample("M1", "Material", DataSample.SampleStatus.NEW, null)
                    );
    }
    @Test 
    void changeCheck() {
        DataSample dt = new DataSample("M1", "Material", DataSample.SampleStatus.NEW, new double[]{2.0, 3.5, 4.5});
        double[] features = dt.getFeatures();
        features[0] = 333.3;

        assertEquals(2.0, dt.getFeatures()[0]);
    }
    @Test
    void checkNormalization() {
        DataSample dt = new DataSample("M1", "Material", DataSample.SampleStatus.NEW, new double[]{2.0, 3.5, 4.5});

        assertArrayEquals(new double[]{0.0, 0.6, 1.0}, dt.normalization());
        assertArrayEquals(new double[]{2.0, 3.5, 4.5}, dt.getFeatures());
    }
}
