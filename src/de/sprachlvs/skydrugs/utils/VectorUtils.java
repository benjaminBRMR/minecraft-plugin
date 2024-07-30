package de.sprachlvs.skydrugs.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public final class VectorUtils {
    public static final Vector rotateAroundAxisX(Vector paramVector, double paramDouble) {
        double d3 = Math.cos(paramDouble);
        double d4 = Math.sin(paramDouble);
        double d1 = paramVector.getY() * d3 - paramVector.getZ() * d4;
        double d2 = paramVector.getY() * d4 + paramVector.getZ() * d3;
        return paramVector.setY(d1).setZ(d2);
    }

    public static final Vector rotateAroundAxisY(Vector paramVector, double paramDouble) {
        double d3 = Math.cos(paramDouble);
        double d4 = Math.sin(paramDouble);
        double d1 = paramVector.getX() * d3 + paramVector.getZ() * d4;
        double d2 = paramVector.getX() * -d4 + paramVector.getZ() * d3;
        return paramVector.setX(d1).setZ(d2);
    }

    public static final Vector rotateAroundAxisZ(Vector paramVector, double paramDouble) {
        double d3 = Math.cos(paramDouble);
        double d4 = Math.sin(paramDouble);
        double d1 = paramVector.getX() * d3 - paramVector.getY() * d4;
        double d2 = paramVector.getX() * d4 + paramVector.getY() * d3;
        return paramVector.setX(d1).setY(d2);
    }

    public static final Vector rotateVector(Vector paramVector, double paramDouble1, double paramDouble2, double paramDouble3) {
        rotateAroundAxisX(paramVector, paramDouble1);
        rotateAroundAxisY(paramVector, paramDouble2);
        rotateAroundAxisZ(paramVector, paramDouble3);
        return paramVector;
    }

    public static final Vector rotateVector(Vector paramVector, Location paramLocation) {
        return rotateVector(paramVector, paramLocation.getYaw(), paramLocation.getPitch());
    }

    public static final Vector rotateVector(Vector paramVector, float paramFloat1, float paramFloat2) {
        double d1 = Math.toRadians((-1.0F * (paramFloat1 + 90.0F)));
        double d2 = Math.toRadians(-paramFloat2);
        double d3 = Math.cos(d1);
        double d4 = Math.cos(d2);
        double d5 = Math.sin(d1);
        double d6 = Math.sin(d2);
        double d7 = paramVector.getX();
        double d8 = paramVector.getY();
        double d10 = d7 * d4 - d8 * d6;
        double d11 = d7 * d6 + d8 * d4;
        double d9 = paramVector.getZ();
        d7 = d10;
        double d12 = d9 * d3 - d7 * d5;
        d10 = d9 * d5 + d7 * d3;
        return new Vector(d10, d11, d12);
    }

    public static final double angleToXAxis(Vector paramVector) {
        return Math.atan2(paramVector.getX(), paramVector.getY());
    }
}

