import java.util.ArrayList;  //import ArrayList

public class Cup {  //Cup class
    private int sum;  //private integer variable for sum
    private Die die1;  //private Die object called die1
    private Die die2;  //private Die object called die2

    public Cup() {  //Constructor
        ArrayList<Die> dice = new ArrayList<Die>();  //created dice array (type[] name of array = new type[size of array]
        die1 = new Die();  //initializing die1 by calling the Die constructor in the Die class
        die2 = new Die();  //initializing die2 by calling the Die constructor in the Die class
        dice.add(die1);  //putting die1 in the dice array
        dice.add(die2);  //putting die2 in the dice array
        sum = 0;
    }
    public int roll() {  //roll method
        sum = die1.roll() + die2.roll();  //after rolling die 1 & 2, the sum variable = die1 + die2;
        return sum;  //returning the sum of the two dice
    }
    public int getSum() {  //getSum method
        return sum; //returns the sum of the two dice

    }
    public void setSum(int sum) {  //setSum method with a void return
        this.sum = sum;  //setting the private sum to whatever the sum is passed in
    }
    public String toString() {  //toString method
        return "Rolled " + die1.toString() + " " + die2.toString() + " " +  "Sum: " + sum + "! \n";
    }
}
