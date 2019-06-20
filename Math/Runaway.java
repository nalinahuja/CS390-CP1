/*

#Problem

Japan Heavy Chemical Industries created Jet Alone to compete with Nerv's Eva series. Unfortunately, they did not invest in computer security experts
while writing the software. Now Jet Alone has been hacked and is running away. There are four walls around the area, and when it hits a wall it will explode.

Calculate where it will hit a wall so Nerv can intercept it and disable it.

#Input Format

You will be given Jet Alone's starting point on the first line as 2 integer values, and its slope on the second line as integers,
and the following 4 lines will each have a point represented by 2 integers that are the corners of the walls.

The points are printed in clockwise order, so there are walls between point 1 and point 2, point 2 and point 3, point 3 and point 4, and point and point 1.

Jet Alone is walking forward, so x is only increasing from the starting point.

#Constraints

The points and the slope will be integers.

#Output Format

Print the point where Jet Alone will hit a wall, truncated down to the nearest integer coordinates.

*/

import java.io.*;
import java.util.*;

public class Runaway {
  static final int ON_LINE = 0;

  public static double slope(Point one, Point two) {
    double dy = ((double)two.y) - ((double)one.y);
    double dx = ((double)two.x) - ((double)one.x);
    return (dy / dx);
  }

  public static void main(String args[]) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      Point vertices[] = new Point[4];
      String dataIn[] = reader.readLine().split(" ");
      int startX = Integer.parseInt(dataIn[0]), startY = Integer.parseInt(dataIn[1]), slope = Integer.parseInt(reader.readLine());

      for(int i = 0; i < vertices.length; i++) {
        dataIn = reader.readLine().split(" ");
        vertices[i] = new Point(Integer.parseInt(dataIn[0]), Integer.parseInt(dataIn[1]));
      }

      double precision = 0.0001;
      double intersectX = startX, intersectY = startY;

      Point vertCopy[] = vertices.clone();

      int topSide = ((vertices[0].x - vertices[3].x)*(startY - vertices[3].y) - (startX - vertices[3].x)*(vertices[0].y - vertices[3].y));
      int leftSide = ((vertices[3].x - vertices[2].x)*(startY - vertices[2].y) - (startX - vertices[2].x)*(vertices[3].y - vertices[2].y));
      int bottomSide = ((vertices[2].x - vertices[1].x)*(startY - vertices[1].y) - (startX - vertices[1].x)*(vertices[2].y - vertices[1].y));
      int rightSide = ((vertices[1].x - vertices[0].x)*(startY - vertices[0].y) - (startX - vertices[0].x)*(vertices[1].y - vertices[0].y));

      if(topSide > 0 && leftSide < 0 && startX < vertices[1].x && startX < vertices[0].x) {
        vertices = new Point[]{vertCopy[3], vertCopy[0], vertCopy[1], vertCopy[2]};
      }

      search:
      for(int i = 0; i < vertices.length; i++) {
        Point startNode = null, endNode = null;

        if(i == 3) {
          startNode = vertices[3];
          endNode = vertices[0];
        } else {
          startNode = vertices[i];
          endNode = vertices[i + 1];
        }

        int xStr = startNode.x;
        int xEnd = endNode.x;

        if(xStr > xEnd) {
          int xTemp = xStr;
          xStr = xEnd;
          xEnd = xTemp;
        }

        for(double j = xStr; j <= xEnd + precision; j += precision) {
          double yValue = (((slope(startNode, endNode)) * (j - startNode.x)) + startNode.y) - (slope * (j - startX) + startY);
          if(Double.parseDouble(String.format("%.3f", yValue)) == 0.0) {
            intersectX = j;
            intersectY = (slope * (j - startX)) + startY;
            break search;
          }
        }
      }

      System.out.println((int)intersectX + " " + (int)intersectY);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class Point {
  int x, y;
  public Point(int xIn, int yIn) {
    this.x = xIn;
    this.y = yIn;
  }
}
