/*

#Problem

The council of Ricks have had it with the Rickest of Rick and have waged war on him. They have managed to trap Rick in another dimension and have broken his portal gun.

Rick has a spare portal gun at home and asks Morty to help him by punching in the coordinates to Rick's dimensions.

However, being the Rickest of Ricks, he sent Morty his dimension number in the form of a difficult math equation, because Morty has been ignoring his Math homework lately.

p * e^(-x) + q * sin(x) + r * cos(x) + s * tan(x) + t * x^2 + u = 0

where 0 ≤ x ≤ 1

Help Morty find Rick's dimension coordinates!

#Input Format

Input consists of multiple test cases and terminated by an EOF. Each test case consists of 6 integers in a single line: p, q, r, s, t and u . There will be maximum 2100 lines in the input file

#Constraints

0 ≤ p
r ≤ 20
−20 ≤ q
s, t ≤ 0

#Output Format

For each set of input, there should be a line containing the value of x, correct up to 4 decimal places, or the string ‘No solution’, whichever is applicable.

*/

import java.io.*;
import java.util.*;

public class Morty {
    public static double computeFormula(double x, int p, int q, int r, int s, int t, int u) {
      return ((p / Math.exp(x)) + (q * Math.sin(x)) + (r * Math.cos(x)) + (s * Math.tan(x)) + (t * Math.pow(x, 2)) + (u));
    }

    public static void main(String args []) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      try {
        String readLine[];
        double increment = 0.01;

        do {
          boolean found = false;
          readLine = reader.readLine().split(" ");
          double startValue = 0.0, endValue = 0.0, start = 0.0, end = 0.0;

          for(double i = 0; i <= 1; i += increment) {
            double zero_value = computeFormula(i, Integer.parseInt(readLine[0]),  Integer.parseInt(readLine[1]), Integer.parseInt(readLine[2]),
                                               Integer.parseInt(readLine[3]),  Integer.parseInt(readLine[4]), Integer.parseInt(readLine[5]));

            if(i == 0) {
              startValue = zero_value;
            } else if(i == increment) {
              endValue = zero_value;
              if(startValue <= 0 && endValue >= 0 || startValue >= 0 && endValue <= 0) {
                start = i - (increment); end = i;
                if(start < 0) {start = 0;}
                if(end > 1) {end = 1;}
                break;
              }
            } else {
              startValue = endValue;
              endValue = zero_value;
              if(startValue <= 0 && endValue >= 0 || startValue >= 0 && endValue <= 0) {
                start = i - (increment); end = i;
                if(start < 0) {start = 0;}
                if(end > 1) {end = 1;}
                break;
              }
            }
          }

          for(double i = start; i <= end; i += 0.00001) {
            double zero_value = computeFormula(i, Integer.parseInt(readLine[0]),  Integer.parseInt(readLine[1]), Integer.parseInt(readLine[2]),
                                               Integer.parseInt(readLine[3]),  Integer.parseInt(readLine[4]), Integer.parseInt(readLine[5]));
            if(Double.parseDouble(String.format("%.4f", zero_value)) == (0)) {
              System.out.println(String.format("%.4f", i));
              found = true;
              break;
            }
          }

          if(!found && readLine.length == 6) {
            System.out.println("No solution");
          }
        } while(readLine.length == 6);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
