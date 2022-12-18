package Composite;

import java.util.ArrayList;
import java.util.List;

public class GroupeFigures extends Figure{
    private List<Figure> figures = new ArrayList<>();

    public Figure add(Figure figure){
        figure.niveau=this.niveau+1;
        figures.add(figure);
        return figure;
    }

    public void remove(Figure figure){
        figures.remove(figure);
    }

    public List<Figure> getChildren() {
        return figures;
    }

    @Override
    public double getSurface() {
        return this.figures.stream().mapToDouble(figure -> figure.getSurface()).sum();
    }

    @Override
    public double getPerimetre() {
        return this.figures.stream().mapToDouble(figure -> figure.getPerimetre()).sum();
    }

    @Override
    public void dessiner() {
        System.out.println(tabs() + "Groue de figure : ");
        if(!figures.isEmpty())
            this.figures.forEach(figure -> figure.dessiner());
        System.out.println(tabs()+"Groue Permimetre : " + this.getPerimetre());
        System.out.println(tabs()+"Groue Surface : " + this.getSurface()+"\n");
    }
}
