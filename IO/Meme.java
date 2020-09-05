/*

#Problem

Find the indices of the memes so they can be saved!

#Input Format

The length of the message l will be on the first line, the meme will be on the second line, and the message will be on the third line.

#Constraints

1 <= l <= 10000 Only letter a through z are used.

#Output Format

Output a list of indices of the meme. Indices start at 0.

*/

import java.io.*;
import java.util.*;

public class Meme {
  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      int charCount = Integer.parseInt(reader.readLine());
      String searchValue = reader.readLine();
      String charSeq = reader.readLine();

      int index = 0;
      while(true) {
        System.out.print(charSeq.indexOf(searchValue, index) + " ");
        index = charSeq.indexOf(searchValue, index) + 1;
        if(charSeq.indexOf(searchValue, index) == -1)
          break;
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
