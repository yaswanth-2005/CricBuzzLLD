import java.util.*;

public class Game {
    private int playersCount;
    private int oversCount;
    private List<String> team1;
    private List<String> team2;

    public Game(int playersCount, int oversCount, List<String> team1, List<String> team2) {
        this.playersCount = playersCount;
        this.oversCount = oversCount;
        this.team1 = team1;
        this.team2 = team2;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public int getOversCount() {
        return oversCount;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public void setOversCount(int oversCount) {
        this.oversCount = oversCount;
    }

    public List<String> getTeam1() {
        return team1;
    }

    public List<String> getTeam2() {
        return team2;
    }

    public void setTeam1(List<String> team1) {
        this.team1 = team1;
    }

    public void setTeam2(List<String> team2) {
        this.team2 = team2;
    }

    public void play() {
        Inning inning1 = new Inning(oversCount, team1, Integer.MAX_VALUE);
        inning1.play();
        System.out.println("Team 1 Score after First Innings is " + inning1.getScore() +"/"+ inning1.getWicketsCount());
        System.out.println("Let's start Inning 2");
        System.out.println("Team 2 needs "+inning1.getScore() + " runs to win the match in " +oversCount +" overs");
        Inning inning2 = new Inning(oversCount, team2, inning1.getScore());
        inning2.play();
        System.out.println("Team 2 Score after First Innings is " + inning2.getScore() +"/"+ inning2.getWicketsCount());
        System.out.println("Team1 : "+inning1.getScore() + "/" + inning1.getWicketsCount());
        System.out.println("Team2 : "+inning2.getScore() + "/" + inning2.getWicketsCount());
        if(inning1.getScore() > inning2.getScore()) {
            System.out.println("Team 1 Wins!");
        } else {
            System.out.println("Team 2 Wins!");
        }
    }
}