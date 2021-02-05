/*

#Problem

Kurisu needs to email herself a sequence of numbers back in time. Just to make it harder for herself and anyone who may be watching,
she will only send hints about the number. Each hint will tell her what the remainder is of the number divided by a given divisor.

#Input Format

The first line will contain the number of hints h. The following h lines will have a hint where the first number on the line is the remainder, and the second number is
the divisor. For convenience, the hints will be in order of decreasing divisor.

#Constraints

The divisors will be coprime.

#Output Format

Print the secret number.

*/

import java.io.*;
import java.util.*;

public class Dec {
  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      Pair pairs[] = new Pair[Integer.parseInt(reader.readLine())];

      for(int i = 0; i < pairs.length; i++) {
        String dataIn[] = reader.readLine().split(" ");
        pairs[i] = new Pair(Integer.parseInt(dataIn[0]), Integer.parseInt(dataIn[1]));
      }

      int xValue = 0;
      boolean foundInt = false;

      while(!foundInt) {
        int matchCount = 0;
        for(int i = 0; i < pairs.length; i++) {
          if(xValue % pairs[i].divisor == pairs[i].remainder) {
            matchCount++;
          }
        }

        if(matchCount == pairs.length)
          foundInt = true;
        else
          xValue++;
      }

      System.out.println(xValue);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class Pair {
  int remainder, divisor;

  public Pair(int remainderInput, int divisorInput) {
    this.remainder = remainderInput;
    this.divisor = divisorInput;
  }
}
