import java.util.Scanner;  //import scanner
import java.io.File;  //Import the File class
import java.io.IOException;  //Import IO Exception class for errors
import java.io.FileWriter;  //importing file writer class
import java.io.FileNotFoundException;  //class to handle errors
import java.util.ArrayList;  //import the ArrayList

public class DiceGame {  //DiceGame class
Cup theCup; //declare and assign theCup variable
Spinner theSpinner;  //declare and assign theSpinner variable
ArrayList<Player> players = new ArrayList<Player>();  //players ArrayList

    public DiceGame() {  //DiceGame constructor
    theCup = new Cup();  //assigning theCup variable to new Cup
    theSpinner = new Spinner();  //assign theSpinner to new Spinner
//    setUpGame(); //call setUpGame method

    }
    public void setUpGame() {  //setUpGame method
        this.displayInstructions();
//        System.out.println("Welcome to the Dice Game!");  //print messages
//        System.out.println("The first player to get five correct wins.");
        System.out.println();
        Scanner scan = new Scanner(System.in);  //scanner object to scan user input
        System.out.print("How many players? ");
        int numPlayers = scan.nextInt();
        for(int i = 0; i < numPlayers; i++) {  //for-loop created to determine the below print message
            System.out.print("Enter player " + (i + 1) + " name: ");  //index will increase by # of players
            String playerName = scan.next();
            System.out.print("Enter player type: Pro or Beginner: ");
            String playerType = scan.next();
            if(playerType.equalsIgnoreCase("Pro")) {
                Player proPlayer = new Pro(playerName);
                players.add(proPlayer);  //store the name entered by the user
            }
            else if (playerType.equalsIgnoreCase ("Beginner")) {
                Player begPlayer = new Beginner(playerName);
                players.add(begPlayer);
            }

        }


    }
    public void addPlayer(String playerName, String playerType) {
        if(playerType.equals("Pro")) {
            this.players.add(new Pro(playerName));
        } else {
            this.players.add(new Beginner(playerName));
        }
    }
    public Player getPlayerByIndex(int playerIndex) {
        return this.players.get(playerIndex);
    }
    public String returnScores() {
        String output = "SCOREBOARD\n";
        for(int i = 0; i < players.size(); i++)
        {
            output += String.format("%15s\n",players.get(i));
        }
        output += "\n";
        return output;
    }
    public void playGame() {  //playGame method
        int spinValue = spinSpinner(); //initial spin to start the game
        boolean keepPlaying = true;  //Game loop
        while(keepPlaying) {
            for(int i = 0; i < players.size(); i++) {
                //Player chooses whether the die sum will be Higher/Lower than spin value
                //if right, earns point, if wrong, play passes to the next player
                Player currentPlayer = players.get(i);
                boolean playerScored = currentPlayer.takeTurn(theCup, spinValue);
                showScores();
                if(currentPlayer.hasEnoughPoints() == true) {
                    System.out.printf("%s won with %d points!\n", currentPlayer.getName(), currentPlayer.getScore());
                    printCertificate(currentPlayer.getName());
                    keepPlaying = false;
                    break;
                }
                if(playerScored == true)  {
                    spinValue = spinSpinner();
                }
            }
        }

    }
    public void showScores() {  //showScores method
        System.out.println("SCOREBOARD");  //print message
        for(int i = 0; i < players.size(); i++) {  //for-loop to keep track of scores for # of participating players
            System.out.println(players.get(i).toString());
        }
        System.out.println();
    }
    public int spinSpinner() {  //spinSpinner method
        System.out.print("Press Enter/Return to spin the spinner...");  //print message
        try {  //try block
            System.in.read();
        }
        catch (Exception e) { }  //exception
        int val = theSpinner.spin();
        System.out.println(theSpinner);
        System.out.println();
        return val;
    }
    private void printCertificate(String playerName) {
        //try block attempts to create the winner file
        try {
            File myObj = new File("winner.txt");
            FileWriter myWriter = new FileWriter("winner.txt");
            myWriter.write("***********************************\n");
            myWriter.write("             CONGRATS              \n");
            myWriter.write(playerName + " has won the game!!!  \n");
            myWriter.write("***********************************\n");
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public Cup getCup() {
        return theCup;
    }
    public Spinner getSpinner() {
        return theSpinner;

    }
    private void displayInstructions() {
        try {
            File myObj = new File("instructions.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
