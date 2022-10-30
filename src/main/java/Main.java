import Composite.*;
import patterns.observer.Parametrage;
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------Cercle--------------------");
        Figure figure1=new Cercle(new Point(12,30),25);
        System.out.println("Permimetre : " + figure1.getPerimetre());
        System.out.println("Surface : " + figure1.getSurface());
        figure1.dessiner();

        System.out.println("-------------------Rectangle------------------");
        Figure figure2=new Rectangle(new Point(1,2),10,15);
        System.out.println("Permimetre : " + figure2.getPerimetre());
        System.out.println("Surface : " + figure2.getSurface());
        figure2.dessiner();

        System.out.println("---------------Apres traitements--------------");
        Parametrage parametrageObservale=new Parametrage();
        parametrageObservale.addObserver(figure1);
        parametrageObservale.addObserver(figure2);
        parametrageObservale.setCouleurContour(155);
        parametrageObservale.setCouleurRemplissage(250);
        parametrageObservale.setEpaisseurContour(5);
        figure1.dessiner();
        figure2.dessiner();
    }
}