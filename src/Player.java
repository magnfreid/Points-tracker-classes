import java.util.UUID;

public class Player {
    private String name;
    private int score;
    private final String id = UUID.randomUUID().toString();

    Player() {
        name = "Anonymous";
        score = 0;
    }

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    Player(String name) {
        this.name = name;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getID() {
        return this.id;
    }


    public String toString() {
        return "***** \nPlayer:" +
                "\nName: " + name +
                "\nScore:" + score;
    }
}
