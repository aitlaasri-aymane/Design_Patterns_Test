package Composite;

import patterns.observer.Observer;
import patterns.observer.Parametrage;

import java.io.Serializable;

public abstract class Figure implements Serializable, Observer {
    protected int epaisseur;
    protected int couleurContour;
    protected int couleurRemplissage;
    protected int niveau=0;
    public abstract double getSurface();
    public abstract double getPerimetre();
    public abstract void dessiner();

    @Override
    public String toString() {
        return
                "epaisseur=" + epaisseur +
                ", couleurContour=" + couleurContour +
                ", couleurRemplissage=" + couleurRemplissage ;
    }

    public int getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(int epaisseur) {
        this.epaisseur = epaisseur;
    }

    public int getCouleurContour() {
        return couleurContour;
    }

    public void setCouleurContour(int couleurContour) {
        this.couleurContour = couleurContour;
    }

    public int getCouleurRemplissage() {
        return couleurRemplissage;
    }

    public void setCouleurRemplissage(int couleurRemplissage) {
        this.couleurRemplissage = couleurRemplissage;
    }

    @Override
    public void update(Parametrage parametrage) {
        if(this.epaisseur != parametrage.getEpaisseurContour())
            System.out.println("Observer => epaisseur has been changed to " + parametrage.getEpaisseurContour());
        if(this.couleurContour != parametrage.getCouleurContour())
            System.out.println("Observer => couleurContour has been changed to " + parametrage.getCouleurContour());
        if(this.couleurRemplissage != parametrage.getCouleurRemplissage())
            System.out.println("Observer => couleurRemplissage has been changed to " + parametrage.getCouleurRemplissage());
        this.epaisseur=parametrage.getEpaisseurContour();
        this.couleurContour=parametrage.getCouleurContour();
        this.couleurRemplissage=parametrage.getCouleurRemplissage();
    }

    protected String tabs(){
        String tabs="";
        for (int i = 0; i < this.niveau ; i++) {
            tabs+="\t";
        }
        return tabs;
    }
}
