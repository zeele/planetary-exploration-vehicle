package navigation;

import marsObjects.Plateau;

/**
 * BoundsChecker checks whether x, y coords are within range of plateau
 */
public class BoundsChecker {

    public static boolean isWithinBounds(Plateau plateau, Coordinates coordinates) {
        int xCoord = coordinates.getX();
        int yCoord = coordinates.getY();

        Coordinates topRightCoords = plateau.getTopRightCoords();
        Coordinates bottomLeftCoords = plateau.getBottomLeftCoords();

        int topRightXCoord = topRightCoords.getX();
        int topRightYCoord = topRightCoords.getY();
        int bottomLeftXCoord = bottomLeftCoords.getX();
        int bottomLeftYCoord = bottomLeftCoords.getY();

        return xCoord <= topRightXCoord && yCoord <= topRightYCoord &&
                xCoord >= bottomLeftXCoord && yCoord >= bottomLeftYCoord;
    }
}
