import java.util.Comparator;

public class Player implements Comparable<Player> {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
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

    @Override
    public int compareTo(Player o) {
        if(this.score > o.score)
            return 1;
        else if (this.score == o.score)
            return this.name.compareTo(o.name);
        else
            return -1;
    }
}



