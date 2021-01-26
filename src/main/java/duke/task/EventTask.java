package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import duke.common.DukeString;

public class EventTask extends Task {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    /**
     * Constructs a new event task with the given description and dates.
     * @param desc the description of the task
     * @param start the start date of the event
     * @param end the end date of the event
     */
    public EventTask(final String desc, final LocalDateTime start, final LocalDateTime end) {
        super(desc);
        this.startDate = start;
        this.endDate = end;
    }

    private EventTask(boolean done, String desc, final LocalDateTime start, final LocalDateTime end) {
        super(desc);
        super.isDone = done;
        this.startDate = start;
        this.endDate = end;
    }

    @Override
    public String serialise() {
        return String.format(
                "%s\255%b\255%s\255%s\255%s",
                DukeString.COMMAND_EVENT,
                super.isDone,
                super.description,
                startDate.toString(),
                endDate.toString()
        );
    }

    /**
     * Constructs a new EventTask given the serialised input read from storage.
     * @param input the serialised input to be parsed
     * @return a new EventTask with the associated fields
     */
    public static EventTask deserialise(String input) {
        String[] tokens = input.split("\255");
        return new EventTask(
                tokens[1].equals("true"),
                tokens[2],
                LocalDateTime.parse(tokens[3]),
                LocalDateTime.parse(tokens[4])
        );
    }

    @Override
    public String toString() {
        return String.format(
                "[E]%s (from: %s to %s)",
                super.toString(),
                startDate.format(DateTimeFormatter.ofPattern("dd LLL uu hhmma")),
                endDate.format(DateTimeFormatter.ofPattern("dd LLL uu hhmma"))
        );
    }
}