public abstract class Drawable {
    public abstract void scale(double xsize, double ysize);

    public abstract void draw();

    void drawAll(Drawable[] thingsToDraw) {
        for (Drawable thing : thingsToDraw)
            thing.draw();
    }
}

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
