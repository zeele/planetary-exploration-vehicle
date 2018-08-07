package marsObjects;

import common.CommonMockObjects;
import navigation.Coordinates;
import navigation.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test exposed functionality in MarsRover class
 */
class MarsRoverTest {

    @ParameterizedTest(name = "{0)")
    @DisplayName("Test marsRover moveForward behavior")
    @MethodSource("moveForwardTestCases")
    void moveForward(String testName, MarsRover rover, String expectedLocation) {
        rover.moveForward();
        assertEquals(rover.getLocation(), expectedLocation);
    }

    private static Stream<Arguments> moveForwardTestCases() throws Exception {
        Plateau plateau = CommonMockObjects.getMockPlateau();

        return Stream.of(
                Arguments.of("Moving forward facing north",
                        new MarsRover(plateau, Direction.N, new Coordinates(1,1)),
                        "1,2"),
                Arguments.of("Moving forward facing south",
                        new MarsRover(plateau, Direction.S, new Coordinates(1,1)),
                        "1,0")
        );
    }

    void getLocation () {}

    void turnRight() {}

    void turnLeft() {}

    void navigate() {}
}
