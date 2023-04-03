import java.util.Random;

public class Spinner {  //Spinner class
    private int spinValue;  //private integer spinValue variable

    public Spinner() {  //Spinner constructor
        spinValue = 0;  //initial value of 0
    }
    public int spin() {
        Random rand = new Random();  //random generator
        spinValue = rand.nextInt(11) + 2; //returns a random value between 2-12
        return spinValue;
    }
    public int getSpinValue() {  //getSpinValue method
        return spinValue;
    }
    public void setSpinValue(int currentSpinValue) {  //setSpinValue method
        spinValue = currentSpinValue;
    }
    public String toString() {  //toString method
        return "Spinner value: " + spinValue;

    }
}
