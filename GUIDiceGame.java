import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDiceGame extends JFrame {
    JTextArea output;
    JScrollPane scrollPane;
    String playerOneName;
    String playerTwoName;
    JLabel label;
    JTextField p1textBox;
    JTextField p2textBox;
    JButton p1Save;
    JButton p2Save;
    JButton p1Pro;
    JButton p2Pro;
    JButton p1Beginner;
    JButton p2Beginner;
    JButton spin;
    JButton H;
    JButton L;
    DiceGame game;
    int playerIndex;

    public GUIDiceGame() {
        output = new JTextArea(20, 50);
        scrollPane = new JScrollPane(output);
        playerIndex = 0;

        output.setEditable(false);
        output.setCaretPosition(output.getDocument().getLength());

        setTitle(
                "                                                                                Nuff Said                          ");
        setLayout(new FlowLayout());

        label = new JLabel(
                "                                                                 Welcome to Nuff Said!                                                                            ");
        add(label);

        label = new JLabel("Player One: ");
        add(label);
        p1textBox = new JTextField(10);
        add(p1textBox);
        p1Save = new JButton("Save");
        add(p1Save);

        label = new JLabel("                           Player Two: ");
        add(label);
        p2textBox = new JTextField(10);
        add(p2textBox);
        p2Save = new JButton("Save");
        add(p2Save);

        label = new JLabel("Pro or Beginner: ");
        add(label);
        p1Pro = new JButton("Pro");
        add(p1Pro);
        p1Beginner = new JButton("Beginner");
        add(p1Beginner);

        label = new JLabel("                 Pro or Beginner: ");
        add(label);
        p2Pro = new JButton("Pro");
        add(p2Pro);
        p2Beginner = new JButton("Beginner");
        add(p2Beginner);

        label = new JLabel("Press to spin: ");
        add(label);
        spin = new JButton("Spin");
        add(spin);

        label = new JLabel("       Higher or Lower: ");
        add(label);
        H = new JButton("H");
        add(H);
        L = new JButton("L");
        add(L);

        add(scrollPane);

        p2textBox.setEditable(false);

        p2Save.setEnabled(false);
        p1Pro.setEnabled(false);
        p1Beginner.setEnabled(false);
        p2Pro.setEnabled(false);
        p2Beginner.setEnabled(false);
        spin.setEnabled(false);
        H.setEnabled(false);
        L.setEnabled(false);

        output.setText("Please type in a name for Player 1 and click save: \n");

        MyGUIListener guiListener = new MyGUIListener();
        p1Save.addActionListener(guiListener);
        p1textBox.addActionListener(guiListener);
        p1Pro.addActionListener(guiListener);
        p1Beginner.addActionListener(guiListener);
        p2Save.addActionListener(guiListener);
        p2textBox.addActionListener(guiListener);
        p2Pro.addActionListener(guiListener);
        p2Beginner.addActionListener(guiListener);
        spin.addActionListener(guiListener);
        H.addActionListener(guiListener);
        L.addActionListener(guiListener);

        game = new DiceGame();

    }

    private class MyGUIListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // describe what the listener will do when the event occurs
            // a bunch of if statements
            if (event.getSource() == p1Save) {
                output.append("Please select the type of player this is. \n");
                playerOneName = p1textBox.getText();
                p1textBox.setEnabled(false);
                p1Save.setEnabled(false);
                p1Pro.setEnabled(true);
                p1Beginner.setEnabled(true);

            }
            if (event.getSource() == p1Pro) {
                output.append("Please type in a name for Player 2 and click save: \n");
                p1textBox.setEnabled(false);
                p1Save.setEnabled(false);
                p1Pro.setEnabled(false);
                p1Beginner.setEnabled(false);
                p2textBox.setEditable(true);
                p2Save.setEnabled(true);
                game.addPlayer(playerOneName, "Pro");

            } else if (event.getSource() == p1Beginner) {
                output.append("Please type in a name for Player 2 and click save: \n");
                p1textBox.setEnabled(false);
                p1Save.setEnabled(false);
                p1Pro.setEnabled(false);
                p1Beginner.setEnabled(false);
                p2textBox.setEditable(true);
                p2Save.setEnabled(true);
                game.addPlayer(playerOneName, "Beginner");
            }
            if (event.getSource() == p2Save) {
                output.append("Please select the type of player this is. \n");
                playerTwoName = p2textBox.getText();
                p2textBox.setEnabled(false);
                p2Save.setEnabled(false);
                p2Pro.setEnabled(true);
                p2Beginner.setEnabled(true);

            }
            if (event.getSource() == p2Pro) {
                p2textBox.setEnabled(false);
                p2Save.setEnabled(false);
                p2Pro.setEnabled(false);
                p2Beginner.setEnabled(false);
                spin.setEnabled(true);
                game.addPlayer(playerTwoName, "Pro");
                output.append("\n");
                output.append("Welcome to Nuff Said! \n");
                output.append("Beginner players need (5) points to win! \n");
                output.append("Pro players need (8) points to win! \n");
                output.append("Press the spin button to take a turn. \n");
                output.append("\n");

            } else if (event.getSource() == p2Beginner) {
                p2textBox.setEnabled(false);
                p2Save.setEnabled(false);
                p2Pro.setEnabled(false);
                p2Beginner.setEnabled(false);
                spin.setEnabled(true);
                game.addPlayer(playerTwoName, "Beginner");
                output.append("\n");
                output.append("Welcome to the Nuff Said! \n");
                output.append("Beginner players need (5) points to win! \n");
                output.append("Pro players need (8) points to win! \n");
                output.append("Press the spin button to take a turn. \n");
                output.append("\n");
            }
            if (event.getSource() == spin) {
                game.getSpinner().spin();
                output.append(game.getSpinner().toString() + "\n");
                output.append(game.getPlayerByIndex(playerIndex).getName()
                        + "'s turn. Will your roll be Higher or Lower than " + game.getSpinner().getSpinValue()
                        + " (H / L)? \n");
                spin.setEnabled(false);
                H.setEnabled(true);
                L.setEnabled(true);
            }
            if (event.getSource() == H) {
                game.getCup().roll();
                int rollSum = game.getCup().getSum();
                int spinValue = game.getSpinner().getSpinValue();
                output.append(game.theCup.toString());
                if (rollSum < spinValue) {
                    output.append("\n");
                    output.append("No point...next player's turn.\n");
                    output.append("\n");
                    output.append(game.returnScores());
                    if (playerIndex == 0) {
                        playerIndex = 1;
                    } else if (playerIndex == 1) {
                        playerIndex = 0;
                    }
                } else {
                    if (playerIndex == 0) {
                        output.append("\n");
                        output.append(playerOneName + " earned a point! \n");
                        game.getPlayerByIndex(playerIndex).incrementScore();
                        Player p1 = game.getPlayerByIndex(playerIndex);
                        output.append("\n");
                        output.append(game.returnScores());
                        if (p1.hasEnoughPoints() == true) {
                            output.append(playerOneName + " has " + p1.getScore() + " is the winner!");

                        }

                        playerIndex = 1;
                    } else if (playerIndex == 1) {
                        output.append("\n");
                        output.append(playerTwoName + " earned a point! \n");
                        game.getPlayerByIndex(playerIndex).incrementScore();
                        Player p2 = game.getPlayerByIndex(playerIndex);
                        output.append("\n");
                        output.append(game.returnScores());
                        if (p2.hasEnoughPoints() == true) {
                            output.append(playerTwoName + " has " + p2.getScore() + " is the winner!");
                        }
                        playerIndex = 0;
                    }

                }
                spin.setEnabled(true);
                H.setEnabled(false);
                L.setEnabled(false);

            }
            if (event.getSource() == L) {
                game.getCup().roll();
                int rollSum = game.getCup().getSum();
                int spinValue = game.getSpinner().getSpinValue();
                output.append(game.theCup.toString());
                if (rollSum > spinValue) {
                    output.append("\n");
                    output.append("No point...next player's turn.\n");
                    output.append("\n");
                    output.append(game.returnScores());
                    if (playerIndex == 0) {
                        playerIndex = 1;
                    } else if (playerIndex == 1) {
                        playerIndex = 0;
                    }
                } else {
                    if (playerIndex == 0) {
                        output.append("\n");
                        output.append(playerOneName + " earned a point! \n");
                        game.getPlayerByIndex(playerIndex).incrementScore();
                        Player p1 = game.getPlayerByIndex(playerIndex);
                        output.append("\n");
                        output.append(game.returnScores());
                        if (p1.hasEnoughPoints() == true) {
                            output.append(playerOneName + " has " + p1.getScore() + " and is the winner!");

                        }
                        playerIndex = 1;

                    } else if (playerIndex == 1) {
                        output.append("\n");
                        output.append(playerTwoName + " earned a point! \n");
                        game.getPlayerByIndex(playerIndex).incrementScore();
                        Player p2 = game.getPlayerByIndex(playerIndex);
                        output.append("\n");
                        output.append(game.returnScores());
                        if (p2.hasEnoughPoints() == true) {
                            output.append(playerTwoName + " has " + p2.getScore() + " and is the winner!");

                        }
                        playerIndex = 0;
                    }
                }
                spin.setEnabled(true);
                H.setEnabled(false);
                L.setEnabled(false);

            }

        }
    }
}