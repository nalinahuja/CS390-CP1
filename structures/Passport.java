/*

#Problem

Upon arrival at an international airport, passengers must go through passport control. They are arranged in a line and must go to the lowest numbered
available passport control booth, where a border agent will check their travel documents. Passengers can come alone or in groups. You should assume that every passenger
will get through passport control after 1 minute, so a group of 5 passengers will have all its checks completed after 5 minutes.

Each group of passengers will be processed by a single border agent.

Each passenger group is immediately assigned to the lowest numbered available border agent, so you should assume no time is spent for this.

Case 1: The group of passengers should go to Booth 2

		   Booth 1      Booth 2      Booth 3   ...   Booth N
Passengers ---->  Unavailable  Available    Available ...   Available

Case 2: The group of passengers should go to Booth 1

		   Booth 1      Booth 2      Booth 3   ...   Booth N
Passengers ---->  Available  Available    Unavailable ...   Available

After checking 10 passenger groups (regardless of size), each border agent is required to take a break, which will make their respective booth unavailable during 5 minutes.

Your task is to count how many groups were through each booth.

#Input Format

The first line is a single integer representing the number of passport booths N.The second line is a single integer representing the number of groups in the queue
for passport control, M. This will be followed by M lines, each representing a group, with a single integer representing the number of passengers in that group GM.

#Constraints

  0 < N ≤ 10
  0 < M ≤ 60
  0 < GM ≤ 100

#Output Format

You should output a space separated list of integers containing how many groups each border agent has processed. Note that the sum of these integers must be equal to M.

*/

import java.io.*;
import java.util.*;

public class Passport {
  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      Booth[] booths = new Booth[Integer.parseInt(reader.readLine())];
      for(int i = 0; i < booths.length; i++)
        booths[i] = new Booth();

      int[] groups = new int[Integer.parseInt(reader.readLine())];
      for(int i = 0; i < groups.length; i++)
        groups[i] = Integer.parseInt(reader.readLine());

      for(int i = 0; i < groups.length; i++) {
        int minTimeIndex = 0, minValue = booths[0].time;
        for(int j = 0; j < booths.length; j++) {
          if(booths[j].time < minValue) {
            minValue = booths[j].time;
            minTimeIndex = j;
          }
        }

        booths[minTimeIndex].time += groups[i];
        booths[minTimeIndex].groups++;

        if(booths[minTimeIndex].groups % 10 == 0 && booths[minTimeIndex].groups != 0) {
          booths[minTimeIndex].time += 5;
        }
      }

      for(int i = 0; i < booths.length; i++) {
        System.out.print(booths[i].groups + " ");
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class Booth {
  public int time = 0;
  public int groups = 0;
}
