import java.util.Random;

public class Die {  //Die class
    private int value; //initializing the value attribute

    public Die() {  //Constructor
    value = roll();  //value calling the roll method

    }
    public int getValue() {  //getValue method that will return "value" integer
        return value;  //returns the "value"

    }
    public void setValue(int v) {  //setValue method
        value = v;  //value = v (integer)

    }
    public int roll() {  //roll method
        Random rand = new Random();  //random generator
        //returns a random value between 1-6
        value = rand.nextInt(6) + 1;
        return value;

    }
    public String toString() {  //toString method
        return "Die (" + value + ") ";

    }

}
