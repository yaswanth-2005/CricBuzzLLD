import java.util.*;

public class Inning {
    private int oversCount;
    private List team;
    private int score = 0;
    private int wicketsCount = 0;
    private int toWin;

    public Inning(int oversCount, List team, int toWin) {
        this.oversCount = oversCount;
        this.team = team;
        this.toWin = toWin;
    }

    public void play() {
        Over over = new Over(oversCount, team, toWin);
        for(int i = 0; i < oversCount; i++) {
            System.out.println("Let's start the Over : " + (i + 1));
            over.bowlOver(i);
            over.summary(i);
            score = over.totalScore;
            wicketsCount = over.wickets;
            if(over.allOut || over.isMatchFinish) {
                return;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWicketsCount() {
        return wicketsCount;
    }

    public void setWicketsCount(int wicketsCount) {
        this.wicketsCount = wicketsCount;
    }

}