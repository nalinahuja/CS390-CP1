/*

#Problem

How can you buy the minimum number of books with all your money?

#Input Format

Your budget will be on the first line. The following 3 lines will have the prices of hardback, paperback, and spiral books.

#Constraints

10 <= budget <= 1000000

#Output Format

Print the number of hardbacks, paperbacks, spiral books, and notebooks that you buy, in that order.

*/

import java.io.*;
import java.util.*;

public class Book {
    public static void printArray(Type inputArray[]) {
      for(Type typeBook : inputArray)
        System.out.println(typeBook.amount + " " + typeBook.name);
    }

    public static void main(String args[]) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      Type typeValues[] = new Type[4];
      int budget;

      try {
        budget = Integer.parseInt(reader.readLine().split(" ")[1]);

        for(int i = 0; i < 3; i++) {
          String lineValues[] = reader.readLine().split(" ");
          typeValues[i] = new Type(i, lineValues[0], Integer.parseInt(lineValues[1]));
        }

        typeValues[3] = new Type(3, "notebook", 1);
        Arrays.sort(typeValues, new sortByPrice());

        for(Type typeBook : typeValues) {
          typeBook.amount = (budget / typeBook.price);
          budget = (budget % typeBook.price);
        }

        Arrays.sort(typeValues, new sortByInsertionId());
        printArray(typeValues);
      } catch(Exception e) {
        e.printStackTrace();
      }
  }
}

class Type {
  String name;
  int id, price, amount;

  public Type(int insertIdInput, String inputName, int inputPrice) {
    this.id = insertIdInput;
    this.name = inputName;
    this.price = inputPrice;
  }
}

class sortByPrice implements Comparator<Type> {
  public int compare(Type a, Type b) {
    return b.price - a.price;
  }
}

class sortByInsertionId implements Comparator<Type> {
  public int compare(Type a, Type b) {
    return a.id - b.id;
  }
}
