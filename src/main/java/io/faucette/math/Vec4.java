package io.faucette.math;


public class Vec4 {
    public float x;
    public float y;
    public float z;
    public float w;


    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    public Vec4() { this(0f, 0f, 0f, 1f); }

    public static Vec4 set(Vec4 out, float x, float y, float z, float w) {
        out.x = x;
        out.y = y;
        out.z = z;
        out.w = w;
        return out;
    }
    public Vec4 set(float x, float y, float z, float w) { return Vec4.set(this, x, y, z, w); }

    public static Vec4 copy(Vec4 out, Vec4 other) {
        out.x = other.x;
        out.y = other.y;
        out.z = other.z;
        out.w = other.w;
        return out;
    }
    public Vec4 copy(Vec4 other) { return Vec4.copy(this, other); }

    public static Vec4 add(Vec4 out, Vec4 a, Vec4 b) {
        out.x = a.x + b.x;
        out.y = a.y + b.y;
        out.z = a.z + b.z;
        out.w = a.w + b.w;
        return out;
    }
    public Vec4 add(Vec4 a) { return Vec4.add(this, this, a); }

    public static Vec4 sub(Vec4 out, Vec4 a, Vec4 b) {
        out.x = a.x - b.x;
        out.y = a.y - b.y;
        out.z = a.z - b.z;
        out.w = a.w - b.w;
        return out;
    }
    public Vec4 sub(Vec4 a) { return Vec4.sub(this, this, a); }

    public static Vec4 mul(Vec4 out, Vec4 a, Vec4 b) {
        out.x = a.x * b.x;
        out.y = a.y * b.y;
        out.z = a.z * b.z;
        out.w = a.w * b.w;
        return out;
    }
    public Vec4 mul(Vec4 a) { return Vec4.mul(this, this, a); }

    public static Vec4 smul(Vec4 out, Vec4 a, float s) {
        out.x = a.x * s;
        out.y = a.y * s;
        out.z = a.z * s;
        out.w = a.w * s;
        return out;
    }
    public Vec4 smul(float s) { return Vec4.smul(this, this, s); }

    public static Vec4 div(Vec4 out, Vec4 a, Vec4 b) {
        float bx = b.x == 0f ? 0f : 1f / b.x;
        float by = b.y == 0f ? 0f : 1f / b.y;
        float bz = b.z == 0f ? 0f : 1f / b.z;
        float bw = b.w == 0f ? 0f : 1f / b.w;
        out.x = a.x * bx;
        out.y = a.y * by;
        out.z = a.z * bz;
        out.w = a.w * bw;
        return out;
    }
    public Vec4 div(Vec4 a) { return Vec4.div(this, this, a); }

    public static Vec4 sdiv(Vec4 out, Vec4 a, float s) {
        return Vec4.smul(out, a, s == 0f ? 0f : 1f / s);
    }
    public Vec4 sdiv(float s) { return Vec4.sdiv(this, this, s); }


    public static float lengthSqValues(float x, float y, float z, float w) {
        return x * x + y * y + z * z + w * w;
    }
    public static float lengthValues(float x, float y, float z, float w) {
        float lsq = Vec4.lengthSqValues(x, y, z, w);
        return lsq != 0f ? (float) Math.sqrt(lsq) : 0f;
    }

    public static float dot(Vec4 a, Vec4 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z + a.w * a.w;
    }
    public float dot(Vec4 a) { return Vec4.dot(this, a); }

    public static float length(Vec4 a) { return Vec4.lengthValues(a.x, a.y, a.z, a.w); }
    public float length() { return Vec4.length(this); }


    public static float normalize(Vec4 out, Vec4 a) {
        float x = a.x;
        float y = a.y;
        float z = a.z;
        float w = a.w;
        float length = Vec4.lengthValues(x, y, z, w);
        float invLength = length != 0f ? 1f / length : 0f;

        out.x = x * invLength;
        out.y = y * invLength;
        out.z = z * invLength;
        out.w = w * invLength;

        return length;
    }
    public float normalize() { return Vec4.normalize(this, this); }

    public static Vec4 inverse(Vec4 out, Vec4 a) {
        out.x = -a.x;
        out.y = -a.y;
        out.z = -a.z;
        out.w = -a.w;
        return out;
    }
    public Vec4 inverse() { return Vec4.inverse(this, this); }

    public static Vec4 min(Vec4 out, Vec4 a, Vec4 b) {
        out.x = b.x < a.x ? b.x : a.x;
        out.y = b.y < a.y ? b.y : a.y;
        out.z = b.z < a.z ? b.z : a.z;
        out.w = b.w < a.w ? b.w : a.w;
        return out;
    }
    public Vec4 min(Vec4 a, Vec4 b) { return Vec4.min(this, a, b); }

    public static Vec4 max(Vec4 out, Vec4 a, Vec4 b) {
        out.x = b.x > a.x ? b.x : a.x;
        out.y = b.y > a.y ? b.y : a.y;
        out.z = b.z > a.z ? b.z : a.z;
        out.w = b.w > a.w ? b.w : a.w;
        return out;
    }
    public Vec4 max(Vec4 a, Vec4 b) { return Vec4.max(this, a, b); }

    public static Vec4 transform(Vec4 out, Vec4 a, Mat2 m) {
        float x = a.x;
        float y = a.y;
        float z = a.z;
        float w = a.w;

        out.x = x * m.m[0] + y * m.m[2];
        out.y = x * m.m[1] + y * m.m[3];
        out.z = z;
        out.w = w;

        return out;
    }
    public Vec4 transform(Mat2 m) {
        return Vec4.transform(this, this, m);
    }

    public static Vec4 transform(Vec4 out, Vec4 a, Mat32 m) {
        float x = a.x;
        float y = a.y;
        float z = a.z;
        float w = a.w;

        out.x = x * m.m[0] + y * m.m[2] + m.m[4];
        out.y = x * m.m[1] + y * m.m[3] + m.m[5];
        out.z = z;
        out.w = w;

        return out;
    }
    public Vec4 transform(Mat32 m) {
        return Vec4.transform(this, this, m);
    }

    public static boolean equals(Vec4 a, Vec4 b) {
        return !(
            !Mathf.equals(a.x, b.x) ||
            !Mathf.equals(a.y, b.y) ||
            !Mathf.equals(a.z, b.z) ||
            !Mathf.equals(a.w, b.w)
        );
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Vec4) {
            return Vec4.equals(this, (Vec4) other);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Vec4(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
