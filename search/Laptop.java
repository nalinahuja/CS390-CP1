/*

#Problem

Sellers will pick a laptop to buy from two other sellers, and try to resell it for more than either of the prices they chose from.

Who makes the most profit out of all the sellers?

#Input Format

The input will begin with a line that contains a single integer N corresponding to the number of resellers that will be input.
The second line will contain the prices each reseller is offering a laptop for. The ith reseller can buy from the (2i + 1)th reseller or the (2i + 2)th reseller.

#Constraints

0 <= sellers <= 99, 0 <= selling price <= 5000

#Output Format

Print the number of the seller who is making the most profit compared to the less expensive reseller they could have chosen. The seller numbers start at 0.

*/

import java.util.*;

public class Laptop {
  public static int computeMaxProfit(String a, String b, String i) {
    if((Integer.parseInt(i) - Integer.parseInt(a)) > (Integer.parseInt(i) - Integer.parseInt(b)))
      return (Integer.parseInt(i) - Integer.parseInt(a));
    else
      return (Integer.parseInt(i) - Integer.parseInt(b));
  }

  public static int determineMaxIndex(int length) {
    return (int)((length - 2) / 2);
  }

  public static void main(String args[]) {
    String sellers[] = null;
    Scanner reader = new Scanner(System.in);

    reader.nextLine();
    sellers = reader.nextLine().split(" ");
    int index = 0, maxProfit = 0;
    for(int i = 0; i < determineMaxIndex(sellers.length); i++) {
      int profit = computeMaxProfit(sellers[(2*i) + 1], sellers[(2*i) + 2], sellers[i]);
      if(profit > maxProfit) {
        maxProfit = profit;
        index = i;
      }
    }

    System.out.println(index);
  }
}
