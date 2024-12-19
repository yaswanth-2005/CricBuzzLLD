# Cricket Simulation Program

## **Overview**

The **Cricket Simulation Program** is a console-based application that simulates a cricket match between two teams. It allows users to define match settings such as the number of players, overs, and batting orders. The program then plays out the match, tracks runs, wickets, player performance, and announces the winning team.

---

## **Features**

- **Custom Match Settings**: Users can define the number of players and overs.
- **Batting Order Input**: Specify the batting order for both teams.
- **Run and Wicket Tracking**: Track runs scored, wickets taken, and player contributions.
- **Inning and Match Summaries**: Provides detailed inning and match summaries, including scores and player statistics.
- **Match Results**: Determines and announces the winner.

---

## **How It Works**

1. **Match Setup**:
   - Users input the number of players, overs, and batting orders.
2. **First Innings**:
   - Team 1 bats first, scoring runs and losing wickets based on user input.
3. **Second Innings**:
   - Team 2 bats, attempting to chase the target set by Team 1.
4. **Result**:
   - The program compares scores and announces the winner.

---

## **Code Components**

1. **Game Class**: Manages the overall cricket match.
2. **Inning Class**: Handles the logic for each team's innings.
3. **Over Class**: Simulates an over and tracks ball-by-ball events.
4. **Main Class**: Entry point of the application.

---

## **Class Descriptions**

### **1. Game Class**
- **Attributes**:
  - `playersCount`: Number of players.
  - `oversCount`: Number of overs.
  - `team1`, `team2`: Batting orders for each team.
- **Methods**:
  - `play()`: Simulates the cricket match.

### **2. Inning Class**
- **Attributes**:
  - `oversCount`: Overs to be played.
  - `battingOrder`: Batting order of the team.
  - `targetScore`: Target score for Team 2.
- **Methods**:
  - `play()`: Simulates the inning.
  - `getScore()`: Returns the score.
  - `getWicketsCount()`: Returns wickets lost.

### **3. Over Class**
- **Attributes**:
  - Tracks runs, wickets, and player performance for each over.
- **Methods**:
  - `bowlOver(int overNum)`: Simulates an over.
  - `updateScore(run, overNum)`: Updates the score.
  - `summary(overNum)`: Displays over stats.

### **4. Main Class**
- Collects user inputs and triggers match simulation.

---

## **Execution Flow**

1. **Initialize Match**: User inputs match details (players, overs, batting order).
2. **First Innings**: Team 1 bats; runs and wickets are tracked.
3. **Second Innings**: Team 2 bats, attempting to chase the target.
4. **Result**: Compare scores and announce the winner.

---

## **Future Enhancements**

1. **User Interface**: Add a graphical UI (GUI).
2. **Persistent Statistics**: Save match summaries and player stats.
3. **Automated Gameplay**: Simulate matches without manual inputs.
4. **Dynamic Commentary**: Real-time ball-by-ball commentary.
5. **Advanced Rules**: Implement no-balls, free hits, and power plays.
6. **Multi-Match Simulation**: Support tournaments or series of matches.

---

## **Running the Program**

1. Clone this repository:
   ```bash
   git clone <repository-link>
   cd cricket-simulation

2. Running the Program :
   ```bash
   javac Main.java
   java Main


   
---


