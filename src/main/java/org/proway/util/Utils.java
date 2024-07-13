package org.proway.util;

public class Utils {
    public static boolean validateLoop(int var, int y){
        return var < 1 || var > y;
    }
    public static boolean validateLoop(int var, int y, int z){
        return var < y || var > z;
    }
}
