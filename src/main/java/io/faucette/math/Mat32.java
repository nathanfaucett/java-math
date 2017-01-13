package io.faucette.math;


public class Mat32 {
    public final float[] m;


    public Mat32(
        float m11, float m12, float m13,
        float m21, float m22, float m23
    ) {
        m = new float[6];
        set(
            m11, m12, m13,
            m21, m22, m23
        );
    }

    public Mat32() {
        this(
            1f, 0f, 0f,
            0f, 1f, 0f
        );
    }

    public static Mat32 set(
        Mat32 out,
        float m11, float m12, float m13,
        float m21, float m22, float m23
    ) {

        out.m[0] = m11; out.m[2] = m12; out.m[4] = m13;
        out.m[1] = m21; out.m[3] = m22; out.m[5] = m23;

        return out;
    }
    public Mat32 set(
        float m11, float m12, float m13,
        float m21, float m22, float m23
    ) {
        return Mat32.set(
            this,
            m11, m12, m13,
            m21, m22, m23
        );
    }

    public float get(int index) { return m[index]; }

    public static Mat32 copy(Mat32 out, Mat32 other) {
        out.m[0] = other.m[0];
        out.m[1] = other.m[1];
        out.m[2] = other.m[2];
        out.m[3] = other.m[3];
        out.m[4] = other.m[4];
        out.m[5] = other.m[5];
        return out;
    }
    public Mat32 copy(Mat32 other) { return Mat32.copy(this, other); }

    public static Mat32 mul(Mat32 out, Mat32 a, Mat32 b) {
        float a11 = a.m[0];
        float a12 = a.m[2];
        float a13 = a.m[4];
        float a21 = a.m[1];
        float a22 = a.m[3];
        float a23 = a.m[5];

        float b11 = b.m[0];
        float b12 = b.m[2];
        float b13 = b.m[4];
        float b21 = b.m[1];
        float b22 = b.m[3];
        float b23 = b.m[5];

        out.m[0] = a11 * b11 + a21 * b12;
        out.m[2] = a12 * b11 + a22 * b12;

        out.m[1] = a11 * b21 + a21 * b22;
        out.m[3] = a12 * b21 + a22 * b22;

        out.m[4] = a11 * b13 + a12 * b23 + a13;
        out.m[5] = a21 * b13 + a22 * b23 + a23;

        return out;
    }
    public Mat32 mul(Mat32 a) { return Mat32.mul(this, this, a); }

    public static Mat32 smul(Mat32 out, Mat32 a, float s) {

        out.m[0] = a.m[0] * s;
        out.m[1] = a.m[1] * s;
        out.m[2] = a.m[2] * s;
        out.m[3] = a.m[3] * s;
        out.m[4] = a.m[4] * s;
        out.m[5] = a.m[5] * s;

        return out;
    }
    public Mat32 smul(float s) { return Mat32.smul(this, this, s); }

    public static Mat32 sdiv(Mat32 out, Mat32 a, float s) {
        return Mat32.smul(out, a, s != 0f ? 1f / s : 0f);
    }
    public Mat32 sdiv(float s) { return Mat32.sdiv(this, this, s); }

    public static Mat32 inverse(Mat32 out, Mat32 a) {
        float m11 = a.m[0];
        float m12 = a.m[2];
        float m13 = a.m[4];
        float m21 = a.m[1];
        float m22 = a.m[3];
        float m23 = a.m[5];

        float det = m11 * m22 - m12 * m21;

        if (det == 0f) {
            return Mat32.identity(out);
        } else {
            det = 1f / det;

            out.m[0] = m22 * det;
            out.m[1] = -m12 * det;
            out.m[2] = -m21 * det;
            out.m[3] = m11 * det;

            out.m[4] = (m21 * m23 - m22 * m13) * det;
            out.m[5] = -(m11 * m23 - m12 * m13) * det;

            return out;
        }
    }
    public Mat32 inverse() { return Mat32.inverse(this, this); }

    public static Mat32 identity(Mat32 out) {

        out.m[0] = 1f; out.m[2] = 0f; out.m[4] = 0f;
        out.m[1] = 0f; out.m[3] = 1f; out.m[5] = 0f;

        return out;
    }
    public Mat32 identity() { return Mat32.identity(this); }

    public static Mat32 setRotation(Mat32 out, double angle) {
        float s = (float) Math.sin(angle);
        float c = (float) Math.cos(angle);

        out.m[0] = c; out.m[2] = -s;
        out.m[1] = s; out.m[3] = c;

        return out;
    }
    public static Mat32 setRotation(Mat32 out, float angle) {
        return Mat32.setRotation(out, (double) angle);
    }

    public Mat32 setRotation(double angle) { return Mat32.setRotation(this, angle); }
    public Mat32 setRotation(float angle) { return Mat32.setRotation(this, angle); }

    public static float getRotation(Mat32 out) {
        return (float) Math.atan2((double) out.m[1], (double) out.m[0]);
    }
    public float getRotation() { return Mat32.getRotation(this); }

    public static Mat32 translate(Mat32 out, Mat32 a, Vec2 v) {
        float x = v.x;
        float y = v.y;

        out.m[0] = a.m[0];
        out.m[1] = a.m[1];

        out.m[2] = a.m[2];
        out.m[3] = a.m[3];

        out.m[4] = a.m[0] * x + a.m[2] * y + a.m[4];
        out.m[5] = a.m[1] * x + a.m[3] * y + a.m[5];

        return out;
    }
    public Mat32 translate(Vec2 v) { return Mat32.translate(this, this, v); }

    public static Mat32 rotate(Mat32 out, Mat32 a, double angle) {
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
    public static Mat32 rotate(Mat32 out, Mat32 a, float angle) {
        return Mat32.rotate(out, a, (double) angle);
    }

    public Mat32 rotate(double angle) { return Mat32.rotate(this, this, angle); }
    public Mat32 rotate(float angle) { return Mat32.rotate(this, this, angle); }

    public static Mat32 scale(Mat32 out, Mat32 a, Vec2 v) {
        float x = v.x;
        float y = v.y;

        out.m[0] = a.m[0] * x;
        out.m[1] = a.m[1] * x;

        out.m[2] = a.m[2] * y;
        out.m[3] = a.m[3] * y;

        out.m[4] = a.m[4];
        out.m[5] = a.m[5];

        return out;
    }
    public Mat32 scale(Vec2 v) { return Mat32.scale(this, this, v); }

    public static Mat32 lookAt(Mat32 out, Vec2 eye, Vec2 target) {
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
    public Mat32 lookAt(Vec2 eye, Vec2 target) {
        return Mat32.lookAt(this, eye, target);
    }

    public static Mat32 compose(Mat32 out, Vec2 position, Vec2 scale, float rotation) {
        return Mat32.compose(out, position, scale, (double) rotation);
    }
    public static Mat32 compose(Mat32 out, Vec2 position, Vec2 scale, double rotation) {
        double sx = scale.x;
        double sy = scale.y;
        double c = Math.cos(rotation);
        double s = Math.sin(rotation);

        out.m[0] = (float) (c * sx);
        out.m[1] = (float) (s * sx);
        out.m[2] = (float) (-s * sy);
        out.m[3] = (float) (c * sy);

        out.m[4] = position.x;
        out.m[5] = position.y;

        return out;
    }
    public Mat32 compose(Vec2 position, Vec2 scale, float rotation) {
        return Mat32.compose(this, position, scale, (double) rotation);
    }
    public Mat32 compose(Vec2 position, Vec2 scale, double rotation) {
        return Mat32.compose(this, position, scale, rotation);
    }

    public static float decompose(Mat32 out, Vec2 position, Vec2 scale) {
        float m11 = out.m[0];
        float m12 = out.m[1];
        float sx = Vec2.lengthValues(m11, m12);
        float sy = Vec2.lengthValues(out.m[2], out.m[3]);

        position.x = out.m[4];
        position.y = out.m[5];

        scale.x = sx;
        scale.y = sy;

        return (float) Math.atan2((double) m12, (double) m11);
    }
    public float decompose(Vec2 position, Vec2 scale) {
        return Mat32.decompose(this, position, scale);
    }

    public static Mat32 orthographic(Mat32 out, float top, float right, float bottom, float left) {
        float w = right - left;
        float h = top - bottom;

        float x = (right + left) / w;
        float y = (top + bottom) / h;

        out.m[0] = 2f / w;
        out.m[1] = 0f;
        out.m[2] = 0f;
        out.m[3] = 2f / h;
        out.m[4] = -x;
        out.m[5] = -y;

        return out;
    }
    public Mat32 orthographic(float top, float right, float bottom, float left) {
        return Mat32.orthographic(this, top, right, bottom, left);
    }

    public static boolean equals(Mat32 a, Mat32 b) {
        return !(
            !Mathf.equals(a.m[0], b.m[0]) ||
            !Mathf.equals(a.m[1], b.m[1]) ||
            !Mathf.equals(a.m[2], b.m[2]) ||
            !Mathf.equals(a.m[3], b.m[3]) ||
            !Mathf.equals(a.m[4], b.m[4]) ||
            !Mathf.equals(a.m[5], b.m[5])
        );
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Mat32) {
            return Mat32.equals(this, (Mat32) other);
        } else {
            return false;
        }
    }

    public float[] getValues() { return m; }

    @Override
    public String toString() {
        return (
            "Mat32[" + m[0] + ", " + m[2] + ", " + m[4] + ",\n" +
            "     " + m[1] + ", " + m[3] + ", " + m[5] + "]"
        );
    }
}
