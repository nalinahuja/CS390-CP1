/*

#Problem

Gendo is trying to store all of his employee data in a hashmap for easy and efficient access. He had been using their names to uniquely identify them, but
ran into trouble after getting many repeated names, so he recently switched to using unique employee numbers.

Hash all the given names or numbers and store each employee's sense of self-worth in an array of size 256 using the hash value as the index

Print all the names or IDs with their self-worth in the order they appear in the hash map. If two values have the same hash, replace the existing value.

#Input Format

You will be given a number e of employees on the first line followed by e lines of employee data. Employee lines have two formats: Name or ID

#Constraints

5 <= e <= 20
0 <= id <= 20
1 <= self-worth <= 10

#Output Format

Print the ID or name of the employee, then their self-worth. This should be in order of the employee's hash value.

*/

import java.io.*;
import java.util.*;

public class Hashing {
  public static int hasher(int id) {
      return (int)Math.pow(id + 5, 5) % 247;
  }

  public static int hasher(String s) {
    int value = 0;
    for (int i = 0; i < s.length(); i++) {
        value += s.charAt(i) + 7 * value;
    }
    return value % 256;
  }

  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    EmpData[] hashTable = new EmpData[256];
    try {
      int dataPointCount = Integer.parseInt(reader.readLine());
      for(int i = 0; i < dataPointCount; i++) {
        String[] dataPoint = reader.readLine().split(" ");
        if(dataPoint[0].contains("ID")) {
          hashTable[hasher(Integer.parseInt(dataPoint[1]))] = new EmpData("ID", dataPoint[1], dataPoint[2]);
        } else {
          hashTable[hasher(dataPoint[1])] = new EmpData("Name", dataPoint[1], dataPoint[2]);
        }
      }

      for(int i = 0; i < hashTable.length; i++) {
        if(hashTable[i] != null)
          System.out.println(hashTable[i].toString());
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class EmpData {
  String id = null;
  String type = null;
  String worth = null;

  public EmpData(String typeInput, String idInput, String worthInput) {
    this.id = idInput;
    this.type = typeInput;
    this.worth = worthInput;
  }

  @Override
  public String toString() {
    return this.id + " " + this.worth;
  }
}
