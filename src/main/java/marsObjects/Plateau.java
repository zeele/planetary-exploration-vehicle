package marsObjects;

import navigation.Coordinates;

/**
 * Plateau data object
 */
public class Plateau {
    private Coordinates topRightCoords;
    private Coordinates bottomLeftCoords = new Coordinates(0, 0);

    public Plateau(Coordinates coordinates) {
        this.topRightCoords = coordinates;
    }


    public Coordinates getTopRightCoords() {
        return topRightCoords;
    }

    public Coordinates getBottomLeftCoords() {
        return bottomLeftCoords;
    }
}
