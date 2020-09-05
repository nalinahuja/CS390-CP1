/*

#Problem

You own a grass field which is in a shape of n-sided regular polygon. You also have k cows who you want to feed so you take them to the field and tie each cow
to a pole at each k vertices with a rope of length m. You need to calculate the amount of grass left in the field.

#Input Format

The input will be a single line with 4 integers (n s k m)seperated by a space. n is the number of sides of the polygon s is the length of a side of the polygon
k is the the number of cows m is the length of the rope.

#Constraints

  3 <= n <= 100
  0 < s <= 100
  0 <= k <= n
  0 < m <= (s / 2)

#Output Format

Output the area of grass left after the cows are done eating. Output should be a decimal value with 2 decimal points.

*/

import java.io.*;
import java.util.*;

public class Cows {
  public static double detArea(double sideCount, double sideLength) {
    double apothem = ((sideLength) / (2 * Math.tan(Math.toRadians(180 / sideCount))));
    double perimeter = sideCount * sideLength;
    return ((0.5) * apothem * perimeter);
  }

  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      String dataIn[] = reader.readLine().split(" ");
      double sideCount = Double.parseDouble(dataIn[0]), sideLength = Double.parseDouble(dataIn[1]), numCows = Double.parseDouble(dataIn[2]), ropeLength = Double.parseDouble(dataIn[3]);

      double totalArea = detArea(sideCount, sideLength);
      double eatenArea = (numCows) * ((((sideCount - 2.0) * 180.0) / sideCount) / 360) *  Math.PI * Math.pow(ropeLength, 2);

      System.out.println(String.format("%.2f", (totalArea - eatenArea)));
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
