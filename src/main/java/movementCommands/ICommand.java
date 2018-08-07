package movementCommands;

import marsObjects.MarsRover;

/**
 * Command pattern. Instead of using branching (switch/ if else) to distinguish the flow
 * (as we would be binding flows together and making it very unreadable), this allows us
 * more flexibility . Decouples the object that invokes the operation from the one that knows
 * how to perform it.
 */
public interface ICommand {

    void execute(final MarsRover rover);

}
