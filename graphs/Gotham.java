/*

#Problem

The masterful villain Bane has taken control of Gotham. To prevent police intervention, he blew up many of the roads and bridges connecting Gotham.
The police have a map of Gotham, but they don't currently know which areas they can reach. Due to the size of the Gotham Police Department, when the roads and bridges blew up
some officers were left in isolated parts of the city. They are receiving distress calls, but they have no way of knowing whether any officers can reach the distress call.

Your task is to see if an officer on a given road can reach another road.

#Input Format

You will be given a positive integer N, which denotes how many road connections there will be.

The following N lines will have a connection of one road to another, delimited by a space. There are no one-way roads in Gotham.

After all of the road connections have been listed, the next line will have a single positive integer M, which denotes how many queries will be given.

The following M lines will contain two space-delimited road names. The first road name is the officer's current road. The second road name is the road from which the distress call is coming. Both of the given road names will be part of the Gotham road network.

#Constraints

1 <= N, M <= 100

The road names will only consist of alphabetical characters, and will not contain more than 30 characters each.
Road names with differing capitalization are considered to be distinct.

#Output Format

For each query, if the officer can reach the distress call, output "YES". If they cannot, then output "NO".

*/

import java.io.*;
import java.util.*;

public class Gotham {
  static HashMap<String, ArrayList<String>> streets = new HashMap<>();
  static ArrayList<String> log = new ArrayList<>();

  public static boolean depthSearch(ArrayList<String> positionLevels, String startPosition, String endPosition) {
    ArrayList<String> endPoints = new ArrayList<>();
    for(String position : positionLevels) {
      for(String street : streets.get(position)) {
        if(!log.contains(street)) {
          endPoints.add(street);
          log.add(street);
        }
      }
    }

    if(endPoints.contains(endPosition)) {
      return true;
    } else if(endPoints.size() == 0) {
      return false;
    } else {
      return depthSearch(endPoints, startPosition, endPosition);
    }
  }

  public static boolean isPathValid(String startStreet, String endStreet) {
    ArrayList<String> startLevel = new ArrayList<>();
    startLevel.add(startStreet);
    return depthSearch(startLevel, startStreet, endStreet);
  }

  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      int dataAmount = Integer.parseInt(reader.readLine());
      for(int i = 0; i < dataAmount; i++) {
        String dataIn[] = reader.readLine().split(" ");
        if(streets.get(dataIn[0]) == null) {
          streets.put(dataIn[0], new ArrayList<String>());
          streets.get(dataIn[0]).add(dataIn[1]);
        } else {
          streets.get(dataIn[0]).add(dataIn[1]);
        }

        if(streets.get(dataIn[1]) == null) {
          streets.put(dataIn[1], new ArrayList<String>());
          streets.get(dataIn[1]).add(dataIn[0]);
        } else {
          streets.get(dataIn[1]).add(dataIn[0]);
        }
      }

      int detAmount = Integer.parseInt(reader.readLine());
      for(int i = 0; i < detAmount; i++) {
        String dataIn[] = reader.readLine().split(" ");
        if(isPathValid(dataIn[0], dataIn[1])) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }

        log = new ArrayList<>();
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
