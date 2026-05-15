package com.abc.latch;

import java.util.concurrent.locks.StampedLock;

/**
 * @Author Administrator
 * @Date 2026/5/13 16:53
 * @Version 1.0
 */
public class StampTest {

    public static void main(String[] args) {
        Point point = new Point();
        point.move(10, 10);
        System.out.println(point.distanceFromOrigin());
    }
}



class Point{
    private double x, y;
    private final StampedLock s1 = new StampedLock();

    void move(double deltaX, double deltaY){
        long stamp = s1.writeLock();
        try{
            x += deltaX;
            y += deltaY;
        }finally {
            s1.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin(){
        long stamp = s1.tryOptimisticRead();
        double currentX = x, currentY = y;
        if(!s1.validate(stamp)){
            stamp = s1.readLock();
            try{
                currentX = x;
                currentY = y;
            }finally {
                s1.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}