package movementCommands;

import marsObjects.MarsRover;

public class TurnLeftCommand implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnLeft();
    }

}
