public class Beginner extends Player {

    public Beginner(String name) {
        super(name, 5);
    }
    public String toString() {
        return super.toString() + " and is a beginner!";
    }
}
