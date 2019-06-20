/*

#Problem

You work in the lobby in Splatoon, and you need to place inklings into groups of 8. Each group of 8 is then split into 2 teams of 4. Each group of 8 should have
similar levels, and the teams should be split so that every other inkling should go on the first team, then the second team. Inklings can come and go from the lobby
until a new game is ready and the lobby closes.

Input Format

You will be given a series of inkling levels. The first line will say how many levels L will be given. If the level is negative, it means an inkling with that level
left the lobby. The total number of inklings ready to play will be a multiple of 8.

Constraints

8 < L < 10000
0 < level < 1000

Output Format

Output teams in two columns, with team one on the left, and team two on the right, and groups of 8 seperated by an extra newline.
The lowest level in the group should go to team one, then the next lowest should go to team two, and so on. Start with the lowest level groups.

*/

import java.io.*;
import java.util.*;

public class Sort {
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    HashMap<Integer, Integer> map = new HashMap<>();

    try {
      int maxLevel = 0;
      String inputCount = reader.readLine();
      for (int i = 0; i < Integer.parseInt(inputCount); i++) {
        int player = Integer.parseInt(reader.readLine());

        if(player > maxLevel) {
          maxLevel = player;
        }

        if(player < 0) {
          int key = (-1) * player;
          int inc = map.get(key);
          inc--;
          map.put(key, inc);
        }
        else {
          if(map.get(player) == null) {
            map.put(player, 1);
          } else {
            int inc = map.get(player);
            inc++;
            map.put(player, inc);
          }
        }
      }

      ArrayList<Integer> finalOrder = new ArrayList<>();

      for(int i = 0; i <= maxLevel; i++) {
        if(map.get(i) == null) {
          continue;
        }

        for(int j = 0; j < map.get(i); j++) {
          finalOrder.add(i);
        }
      }

      for(int i = 0; i < finalOrder.size() - 1; i+=2) {
        if(i % 8 == 0 && i != 0) {
          System.out.println();
        }
        System.out.println(finalOrder.get(i) + " " + finalOrder.get(i + 1));
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
