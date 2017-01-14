package io.faucette.math;


public class Vec2 {
    public float x;
    public float y;


    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vec2() { this(0f, 0f); }

    public static Vec2 set(Vec2 out, float x, float y) {
        out.x = x;
        out.y = y;
        return out;
    }
    public Vec2 set(float x, float y) { return Vec2.set(this, x, y); }

    public static Vec2 copy(Vec2 out, Vec2 other) {
        out.x = other.x;
        out.y = other.y;
        return out;
    }
    public Vec2 copy(Vec2 other) { return Vec2.copy(this, other); }

    public static Vec2 add(Vec2 out, Vec2 a, Vec2 b) {
        out.x = a.x + b.x;
        out.y = a.y + b.y;
        return out;
    }
    public Vec2 add(Vec2 a) { return Vec2.add(this, this, a); }

    public static Vec2 sub(Vec2 out, Vec2 a, Vec2 b) {
        out.x = a.x - b.x;
        out.y = a.y - b.y;
        return out;
    }
    public Vec2 sub(Vec2 a) { return Vec2.sub(this, this, a); }

    public static Vec2 mul(Vec2 out, Vec2 a, Vec2 b) {
        out.x = a.x * b.x;
        out.y = a.y * b.y;
        return out;
    }
    public Vec2 mul(Vec2 a) { return Vec2.mul(this, this, a); }

    public static Vec2 smul(Vec2 out, Vec2 a, float s) {
        out.x = a.x * s;
        out.y = a.y * s;
        return out;
    }
    public Vec2 smul(float s) { return Vec2.smul(this, this, s); }

    public static Vec2 div(Vec2 out, Vec2 a, Vec2 b) {
        float bx = b.x == 0f ? 0f : 1f / b.x;
        float by = b.y == 0f ? 0f : 1f / b.y;
        out.x = a.x * bx;
        out.y = a.y * by;
        return out;
    }
    public Vec2 div(Vec2 a) { return Vec2.div(this, this, a); }

    public static Vec2 sdiv(Vec2 out, Vec2 a, float s) {
        return Vec2.smul(out, a, s == 0f ? 0f : 1f / s);
    }
    public Vec2 sdiv(float s) { return Vec2.sdiv(this, this, s); }


    public static float lengthSqValues(float x, float y) {
        return x * x + y * y;
    }
    public static float lengthValues(float x, float y) {
        float lsq = Vec2.lengthSqValues(x, y);
        return lsq != 0f ? (float) Math.sqrt(lsq) : 0f;
    }

    public static float dot(Vec2 a, Vec2 b) {
        return a.x * b.x + a.y * b.y;
    }
    public float dot(Vec2 a) { return Vec2.dot(this, a); }

    public static float length(Vec2 a) { return Vec2.lengthValues(a.x, a.y); }
    public float length() { return Vec2.length(this); }

    public static float lengthSq(Vec2 a) { return Vec2.lengthSqValues(a.x, a.y); }
    public float lengthSq() { return Vec2.lengthSq(this); }


    public static float normalize(Vec2 out, Vec2 a) {
        float x = a.x;
        float y = a.y;
        float length = Vec2.lengthValues(x, y);
        float invLength = length != 0f ? 1f / length : 0f;

        out.x = x * invLength;
        out.y = y * invLength;

        return length;
    }
    public float normalize() { return Vec2.normalize(this, this); }

    public static Vec2 inverse(Vec2 out, Vec2 a) {
        out.x = -a.x;
        out.y = -a.y;
        return out;
    }
    public Vec2 inverse() { return Vec2.inverse(this, this); }

    public static Vec2 min(Vec2 out, Vec2 a, Vec2 b) {
        out.x = b.x < a.x ? b.x : a.x;
        out.y = b.y < a.y ? b.y : a.y;
        return out;
    }
    public Vec2 min(Vec2 other) { return Vec2.min(this, this, other); }

    public static Vec2 max(Vec2 out, Vec2 a, Vec2 b) {
        out.x = b.x > a.x ? b.x : a.x;
        out.y = b.y > a.y ? b.y : a.y;
        return out;
    }
    public Vec2 max(Vec2 other) { return Vec2.max(this, this, other); }

    public static float angle(Vec2 a, Vec2 b) {
        return (float) Math.acos(Vec2.dot(a, b) / (Vec2.length(a) * Vec2.length(b)));
    }
    public float angle(Vec2 a) { return Vec2.angle(this, a); }

    public static Vec2 transform(Vec2 out, Vec2 a, float angle) {
        float x = a.x;
        float y = a.y;
        float c = (float) Math.cos((double) angle);
        float s = (float) Math.sin((double) angle);

        out.x = x * c - y * s;
        out.y = x * s + y * c;

        return out;
    }
    public Vec2 transform(float angle) {
        return Vec2.transform(this, this, angle);
    }

    public static Vec2 transform(Vec2 out, Vec2 a, Mat2 m) {
        float x = a.x;
        float y = a.y;

        out.x = x * m.m[0] + y * m.m[2];
        out.y = x * m.m[1] + y * m.m[3];

        return out;
    }
    public Vec2 transform(Mat2 m) {
        return Vec2.transform(this, this, m);
    }

    public static Vec2 transform(Vec2 out, Vec2 a, Mat32 m) {
        float x = a.x;
        float y = a.y;

        out.x = x * m.m[0] + y * m.m[2] + m.m[4];
        out.y = x * m.m[1] + y * m.m[3] + m.m[5];

        return out;
    }
    public Vec2 transform(Mat32 m) {
        return Vec2.transform(this, this, m);
    }

    public static boolean equals(Vec2 a, Vec2 b) {
        return !(
            !Mathf.equals(a.x, b.x) ||
            !Mathf.equals(a.y, b.y)
        );
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Vec2) {
            return Vec2.equals(this, (Vec2) other);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Vec2(" + x + ", " + y + ")";
    }
}
