package marsObjects;

import movementCommands.ICommand;
import navigation.BoundsChecker;
import navigation.Coordinates;
import navigation.Direction;

import java.util.List;

/**
 * MarsRover represents the rover object. This model has behavior and state.
 * We only expose the behavior to the outside world.
 * <p>
 * The rover gets instantiated with plateau, direction and coordinates as it is
 * deployed on a plateau facing an initial direction, with coordinates.
 * <p>
 * It exposes functions to the outside world that can move it forward or turn left
 * or right or rotate. The verbs indicate the actions
 */
public class MarsRover {

    private Coordinates coordinates;
    private Direction direction;
    private Plateau plateau;

    public MarsRover(final Plateau plateau, final Direction direction, final Coordinates coordinates) {
        this.plateau = plateau;
        this.direction = direction;
        this.coordinates = coordinates;
        System.out.print(coordinates.getX() + " " + coordinates.getY());
    }

    public void navigate(List<ICommand> commands) {
        for (ICommand command : commands) {
            command.execute(this);
        }
    }

    public void moveForward() {
        Coordinates positionAfterMove = new Coordinates(
                coordinates.getX() + this.direction.movementOnXAxis(),
                coordinates.getY() + this.direction.movementOnYAxis());

        if (BoundsChecker.isWithinBounds(this.plateau, positionAfterMove)) {
            coordinates = positionAfterMove;
        }
    }

    public String getLocation() {
        return coordinates.toString() + " " + direction.toString();
    }

    public void turnRight() {
        this.direction = this.direction.right();
    }

    public void turnLeft() {
        this.direction = this.direction.left();
    }
}
