package patterns.strategy;

import Composite.Figure;

import java.util.List;

public interface Strategy {
    public void traiter(List<Figure> figures);
}
