package Composite;

public class Rectangle extends Figure {
    private Point point;
    private double largeur;
    private double hauteur;

    public Rectangle(Point point, double largeur, double hauteur) {
        this.point = point;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public double getSurface() {
        return largeur*hauteur;
    }

    @Override
    public double getPerimetre() {
        return 2*(largeur+hauteur);
    }

    @Override
    public void dessiner() {
        System.out.println(tabs()+"Rectangle(coin.x="+point.getX()+", coin.y="+point.getY()+", largeur="+largeur+
                ", hauteur="+hauteur+", "+super.toString()+")");
        System.out.println(tabs()+"Permimetre : " + this.getPerimetre());
        System.out.println(tabs()+"Surface : " + this.getSurface()+"\n");
    }
}
