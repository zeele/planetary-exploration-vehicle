package common;

import marsObjects.Plateau;
import navigation.Coordinates;

public class CommonMockObjects {

    static final int mockXCoord = Integer.MAX_VALUE;
    static final int mockYCoord = Integer.MAX_VALUE;

    static Coordinates getMockCoords() {
        return new Coordinates(mockXCoord, mockYCoord);
    }

    public static Plateau getMockPlateau() {
        return new Plateau(getMockCoords());
    }
}
