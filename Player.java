import java.util.Scanner;

public class Player {  //Player class
    protected String name; //protected (#) String name variable
    protected int score;  //protected (#) int score variable
    private int winningScore;

    public Player(String playerName) {  //Player constructor
        score = 0;  //score variable initialized to 0
        name = playerName; //name = playerName
    }
    public Player(String playerName, int playerWinningScore) {
        name = playerName;
        score = 0;
        winningScore = playerWinningScore;

    }
    public String getName() {  //getName method
        return name; //return name
    }
    public void setName(String playerName) {  //setName method
        name = playerName;  //name = playerName
    }
    public int getScore() {  //getScore method
        return score;  //return score
    }
    public void setScore(int newScore) {  //setScore method with an integer newScore within the parameter
        score = newScore;  //setting score = newScore
    }
    public boolean takeTurn(Cup myCup, int spinValue) {  //takeTurn method returning a boolean + 2-parameters
        Scanner scan = new Scanner(System.in);  //scanner to scan user's input
        System.out.print(name + "'s turn. Will your roll be Higher or Lower than " + spinValue + " (H/L)? ");  //print statement
        String playerAnswer = scan.next();  //scan's user's input
        boolean playerScored = false;  //boolean playerScored = false
        int roll = myCup.roll();  //roll variable = myCup parameter in takeTurn method
        System.out.println(myCup.toString());  //print toString from Cup class
        //if-statement for user's input of "H" & "L"
        if((playerAnswer.equals("H") && roll < spinValue) || (playerAnswer.equals("L") && roll > spinValue)) {
            System.out.println("No point...next player's turn");
            System.out.println();
        }
        else {  //else-statement showing outcome of an earned point
            System.out.println(name + " earned a point!");
            score++;
            playerScored = true;
            System.out.println();
        }
        return playerScored;
    }
    public void incrementScore() {
        this.score++;
    }
    public String toString() {  //toString method that will print players score
        return name + " has " + score + " point(s)";
    }
    public boolean hasEnoughPoints() {
        if(score == winningScore) {
            return true;
        }
        else {
            return false;
        }
    }
}
