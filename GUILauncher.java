import javax.swing.JFrame;

public class GUILauncher {
    public static void main(String[] args) {
        // --- Creating an instance of our GUI class ---
        GUIDiceGame theGame = new GUIDiceGame();
        // --- Will set the frame so the game will exit if/when the red 'X' is selected
        // ---
        theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // --- Are setting the width and height of our frame in pixel count ---
        theGame.setSize(650, 500);
        // --- Will now have our configured frame to become visible ---
        theGame.setVisible(true);
    }

}
