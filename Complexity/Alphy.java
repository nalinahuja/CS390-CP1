/*

#Problem

Given an integer c, find all integers a and b such that a >= b, satisfying the equation

1/c = 1/a + 1/b

#Input Format

Input contains N lines, each giving a value of c.

#Constraints

1 <= N <= 1000
1 <= C <= 10000

#Output Format

For each c, output the number of corresponding (a, b) pairs, followed by a list of a and b in the format of
the equation in the problem in ascending order of b.

*/

import java.io.*;
import java.lang.*;
import java.util.*;

public class Alphy {
  public static void printFraction(double target, double a, double b) {
    System.out.printf("1/%d = 1/%d + 1/%d\n", (int)target, (int)a, (int)b);
  }

  public static double component(double target, double dimension) {
    return (target * dimension) / (dimension - target);
  }

  public static void summation(double target) {
    double x = Double.MAX_VALUE, y = target * 2;
    ArrayList<double[]> pairs = new ArrayList<>();

    while(y >= target + 1) {
      x = component(target, y);
      if((int)(x) == x && x >= y)
        pairs.add(new double[]{x, y});
      y--;
    }

    System.out.println(pairs.size());
    for(int i = pairs.size() - 1; i >= 0; i--)
      printFraction(target, pairs.get(i)[0], pairs.get(i)[1]);
  }

  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      String readLine = reader.readLine();
      while(!readLine.isEmpty()) {
        summation(Double.parseDouble(readLine));
        readLine = reader.readLine();
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
