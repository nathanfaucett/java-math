package io.faucette.math;


public class Mathf {
    public final static double PI = Math.PI;
    public final static double TWO_PI = Math.PI * 2;
    public final static double HALF_PI = Math.PI / 2;

    public final static double EPSILON_D = Math.pow(10, -15);
    public final static float EPSILON_F = (float) Math.pow(10, -6);
    public final static float EPSILON = EPSILON_F;


    public static boolean equals(short a, short b) { return a == b; }
    public static boolean equals(int a, int b) { return a == b; }
    public static boolean equals(long a, long b) { return a == b; }

    public static boolean equals(float a, float b) {
        return Math.abs(a - b) < EPSILON_F;
    }
    public static boolean equals(double a, double b) {
        return Math.abs(a - b) < EPSILON_D;
    }

    public static boolean isPOT(short x) {
        return (x & -x) == x;
    }
    public static boolean isPOT(int x) {
        return (x & -x) == x;
    }
    public static boolean isPOT(long x) {
        return (x & -x) == x;
    }

    public static short lerp(short a, short b, float t) {
        return (short) lerp((float) a, (float) b, t);
    }
    public static int lerp(int a, int b, float t) {
        return (int) lerp((float) a, (float) b, t);
    }
    public static long lerp(long a, long b, float t) {
        return (long) lerp((float) a, (float) b, t);
    }
    public static float lerp(float a, float b, float t) {
        return a + ((b - a) * t);
    }
    public static double lerp(double a, double b, double t) {
        return a + ((b - a) * t);
    }

    public static short clamp(short x, short min, short max) {
        return x < min ? min : (x > max ? max : x);
    }
    public static int clamp(int x, int min, int max) {
        return x < min ? min : (x > max ? max : x);
    }
    public static long clamp(long x, long min, long max) {
        return x < min ? min : (x > max ? max : x);
    }
    public static float clamp(float x, float min, float max) {
        return x < min ? min : (x > max ? max : x);
    }
    public static double clamp(double x, double min, double max) {
        return x < min ? min : (x > max ? max : x);
    }

    public static float clamp01(float x) {
        return clamp(x, 0f, 1f);
    }
    public static double clamp01(double x) {
        return clamp(x, 0d, 1d);
    }

    public static float modulo(float a, float b) {
        float r = a % b;
        return (r * b < 0f) ? r + b : r;
    }
    public static double modulo(double a, double b) {
        double r = a % b;
        return (r * b < 0d) ? r + b : r;
    }

    public static float standardRadian(float angle) {
        return Mathf.modulo(angle, (float) Mathf.TWO_PI);
    }
    public static double standardRadian(double angle) {
        return Mathf.modulo(angle, Mathf.TWO_PI);
    }

    public enum Direction {
        RIGHT,
        UP_RIGHT,
        UP,
        UP_LEFT,
        LEFT,
        DOWN_LEFT,
        DOWN,
        DOWN_RIGHT
    }

    private final static double n225 = 0.39269908169872414;
    private final static double n675 = 1.1780972450961724;
    private final static double n1125 = 1.9634954084936207;
    private final static double n1575 = 2.748893571891069;
    private final static double n2025 = 3.5342917352885173;
    private final static double n2475 = 4.319689898685966;
    private final static double n2925 = 5.105088062083414;
    private final static double n3375 = 5.8904862254808625;

    public static Direction directionRadian(double rad) {
        double r = Mathf.standardRadian(rad);

        return (
            (r >= n225 && r < n675) ? Direction.UP_RIGHT :
            (r >= n675 && r < n1125) ? Direction.UP :
            (r >= n1125 && r < n1575) ? Direction.UP_LEFT :
            (r >= n1575 && r < n2025) ? Direction.LEFT :
            (r >= n2025 && r < n2475) ? Direction.DOWN_LEFT :
            (r >= n2475 && r < n2925) ? Direction.DOWN :
            (r >= n2925 && r < n3375) ? Direction.DOWN_RIGHT :
            Direction.RIGHT
        );
    }
    public static Direction directionRadian(float rad) {
        return Mathf.directionRadian((double) rad);
    }

    public static Direction direction(double x, double y) {
        return Mathf.directionRadian(Math.atan2(y, x));
    }
    public static Direction direction(float x, float y) {
        return Mathf.direction((double) x, (double) y);
    }
}
