io.faucette.math [![Build Status](https://travis-ci.org/nathanfaucett/io.faucette.math.svg?branch=master)](https://travis-ci.org/nathanfaucett/io.faucette.math)
=======

vector and matrix math for games

```java
import io.faucette.math.Mathf;
import io.faucette.math.Vec2;
import io.faucette.math.Mat2;
import io.faucette.math.Mat32;
import io.faucette.math.AABB2;


Vec2 v = new Vec2(0f, 1f);

Mat2 m2 = new Mat2();
m2.rotate(Math.PI / 2);

Mat32 m32 = new Mat32();
m32.translate(new Vec2(-1f, 0f));

v.transformMat2(m2);
v.transformMat32(m32);


AABB2 a = new AABB2();
a.fromCenterSize(new Vec2(1f, 1f), new Vec2(2f, 2f));

AABB2 b = new AABB2();
b.fromCenterSize(new Vec2(0f, 0f), new Vec2(2f, 2f));

a.contains(new Vec2(1f, 1f));
b.contains(new Vec2(3f, 1f));
a.intersects(b);
```
