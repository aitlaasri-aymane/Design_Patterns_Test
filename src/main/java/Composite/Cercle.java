package Composite;

public class Cercle extends Figure {
    private Point centre;
    private double rayon;

    public Cercle(Point centre, double rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    @Override
    public double getSurface() {
        return Math.PI*rayon*rayon;
    }

    @Override
    public double getPerimetre() {
        return 2*Math.PI*rayon;
    }

    @Override
    public void dessiner() {
        System.out.println(tabs()+"Cercle(centre.x="+centre.getX()+", centre.y="+centre.getY()+", rayon="+rayon+", "+super.toString()+")");
        System.out.println(tabs()+"Permimetre : " + this.getPerimetre());
        System.out.println(tabs()+"Surface : " + this.getSurface() +"\n");
    }
}
