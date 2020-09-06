public class Rectangle extends Drawable {
    public Rectangle(double w, double h){
        this.w = w;
        this.h = h;
    }
    public void scale(double xsize, double ysize){
        this.w *= xsize;
        this.h *= ysize;
    }

    public void draw(){}
    private double w, h;
}
