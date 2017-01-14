package io.faucette.math;


public class Vec3 {
    public float x;
    public float y;
    public float z;


    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vec3() { this(0f, 0f, 0f); }

    public static Vec3 set(Vec3 out, float x, float y, float z) {
        out.x = x;
        out.y = y;
        out.z = z;
        return out;
    }
    public Vec3 set(float x, float y, float z) { return Vec3.set(this, x, y, z); }

    public static Vec3 copy(Vec3 out, Vec3 other) {
        out.x = other.x;
        out.y = other.y;
        out.z = other.z;
        return out;
    }
    public Vec3 copy(Vec3 other) { return Vec3.copy(this, other); }

    public static Vec3 add(Vec3 out, Vec3 a, Vec3 b) {
        out.x = a.x + b.x;
        out.y = a.y + b.y;
        out.z = a.z + b.z;
        return out;
    }
    public Vec3 add(Vec3 a) { return Vec3.add(this, this, a); }

    public static Vec3 sub(Vec3 out, Vec3 a, Vec3 b) {
        out.x = a.x - b.x;
        out.y = a.y - b.y;
        out.z = a.z - b.z;
        return out;
    }
    public Vec3 sub(Vec3 a) { return Vec3.sub(this, this, a); }

    public static Vec3 mul(Vec3 out, Vec3 a, Vec3 b) {
        out.x = a.x * b.x;
        out.y = a.y * b.y;
        out.z = a.z * b.z;
        return out;
    }
    public Vec3 mul(Vec3 a) { return Vec3.mul(this, this, a); }

    public static Vec3 smul(Vec3 out, Vec3 a, float s) {
        out.x = a.x * s;
        out.y = a.y * s;
        out.z = a.z * s;
        return out;
    }
    public Vec3 smul(float s) { return Vec3.smul(this, this, s); }

    public static Vec3 div(Vec3 out, Vec3 a, Vec3 b) {
        float bx = b.x == 0f ? 0f : 1f / b.x;
        float by = b.y == 0f ? 0f : 1f / b.y;
        float bz = b.z == 0f ? 0f : 1f / b.z;
        out.x = a.x * bx;
        out.y = a.y * by;
        out.z = a.z * bz;
        return out;
    }
    public Vec3 div(Vec3 a) { return Vec3.div(this, this, a); }

    public static Vec3 sdiv(Vec3 out, Vec3 a, float s) {
        return Vec3.smul(out, a, s == 0f ? 0f : 1f / s);
    }
    public Vec3 sdiv(float s) { return Vec3.sdiv(this, this, s); }


    public static float lengthSqValues(float x, float y, float z) {
        return x * x + y * y + z * z;
    }
    public static float lengthValues(float x, float y, float z) {
        float lsq = Vec3.lengthSqValues(x, y, z);
        return lsq != 0f ? (float) Math.sqrt(lsq) : 0f;
    }

    public static float dot(Vec3 a, Vec3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
    public float dot(Vec3 a) { return Vec3.dot(this, a); }

    public static float length(Vec3 a) { return Vec3.lengthValues(a.x, a.y, a.z); }
    public float length() { return Vec3.length(this); }

    public static float lengthSq(Vec3 a) { return Vec3.lengthSqValues(a.x, a.y, a.z); }
    public float lengthSq() { return Vec3.lengthSq(this); }


    public static float normalize(Vec3 out, Vec3 a) {
        float x = a.x;
        float y = a.y;
        float z = a.z;
        float length = Vec3.lengthValues(x, y, z);
        float invLength = length != 0f ? 1f / length : 0f;

        out.x = x * invLength;
        out.y = y * invLength;
        out.z = z * invLength;

        return length;
    }
    public float normalize() { return Vec3.normalize(this, this); }

    public static Vec3 inverse(Vec3 out, Vec3 a) {
        out.x = -a.x;
        out.y = -a.y;
        out.z = -a.z;
        return out;
    }
    public Vec3 inverse() { return Vec3.inverse(this, this); }

    public static Vec3 min(Vec3 out, Vec3 a, Vec3 b) {
        out.x = b.x < a.x ? b.x : a.x;
        out.y = b.y < a.y ? b.y : a.y;
        out.z = b.z < a.z ? b.z : a.z;
        return out;
    }
    public Vec3 min(Vec3 other) { return Vec3.min(this, this, other); }

    public static Vec3 max(Vec3 out, Vec3 a, Vec3 b) {
        out.x = b.x > a.x ? b.x : a.x;
        out.y = b.y > a.y ? b.y : a.y;
        out.z = b.z > a.z ? b.z : a.z;
        return out;
    }
    public Vec3 max(Vec3 other) { return Vec3.max(this, this, other); }

    public static Vec3 transform(Vec3 out, Vec3 a, Mat2 m) {
        float x = a.x;
        float y = a.y;
        float z = a.z;

        out.x = x * m.m[0] + y * m.m[2];
        out.y = x * m.m[1] + y * m.m[3];
        out.z = z;

        return out;
    }
    public Vec3 transform(Mat2 m) {
        return Vec3.transform(this, this, m);
    }

    public static Vec3 transform(Vec3 out, Vec3 a, Mat32 m) {
        float x = a.x;
        float y = a.y;
        float z = a.z;

        out.x = x * m.m[0] + y * m.m[2] + m.m[4];
        out.y = x * m.m[1] + y * m.m[3] + m.m[5];
        out.z = z;

        return out;
    }
    public Vec3 transform(Mat32 m) {
        return Vec3.transform(this, this, m);
    }

    public static boolean equals(Vec3 a, Vec3 b) {
        return !(
            !Mathf.equals(a.x, b.x) ||
            !Mathf.equals(a.y, b.y) ||
            !Mathf.equals(a.z, b.z)
        );
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Vec3) {
            return Vec3.equals(this, (Vec3) other);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Vec3(" + x + ", " + y + ", " + z + ")";
    }
}
