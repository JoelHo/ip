package duke.interaction;

import java.time.LocalDateTime;
import java.util.Scanner;

import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.ExitCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;
import duke.common.DukeException;
import duke.common.DukeString;


public class Parser {
    private boolean isBye;

    /**
     * Constructs a new Parser.
     */
    public Parser() {
        this.isBye = false;
    }

    /**
     * Getter for the bye field.
     * Used to indicate that the parser received a bye.
     * @return the value of bye
     */
    public boolean isBye() {
        return this.isBye;
    }

    /**
     * Parse the input as given, construct the appropriate command with content, if any.
     * @param input the command string to be parsed from the user
     * @return the appropriate command with content and dates, if any
     * @throws DukeException.InvalidCommand if there is no command found
     * @throws DukeException.InvalidTask if the task specified for done or delete is invalid
     * @throws DukeException.EmptyDescription if the description for a task is empty
     * @throws DukeException.EmptyDeadlineDate if the command is deadline and no date is specified
     * @throws DukeException.EmptyEventDate if the command is event and both dates are not specified
     * @throws DukeException.InvalidEventEnd if the command is event and the end is before the start
     */
    public Command parseInput(final String input) throws
            DukeException.InvalidCommand,
            DukeException.InvalidTask,
            DukeException.EmptyDescription,
            DukeException.EmptyDeadlineDate,
            DukeException.EmptyEventDate,
            DukeException.InvalidEventEnd {
        Scanner scanner = new Scanner(input);
        String[] tokens;

        if (!scanner.hasNext()) {
            throw new DukeException.InvalidCommand();
        }
        switch (scanner.next().toLowerCase()) {
        case DukeString.COMMAND_BYE:
            this.isBye = true;
            return new ExitCommand();
        case DukeString.COMMAND_LIST:
            return new ListCommand();
        case DukeString.COMMAND_DONE:
            if (!scanner.hasNextInt()) {
                throw new DukeException.InvalidTask();
            }
            return new DoneCommand(scanner.nextInt());
        case DukeString.COMMAND_DELETE:
            if (!scanner.hasNextInt()) {
                throw new DukeException.InvalidTask();
            }
            return new DeleteCommand(scanner.nextInt());
        case DukeString.COMMAND_DEADLINE:
            if (!scanner.hasNext()) {
                throw new DukeException.EmptyDescription(DukeString.COMMAND_DEADLINE);
            }

            tokens = scanner.nextLine().split(DukeString.COMMAND_DEADLINE_SEP);

            if (tokens.length < 2 || tokens[1].isBlank()) {
                throw new DukeException.EmptyDeadlineDate();
            }

            return new DeadlineCommand(tokens[0].trim(), LocalDateTime.parse(tokens[1].trim()));
        case DukeString.COMMAND_EVENT:
            if (!scanner.hasNext()) {
                throw new DukeException.EmptyDescription(DukeString.COMMAND_EVENT);
            }

            tokens = scanner.nextLine().split(DukeString.COMMAND_EVENT_SEP);

            if (tokens.length < 2 || tokens[1].isBlank()) {
                throw new DukeException.EmptyEventDate();
            }

            String[] dates = tokens[1].split(DukeString.COMMAND_EVENT_TO);

            if (dates.length < 2 || dates[0].isBlank() || dates[1].isBlank()) {
                throw new DukeException.EmptyEventDate();
            }

            if (LocalDateTime.parse(dates[0].trim()).compareTo(LocalDateTime.parse(dates[1].trim())) >= 0) {
                throw new DukeException.InvalidEventEnd();
            }

            return new EventCommand(
                    tokens[0].trim(),
                    LocalDateTime.parse(dates[0].trim()),
                    LocalDateTime.parse(dates[1].trim())
            );
        case DukeString.COMMAND_TODO:
            if (!scanner.hasNext()) {
                throw new DukeException.EmptyDescription(DukeString.COMMAND_TODO);
            }
            return new TodoCommand(scanner.nextLine().trim());
        default:
            throw new DukeException.InvalidCommand();

        }
    }
}