package duke.common;

public final class DukeString {
    public static final String SEPARATOR = "--------------------------------------";
    public static final String SEPARATOR_ERR = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";

    public static final String MESSAGE_WELCOME = "Hello! I'm Duke\nWhat can I do for you?";
    public static final String MESSAGE_BYE = "Goodbye!";
    public static final String MESSAGE_DONE = "Nice! I've marked this as done: ";
    public static final String MESSAGE_ADDED = "Got it. I've added this task:\n\t%s\nNow you have %d tasks.";
    public static final String MESSAGE_LIST = "Here are the tasks in your list:\n";
    public static final String MESSAGE_LIST_EMPTY = "You have no tasks.";
    public static final String MESSAGE_DELETE = "Got it. I've removed this task:\n\t%s\nNow you have %d tasks.";

    public static final String COMMAND_BYE = "bye";
    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_DONE = "done";
    public static final String COMMAND_DEADLINE = "deadline";
    public static final String COMMAND_DEADLINE_SEP = "/by";
    public static final String COMMAND_EVENT = "event";
    public static final String COMMAND_EVENT_SEP = "/at";
    public static final String COMMAND_EVENT_TO = "/to";
    public static final String COMMAND_TODO = "todo";
    public static final String COMMAND_DELETE = "delete";

    public static final String EXCEPTION_INVALID_COMMAND = "Sorry, I did not understand that.";
    public static final String EXCEPTION_EMPTY_DESCRIPTION = "Sorry, the description of a %s cannot be empty.";
    public static final String EXCEPTION_INVALID_TASK = "Sorry, I could not find that task.";
    public static final String EXCEPTION_EMPTY_DEADLINE_DATE = "Sorry, the date of a deadline must be specified.";
    public static final String EXCEPTION_EMPTY_EVENT_DATE =
            "Sorry, the start and end date of an event must be specified.";
    public static final String EXCEPTION_INVALID_EVENT_END =
            "Sorry, the end date of an event must be after the start date.";
    public static final String EXCEPTION_STORAGE_READ_ERROR =
            "Sorry, there has been an error reading your tasks.\nMaking a copy of your tasks at data/duke.bak.";
    public static final String EXCEPTION_STORAGE_WRITE_ERROR = "Sorry, there has been an error writing your tasks.";

    private DukeString() {

    }
}