# CS61B Lecture #9: Interfaces and Abstract Classes

## Recreation:
    Show that for any polynomial with a leading coefficient of 1 and integral coefficients, all rational roots are integers.

    Suppose x = a/b, (a,b)=1;
    a^n + k_(n-1) a^(n-1)b + ... +k_0 a_0 b^n = 0;
    b|a^n
    b = (b,a^n) = 1
    x = a

## Abstract Methods and Classes
```java
/** A drawable object. */
public abstract class Drawable {
    // "abstract class" = "can’t say new Drawable"
    /** Expand THIS by a factor of XSIZE in the X direction,
    * and YSIZE in the Y direction. */
    public abstract void scale(double xsize, double ysize);
    /** Draw THIS on the standard output. */
    public abstract void draw();
}

```
## Concrete Subclasses:

• Regular classes can extend abstract ones to make them “less abstract” by overriding their abstract methods.


• Can define kinds of **Drawable**s that are **concrete**, in that all methods have implementations and one can use **new** on them:
```java
public class Rectangle extends Drawable {
    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public void scale(double xsize, double ysize) {
        w *= xsize;
        h *= ysize;
    }

    public void draw() {
    };// { draw a w x h rectangle }

    private double w, h;
}

```
**Any Oval or Rectangle is a Drawable.**
```java
public class Oval extends Drawable {
    public Oval(double xrad, double yrad) {
        this.xrad = xrad;
        this.yrad = yrad;
    }

    public void scale(double xsize, double ysize) {
        xrad *= xsize;
        yrad *= ysize;
    }

    public void draw() {
    }; // { draw an oval with axes xrad and yrad }

    private double xrad, yrad;
}
```
