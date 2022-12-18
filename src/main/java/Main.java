import Composite.*;
import patterns.observer.Parametrage;
import patterns.strategy.Strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Dessin dessin=new Dessin();

        GroupeFigures root= (GroupeFigures) dessin.add(new GroupeFigures());

        Figure figure1= root.add(new Cercle(new Point(12,30),25));

        Figure figure2= root.add(new Rectangle(new Point(1,2),10,15));

        GroupeFigures groupe1= (GroupeFigures) root.add(new GroupeFigures());

        Figure figure3= groupe1.add(new Rectangle(new Point(0,3),5,8));

        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("Donner le nom de la classe de la strategie de dessiner (patterns.strategy.DefaultStrategy,patterns.strategy.StrategyImpl1,patterns.strategy.StrategyImpl2): ");
            String strategyClassName = scanner.nextLine();
            Strategy strategy = (Strategy) Class.forName(strategyClassName).getDeclaredConstructor().newInstance();
            dessin.setStrategy(strategy);
            dessin.appliquerStrategyTraitement();

            System.out.println("\n---------------Apres traitements--------------");
            Parametrage parametrageObservale=new Parametrage();
            parametrageObservale.addObserver(figure3);
            parametrageObservale.setCouleurContour(155);
            parametrageObservale.setCouleurRemplissage(250);
            parametrageObservale.setEpaisseurContour(5);
            figure3.dessiner();

            System.out.println("taper q pour quitter sinon taper n'importe quoi pour repeter");
            String quitter = scanner.nextLine();
            if (quitter.equals("q"))
                break;
        }
    }
}