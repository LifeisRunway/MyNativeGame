package com.example.my_game_module;

public class CollisionDetect {

    static double object1X;
    static double object1Y;

    static double object2X;
    static double object2Y;

    static double radiusObject1;
    static double radiusObject2;

    static double dx;
    static double dy;

    static double distanceObjects;

    public static boolean collisionDetect (ObjectFW obj1, ObjectFW obj2) {
        object1X = obj1.getHitBox().centerX();
        object1Y = obj1.getHitBox().centerY();

        object2X = obj2.getHitBox().centerX();
        object2Y = obj2.getHitBox().centerY();

        radiusObject1 = obj1.radius;
        radiusObject2 = obj2.radius;

        dx = object1X - object2X;
        dy = object1Y - object2Y;

        distanceObjects = Math.sqrt(dx*dx+dy*dy);

        return distanceObjects < (radiusObject1 + radiusObject2);
    }

}
