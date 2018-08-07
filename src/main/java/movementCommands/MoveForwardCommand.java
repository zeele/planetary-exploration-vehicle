package movementCommands;

import marsObjects.MarsRover;

/**
 *
 */
public class MoveForwardCommand implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.moveForward();
    }
}
