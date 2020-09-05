/*

#Problem

Zach is reading his required College of Science general education material, and he wonders that among thousands and thousands of meaningless words he read, which word is unique.

As Zach's lucky number is 2, he wants to figure out the second appeared unique word in the book.

Note: A unique word only appears once in the book.

#Input Format

The first line of Input contains an integer N, indicates the number of words in the book, followed by one line with N words separated by spaces.

Note there might be punctuation in the book, and you need to ignore them. For example you should read "I'm" as "Im" and "it." as " it"

#Constraints

N <= 10^6

#Output Format

Output the second unique word or -1 if it doesn't exist.

*/

import java.io.*;
import java.util.*;

public class Words {
  static String[] wordList = null;

  public static String format(String input) {
    return input.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
  }

  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      reader.readLine();
      String inputSentence = reader.readLine();
      wordList = inputSentence.split(" ");

      LinkedHashMap<String,Integer> wordCount = new LinkedHashMap<>();

      String frmWord = null;
      for(String word : wordList) {
        frmWord = format(word);
        if(wordCount.get(frmWord) == null)
          wordCount.put(frmWord, 1);
        else
          wordCount.put(frmWord, wordCount.get(frmWord) + 1);
      }

      boolean isSecond = false, isFound = false;
      for(String key : wordCount.keySet()) {
        if(wordCount.get(key) == 1) {
          if(!isSecond) {
            isSecond = true;
            continue;
          } else {
            System.out.print(key + "\n");
            isFound = true;
            break;
          }
        }
      }

      if(!isFound) {
        System.out.print(-1 + "\n");
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
