package parser;

import com.google.common.collect.Lists;
import movementCommands.ICommand;
import movementCommands.MoveForwardCommand;
import movementCommands.TurnLeftCommand;
import movementCommands.TurnRightCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @ParameterizedTest(name = "{0)")
    @DisplayName("Test getCommands")
    @MethodSource("getCommandsTestCases")
    void getCommands(String testName, String input, List<ICommand> expectedCommands) {
        assertEquals(Parser.getCommands(input), expectedCommands);
    }

    private static Stream<Arguments> getCommandsTestCases() throws Exception {
        List<ICommand> list1 = Lists.newArrayList();
        list1.add(new TurnLeftCommand());
        list1.add(new MoveForwardCommand());
        list1.add(new TurnRightCommand());

        return Stream.of(
                Arguments.of("Test 1", "LMR", list1)
        );
    }

    void getCoordinates() {}

    void getDirection() {}
}
