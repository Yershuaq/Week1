package models;

import java.util.ArrayList;

public class Shape {
    private final ArrayList<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculatePerimeter() {
        int size = points.size();
        if (size < 2) return 0;

        double perimeter = 0;

        for (int i = 0; i < size; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % size);
            perimeter += currentPoint.distance(nextPoint);
        }

        return perimeter;
    }

    public double getAverageSide() {
        int size = points.size();
        return (size == 0) ? 0 : calculatePerimeter() / size;
    }

    public double getLongestSide() {
        double longestSide = 0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());

            double currentSide = currentPoint.distance(nextPoint);
            longestSide = Math.max(longestSide, currentSide);
        }

        return longestSide;
    }
}
