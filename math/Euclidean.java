/*

#Problem

Given M and N, find the value of a and b in the following equation using the Extended Euclidean Algorithm:

M x a + N x b = gcd(M, N)

#Input Format

Two integers M and N seaerated by a space.

#Constraints

2 <= M, N <= 10000000

#Output Format

Two integers a and b separated by a space

*/

import java.io.*;
import java.util.*;

public class Euclid {
  public static double GCD(double a, double b) {
    if(a % b == 0) {
      return b;
    } else {
      return GCD(b, a % b);
    }
  }

  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      String dataIn[] = reader.readLine().split(" ");
      double numOne = Double.parseDouble(dataIn[0]), numTwo = Double.parseDouble(dataIn[1]), detGCD = GCD(numOne, numTwo);

      for(int i = 0; i <= Math.max(numOne, numTwo); i++) {
        double yValue = (detGCD - (numOne * i)) / numTwo;
        if(yValue == (int)yValue) {
          System.out.println(i + " " + (int)yValue);
          break;
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
