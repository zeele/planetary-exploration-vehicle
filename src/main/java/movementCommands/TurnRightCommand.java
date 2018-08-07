package movementCommands;

import marsObjects.MarsRover;

public class TurnRightCommand implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnRight();
    }

}
