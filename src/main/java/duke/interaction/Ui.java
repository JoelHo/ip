package duke.interaction;

import duke.common.DukeString;

public class Ui {
    private Ui() {
    }

    /**
     * Prints the given message with a separator.
     * @param msg the message to be printed.
     */
    public static void printOut(final String msg) {
        System.out.println(DukeString.SEPARATOR);
        System.out.println(msg);
        System.out.println(DukeString.SEPARATOR);
    }

    /**
     * Prints the given error with a special separator.
     * @param msg the message to be printed.
     */
    public static void printErr(final String msg) {
        System.out.println(DukeString.SEPARATOR_ERR);
        System.out.println(msg);
        System.out.println(DukeString.SEPARATOR_ERR);
    }
}