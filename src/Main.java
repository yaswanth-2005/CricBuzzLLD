import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Players:");
        int playersCount = sc.nextInt();
        System.out.println("Enter the Number of Overs: ");
        int oversCount = sc.nextInt();
        List<String> team1 = new ArrayList<>();
        List<String> team2 = new ArrayList<>();
        System.out.println("Enter the Batting order of team 1 : ");
        for(int i = 0; i < playersCount; i++) {
            team1.add(sc.next());
        }
        System.out.println("Enter the Batting order of team 2 : ");
        for(int i = 0; i < playersCount; i++) {
            team2.add(sc.next());
        }

        Game game = new Game(playersCount, oversCount, team1, team2);
        game.play();
    }
}