import java.util.*;

public class Over {
    public int totalScore = 0;
    public int wickets = 0;
    int oversCount;
    public int strike = 0;
    public int nonStrike = 1;
    public int latestPlayer = 1;
    int wides = 0;
    int noBalls = 0;
    int fours = 0;
    int sixes = 0;
    public int toWin;
    public boolean allOut = false;
    public boolean isMatchFinish = false;
    private List<List<String>> overs = new ArrayList<>();
    private List<String> team;
    private List<List<String>> playerScore = new ArrayList<>();

    public Over(int oversCount, List<String> team, int toWin) {
        this.oversCount = oversCount;
        this.team = team;
        this.toWin = toWin;

        for(int i = 0; i < team.size(); i++){
            List<String> stats = new ArrayList<>();
            stats.add(team.get(i));
            stats.add("0");
            stats.add("0");
            stats.add("0");
            stats.add("0");
            playerScore.add(stats);
        }
    }

    public void bowlOver(int overNum) {
        Scanner sc = new Scanner(System.in);
        List<String> currOver = new ArrayList<>();
        overs.add(currOver);

        for(int ball = 0; ball < 6; ball++) {
            System.out.println("Enter runs for the ball Number" + (ball + 1) + ":");
            String run = sc.next();
            if(!updateScore(run, overNum)) {
                ball--;
            }

            if(allOut || isMatchFinish) {
                return;
            }
        }

        int temp = strike;
        strike = nonStrike;
        nonStrike = temp;
    }

    private boolean updateScore(String run, int overNum) {
        if(run.equals("W")) {
            wickets++;
            overs.get(overNum).add(run);
        } else if(run.equals("Wd")) {
            totalScore++;
            overs.get(overNum).add(run);
        } else if(run.equals("N")) {
            totalScore++;
            overs.get(overNum).add(run);
        } else {
            int presentScore = Integer.parseInt(run);
            totalScore += presentScore;
            overs.get(overNum).add(run);
        }

        if(allOut || totalScore > toWin) {
            isMatchFinish = true;
            return true;
        }
        updatePlayerScore(run);
        if(run.equals("Wd") || run.equals("N")) {
            return false;
        }

        return true;
    }

    private void updatePlayerScore(String run) {
        int ballsFaced = Integer.parseInt(playerScore.get(strike).get(4));
        ballsFaced += 1;
        playerScore.get(strike).set(4, String.valueOf(ballsFaced));

        if (run.equals("W")) {
            if (latestPlayer + 1 < team.size()) {
                strike = latestPlayer + 1;
                latestPlayer++;
            } else {
                allOut = true;
                return;
            }
        } else if (run.equals("Wd")) {
            wides++;
        } else if (run.equals("N")) {
            noBalls++;
        } else {
            int currRuns = Integer.parseInt(run);
            System.out.println("Player run will be : " + currRuns);
            int runsTillNow = Integer.parseInt(playerScore.get(strike).get(1));
            runsTillNow += currRuns;
            playerScore.get(strike).set(1, String.valueOf(runsTillNow));

            if (currRuns % 2 == 1) {
                int temp = strike;
                strike = nonStrike;
                nonStrike = temp;
            } else if (currRuns == 4) {
                int foursTillNow = Integer.parseInt(playerScore.get(strike).get(2));
                foursTillNow++;
                fours++;
                playerScore.get(strike).set(2, String.valueOf(foursTillNow));
            } else if (currRuns == 6) {
                int sixesTillNow = Integer.parseInt(playerScore.get(strike).get(3));
                sixesTillNow++;
                sixes++;
                playerScore.get(strike).set(3, String.valueOf(sixesTillNow));
            }
        }

        System.out.println("Strike is with : " + strike);
    }


    public void summary(int overNum) {
        System.out.println("This Over : ");
        for(String ball : overs.get(overNum)) {
            System.out.print(ball+ " ");
        }
        System.out.println();

        System.out.println("Player Score for this Over : ");
        for(List<String> players : playerScore) {
            System.out.print("Player: " + players.get(0) + " | ");
            System.out.print("Runs: " + players.get(1) + " | ");
            System.out.print("4s: " + players.get(2) + " | ");
            System.out.print("6s: " + players.get(3) + " | ");
            System.out.print("Balls: " + players.get(4));
            System.out.println();
        }

        System.out.println("Team score after this Over, Total Score : " + totalScore + "Wickets : " + wickets);
    }
}