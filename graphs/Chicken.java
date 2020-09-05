/*

#Problem

There are two types of people in this world: those who like chicken tenders, and those who do not.

The people who like chicken tenders have already eaten all of their available tenders. The people who do not like tenders have not. If there are people who don't like
tenders that are friends, then their relationship is suboptimal, as nobody in that relationship consumes the tenders. If people who like tenders are friends, then there
will be no tenders between them to consume. It is therefore optimal if people who like chicken tenders befriend people who don't like chicken tenders.

You will be given a network of friends as input, and are tasked to determine if the network can formed such that people who like chicken tenders are friends with only
people who don't like tenders, and vice versa.

#Input Format

You will first be given an integer N denoting how many friend connections there are in the network. The following N lines will each have a pair of space-delimited strings,
denoting the connection between two friends. The strings will only have lowercase, alphabetical characters.

#Constraints

1 <= N <= 100

Each name will be less than 32 characters. Each name will be unique. No person may be friends with themself. Assume all people given are at least indirectly connected.

#Output Format

If the friend network can formed such that people who like chicken tenders are friends with only people who don't like tenders, and vice versa, output "YES".

Else if the friend network can't be formed with this structure, output "NO".

*/

import java.io.*;
import java.util.*;

public class Connect {
  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Boolean> people = new HashMap<>();

    try {
      boolean validMap = true;
      int dataAmount = Integer.parseInt(reader.readLine());
      for(int i = 0; i < dataAmount; i++) {
        String names[] = reader.readLine().split(" ");
        String nameOne = names[0];
        String nameTwo = names[1];

        if(i == 0) {
          people.put(nameOne, true);
          people.put(nameTwo, false);
        } else {
            if(people.get(nameOne) != null && people.get(nameTwo) == null) {
              people.put(nameTwo, !people.get(nameOne));
            } else if(people.get(nameOne) == null && people.get(nameTwo) != null) {
                people.put(nameOne, !people.get(nameTwo));
            } else {
              if(people.get(nameOne) == people.get(nameTwo)) {
                validMap = false;
              }
            }
          }
        }

        System.out.println(validMap == true ? "YES" : "NO");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
