package navigation;
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        StringBuilder coordinateResult = new StringBuilder();
        coordinateResult.append(x);
        coordinateResult.append(" ");
        coordinateResult.append(y);
        return coordinateResult.toString();
    }
}
