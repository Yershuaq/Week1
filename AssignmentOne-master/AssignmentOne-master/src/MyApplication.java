import models.Point;
import models.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyApplication {
    private static final String FILE_PATH = "C:\\Users\\Gorshok\\Desktop\\AssignmentOne-master\\AssignmentOne-master\\src\\source.txt";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File(FILE_PATH))) {
            Shape shape = new Shape();
            Point firstPoint = null;
            Point previousPoint = null;

            while (sc.hasNext()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                Point point = new Point(x, y);

                shape.addPoint(point);

                if (previousPoint != null) {
                    double distance = previousPoint.distance(point);
                    System.out.println("Distance between " + previousPoint + " and " + point + " = " + distance);
                } else {
                    firstPoint = point;
                }

                previousPoint = point;
            }

            if (previousPoint != null && firstPoint != null) {
                double distance = previousPoint.distance(firstPoint);
                System.out.println("Distance between " + previousPoint + " and " + firstPoint + " = " + distance);
            }

            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println("Average side: " + shape.getAverageSide());
            System.out.println("Longest side: " + shape.getLongestSide());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + FILE_PATH);
        }
    }
}
