package parser;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import exception.BadUserInputException;
import movementCommands.ICommand;
import movementCommands.MoveForwardCommand;
import movementCommands.TurnLeftCommand;
import movementCommands.TurnRightCommand;
import navigation.Coordinates;
import navigation.Direction;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Has static functions that helps decode input strings.
 */
public class Parser {

    private static final Map<String, ICommand> stringToCommandMap = ImmutableMap
            .of("L", new TurnLeftCommand(),
                "R", new TurnRightCommand(),
                "M", new MoveForwardCommand());


    public static List<ICommand> getCommands(String input) {
        if(StringUtils.isBlank(input)) {
            return Collections.emptyList();
        }

        List<ICommand> commands = Lists.newArrayList();
        String[] arrayOfCommands = input.split("");

        for(String command : arrayOfCommands) {
            if (command == null) {
                break;
            }

            ICommand mappedCommand = stringToCommandMap.get(command);
            commands.add(mappedCommand);
        }

        return commands;
    }

    public static Coordinates getCoordinates(String input) {
        try {
            String inputWithoutSpaces = input.replaceAll("\\s+", "");
            int x = Integer.parseInt(inputWithoutSpaces.substring(0, 1));
            int y = Integer.parseInt(inputWithoutSpaces.substring(1, 2));
            return new Coordinates(x, y);
        } catch (Exception e) {
            throw new BadUserInputException(input);
        }
    }

    public static Direction getDirection (String input) {
        String inputWithoutSpaces = input.replaceAll("\\s+", "");
        String directionLetter = inputWithoutSpaces.substring(inputWithoutSpaces.length() -1);
        return Direction.stringToDirectionMap.get(directionLetter);
    }
}
