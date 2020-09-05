/*

#Problem

Take input of a stream of numbers and output the product of all the numbers inputted
when the input number is 0 or at the end of the input.

End the program when you see a blank line.

#Input Format

Each integer is entered in a new line. End the program when you see a blank line.

#Constraints

Each input number is an integer with absolute value less than 1e9.

#Output Format

Output each product on a new line modulo 1e9 + 7.

*/

import java.util.*;

public class Mult {
  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    ArrayList<Long> multiplied = new ArrayList<>();
    long multiple = 1, constant = (long)(Math.pow(10, 9) + 7);
    String currNumber = read.nextLine().trim();

    try {
      while (!currNumber.isEmpty()) {
        if(Long.parseLong(currNumber) != 0) {
          multiple *= Long.parseLong(currNumber);
        } else if(Long.parseLong(currNumber) == 0) {
          multiplied.add((((multiple % constant) + constant) % constant));
        }
        currNumber = read.nextLine().trim();
        multiple = (((multiple % constant) + constant) % constant);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }

    multiplied.add((((multiple % constant) + constant) % constant));

    for(Long mult : multiplied) {
        System.out.println(mult);
    }
  }
}
