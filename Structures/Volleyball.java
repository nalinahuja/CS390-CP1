/*

#Problem

You are the Captain of the Bloomberg Volleyball Team. In order to make an effective lineup you want to know who will be on the court after a certain number of
rotations as well as where on the court they will be. In volleyball, 6 players are on the court at a time and they rotate clockwise one position every time
their team gains the right to serve. A volleyball court is referenced with numbers 1 - 6. Starting from the lower right corner is position 1 going all the way
around the court in a counter-clockwise direction to position 6 at the lower middle.

You have will have anywhere between 7 and 26 people on your team. Because your team is > 6, there will be players waiting off court on the sidelines while six play.
Every rotation, one of these sideline players will come into the court at position 1 (server position), while one player will leave the court at position 2 and join
the sideline at the back of the line. The setter will always be in the starting lineup and will not be rotated off the court. This means that when the setter is at
position 2, when it comes time for a rotation instead of leaving the court and joining the sideline, they will instead go directly to position 1.

#Input Format

Your program will take from STDIN:

  -The first line will be the number of rotations that the team will undergo 1 ≤ N ≤ 200
  -The second line will be the name of the setter. Names will only contain alphabetical characters.
  -The third line will be the starting lineup. The setter will always be in the starting lineup. Each player name will be a unique string.
   The names are space delimited. There will always be 6 people in the starting lineup.
  -The fourth line will contain the players on the sidelines. The first token will be the number of players on the sideline 1 ≤ S ≤ 20, followed by
   that many space-delimited unique player names.The first name will be the first to rotate in.

#Constraints

1 <= N <= 200 1 <= S <= 20

#Output Format

Based on the input, print out the lineup after the N number of rotations ordering them based on which position on the court they will end up.

*/

import java.io.*;
import java.util.*;

public class Volleyball {
  public static void main(String args[]) {
    final String space = " ";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      int rotationCount = Integer.parseInt(reader.readLine().trim());
      String setter = (reader.readLine()).trim();
      String lineup = (reader.readLine()).trim(); lineup = (lineup.substring(lineup.indexOf(" ")) + space + lineup.substring(0, lineup.indexOf(" "))).trim();
      String alternates = (reader.readLine()).trim();
      alternates = (alternates.substring(alternates.indexOf(" "))).trim();

      VolleyBallTeam team = new VolleyBallTeam(setter, lineup, alternates);
      for(int i = 0; i < rotationCount; i++) {
        team.rotate();
      }
      team.printLineup();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class VolleyBallTeam {
  String setter = null;
  String team[] = null;

  public VolleyBallTeam(String setterInput, String teamInput, String alternatesInput) {
    this.setter = setterInput.trim();
    this.team = ((teamInput.concat(" " + alternatesInput)).trim()).split(" ");
  }

  public void rotate() {
    String temp = team[0];
    team[0] = null;
    if(temp.equals(this.setter)) {
      for(int i = 1; i < 6; i++) {
        team[i - 1] = team[i];
      }
      team[5] = temp;
    } else {
      for(int i = 1; i < team.length; i++) {
        team[i - 1] = team[i];
      }
      team[team.length - 1] = temp;
    }
  }

  public void printLineup() {
    System.out.println((team[5].trim()) + " " + (team[0].trim()) + " " + (team[1].trim())  + " " + (team[2].trim()) + " " + (team[3].trim()) + " " + (team[4].trim()));
  }
}
