import marsObjects.MarsRover;
import marsObjects.Plateau;
import movementCommands.ICommand;
import navigation.Coordinates;
import navigation.Direction;
import parser.Parser;

import java.util.List;
import java.util.Scanner;

//Could add a user input  class and do something like that
//@Target({FIELD, PARAMETER})
//@Retention(RUNTIME)
//@Documented
//@Constraint(validatedBy = {})
//@Size(min = 10, max = 10)
//@Pattern(regexp = "[0-9]*") //matching yyyyMmDdHh
//public @interface InstallDate {
//
//    String message() default "Invalid Install Date";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}
public class MarsRoverController {

    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the upper Right Coordinates of the plateau (e.g. x y):");
        String input = scanner.nextLine();
        Coordinates upperRightCoords = Parser.getCoordinates(input);
        Plateau plateau = new Plateau(upperRightCoords);

        String cont = "Y";
        do
        {
            System.out.println("Enter coordinates and direction of rover (e.g. x y N)");
            input = scanner.nextLine();
            Coordinates coordinates = Parser.getCoordinates(input);
            Direction direction = Parser.getDirection(input);
            MarsRover rover = new MarsRover(plateau, direction, coordinates);

            System.out.println("Enter navigation commands (e.g. LRM):");
            input = scanner.nextLine().toUpperCase();
            List<ICommand> commands = Parser.getCommands(input);
            rover.navigate(commands);
            System.out.println(rover.getLocation());

            System.out.println("Add another rover? (Y/N)");
            cont = scanner.nextLine();
        } while("Y".equalsIgnoreCase(cont));
    }

}
