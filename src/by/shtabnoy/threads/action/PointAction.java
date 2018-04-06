package by.shtabnoy.threads.action;

import by.shtabnoy.threads.entity.Point;


public class PointAction {

    public double length(Point firstPoint, Point secondPoint) {
        return Math.hypot(firstPoint.getX() - secondPoint.getX(), firstPoint.getY() - secondPoint.getY());
    }

}
