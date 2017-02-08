package io.faucette.math;


public class Mat2 {
    public final float[] m;


    public Mat2(
        float m11, float m12,
        float m21, float m22
    ) {
        m = new float[4];
        set(
            m11, m12,
            m21, m22
        );
    }
    public Mat2(Mat2 m) {
        this(
            m.m[0], m.m[2],
            m.m[1], m.m[3]
        );
    }
    public Mat2() {
        this(
            1f, 0f,
            0f, 1f
        );
    }

    public static Mat2 set(
        Mat2 out,
        float m11, float m12,
        float m21, float m22
    ) {

        out.m[0] = m11; out.m[2] = m12;
        out.m[1] = m21; out.m[3] = m22;

        return out;
    }
    public Mat2 set(
        float m11, float m12,
        float m21, float m22
    ) {
        return Mat2.set(
            this,
            m11, m12,
            m21, m22
        );
    }

    public float get(int index) { return m[index]; }

    public static Mat2 copy(Mat2 out, Mat2 other) {
        out.m[0] = other.m[0];
        out.m[1] = other.m[1];
        out.m[2] = other.m[2];
        out.m[3] = other.m[3];
        return out;
    }
    public Mat2 copy(Mat2 other) { return Mat2.copy(this, other); }

    public static Mat2 mul(Mat2 out, Mat2 a, Mat2 b) {
        float a11 = a.m[0];
        float a12 = a.m[2];
        float a21 = a.m[1];
        float a22 = a.m[3];

        float b11 = b.m[0];
        float b12 = b.m[2];
        float b21 = b.m[1];
        float b22 = b.m[3];

        out.m[0] = a11 * b11 + a21 * b12;
        out.m[2] = a12 * b11 + a22 * b12;

        out.m[1] = a11 * b21 + a21 * b22;
        out.m[3] = a12 * b21 + a22 * b22;

        return out;
    }
    public Mat2 mul(Mat2 a) { return Mat2.mul(this, this, a); }

    public static Mat2 smul(Mat2 out, Mat2 a, float s) {

        out.m[0] = a.m[0] * s;
        out.m[1] = a.m[1] * s;
        out.m[2] = a.m[2] * s;
        out.m[3] = a.m[3] * s;

        return out;
    }
    public Mat2 smul(float s) { return Mat2.smul(this, this, s); }

    public static Mat2 sdiv(Mat2 out, Mat2 a, float s) {
        return Mat2.smul(out, a, s != 0f ? 1f / s : 0f);
    }
    public Mat2 sdiv(float s) { return Mat2.sdiv(this, this, s); }

    public static Mat2 inverse(Mat2 out, Mat2 a) {
        float m11 = a.m[0];
        float m12 = a.m[2];
        float m21 = a.m[1];
        float m22 = a.m[3];

        float det = m11 * m22 - m12 * m21;

        if (det == 0f) {
            return Mat2.identity(out);
        } else {
            det = 1f / det;

            out.m[0] = m22 * det;
            out.m[1] = -m12 * det;
            out.m[2] = -m21 * det;
            out.m[3] = m11 * det;

            return out;
        }
    }
    public Mat2 inverse() { return Mat2.inverse(this, this); }

    public static Mat2 identity(Mat2 out) {

        out.m[0] = 1f; out.m[2] = 0f;
        out.m[1] = 0f; out.m[3] = 1f;

        return out;
    }
    public Mat2 identity() { return Mat2.identity(this); }

    public static Mat2 setRotation(Mat2 out, double angle) {
        float s = (float) Math.sin(angle);
        float c = (float) Math.cos(angle);

        out.m[0] = c; out.m[2] = -s;
        out.m[1] = s; out.m[3] = c;

        return out;
    }
    public static Mat2 setRotation(Mat2 out, float angle) {
        return Mat2.setRotation(out, (double) angle);
    }

    public Mat2 setRotation(double angle) { return Mat2.setRotation(this, angle); }
    public Mat2 setRotation(float angle) { return Mat2.setRotation(this, angle); }

    public static float getRotation(Mat2 out) {
        return (float) Math.atan2((double) out.m[1], (double) out.m[0]);
    }
    public float getRotation() { return Mat2.getRotation(this); }

    public static Mat2 rotate(Mat2 out, Mat2 a, double angle) {
        float m11 = a.m[0];
        float m12 = a.m[2];
        float m21 = a.m[1];
        float m22 = a.m[3];

        float s = (float) Math.sin(angle);
        float c = (float) Math.cos(angle);

        out.m[0] = m11 * c + m12 * -s;
        out.m[2] = m21 * c + m22 * -s;

        out.m[1] = m11 * s + m12 * c;
        out.m[3] = m21 * s + m22 * c;

        return out;
    }
    public static Mat2 rotate(Mat2 out, Mat2 a, float angle) {
        return Mat2.rotate(out, a, (double) angle);
    }

    public Mat2 rotate(double angle) { return Mat2.rotate(this, this, angle); }
    public Mat2 rotate(float angle) { return Mat2.rotate(this, this, angle); }

    public static Mat2 scale(Mat2 out, Mat2 a, Vec2 v) {
        float x = v.x;
        float y = v.y;

        out.m[0] = a.m[0] * x;
        out.m[1] = a.m[1] * x;

        out.m[2] = a.m[2] * y;
        out.m[3] = a.m[3] * y;

        return out;
    }
    public Mat2 scale(Vec2 v) { return Mat2.scale(this, this, v); }

    public static Mat2 lookAt(Mat2 out, Vec2 eye, Vec2 target) {
        double x = target.x - eye.x;
        double y = target.y - eye.y;
        double a = Math.atan2(y, x) - Mathf.HALF_PI;
        double c = Math.cos(a);
        double s = Math.sin(a);

        out.m[0] = (float) c;
        out.m[1] = (float) s;
        out.m[2] = (float) -s;
        out.m[3] = (float) c;

        return out;
    }
    public Mat2 lookAt(Vec2 eye, Vec2 target) {
        return Mat2.lookAt(this, eye, target);
    }

    public static boolean equals(Mat2 a, Mat2 b) {
        return !(
            !Mathf.equals(a.m[0], b.m[0]) ||
            !Mathf.equals(a.m[1], b.m[1]) ||
            !Mathf.equals(a.m[2], b.m[2]) ||
            !Mathf.equals(a.m[3], b.m[3])
        );
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Mat2) {
            return Mat2.equals(this, (Mat2) other);
        } else {
            return false;
        }
    }

    public float[] getValues() { return m; }

    @Override
    public String toString() {
        return (
            "Mat2[" + m[0] + ", " + m[2] + ",\n" +
            "     " + m[1] + ", " + m[3] + "]"
        );
    }
}
