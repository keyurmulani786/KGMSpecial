package jpmorgon;

import java.awt.Rectangle;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int r1x = scan.nextInt();
        int r1y = scan.nextInt();
        int r1width = scan.nextInt();
        int r1height = scan.nextInt();
        int r2x = scan.nextInt();
        int r2y = scan.nextInt();
        int r2width = scan.nextInt();
        int r2height = scan.nextInt();

        Point l1 = new Point(r1x, r1y);
        Point r1 = new Point(r1width, r1height);
        Point l2 = new Point(r2x, r2y);
        Point r2 = new Point(r2width, r2height);

        Rect rect1 = new Rect(l1, r1);
        Rect rect2 = new Rect(l2, r2);
        System.out.println(isIntersect(rect1, rect2));

    }

    public static boolean isIntersect(Rect rect1, Rect rect2) {
        
//        return x < r.x + r.width  
//            && x + width > r.x 
//            && y < r.y + r.height 
//            && y + height > r.y;
        
        return rect1.topLeft.x <= rect2.topLeft.x + rect2.bottomRight.x
            && rect1.topLeft.x + rect1.bottomRight.x >= rect1.topLeft.x 
            && rect1.topLeft.y <= rect2.topLeft.y + rect2.bottomRight.y 
            && rect1.topLeft.y + rect1.topLeft.y >= rect2.topLeft.y;
        
//        if (rect1.topLeft.x >= rect2.bottomRight.x
//                || rect1.bottomRight.x <= rect2.topLeft.x
//                || rect1.topLeft.y <= rect2.bottomRight.y
//                || rect1.bottomRight.y >= rect2.topLeft.y) {
//            return false;
//        }

//        return true;
    }

    private static void checkOverlap(int r1x1, int r1y1, int r1x2, int r1y2, int r2x1, int r2y1, int r2x2, int r2y2) {
        // condition to check whether the rectangles are overlapping or not.s

//        if (rect1.topLeft.x >= rect2.bottomRight.x
//                || rect1.bottomRight.x <= rect2.topLeft.x
//                || rect1.topLeft.y <= rect2.bottomRight.y
//                || rect1.bottomRight.y >= rect2.topLeft.y) {
//            boolean 
//        }
//        isOVerlap = ((r1x2 >= r2x1)
//                && (r1y2 >= r2y1)
//                && (r1x1 <= r2x2)
//                && (r1y1 <= r2y2));
//
//        if (isOVerlap) {
//            System.out.println("overlap");
//
//        } else {
//            System.out.println("not");
//        }
    }

    public static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x) {
            return false;
        }

        // If one rectangle is above other
        if (l1.y < r2.y || l2.y < r1.y) {
            return false;
        }

        return true;
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Rect {

    Point topLeft;
    Point bottomRight;

    public Rect(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

}
