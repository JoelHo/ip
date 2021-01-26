package duke.common;

public class DukeException {
    public static class InvalidCommand extends IllegalArgumentException {
        public InvalidCommand() {
            super(DukeString.EXCEPTION_INVALID_COMMAND);
        }
    }

    public static class EmptyDescription extends IllegalArgumentException {
        public EmptyDescription(final String type) {
            super(String.format(DukeString.EXCEPTION_EMPTY_DESCRIPTION, type));
        }
    }

    public static class InvalidTask extends IllegalArgumentException {
        public InvalidTask() {
            super(DukeString.EXCEPTION_INVALID_TASK);
        }
    }

    public static class EmptyDeadlineDate extends IllegalArgumentException {
        public EmptyDeadlineDate() {
            super(DukeString.EXCEPTION_EMPTY_DEADLINEDATE);
        }
    }


    public static class EmptyEventDate extends IllegalArgumentException {
        public EmptyEventDate() {
            super(DukeString.EXCEPTION_EMPTY_EVENTDATE);
        }
    }

    public static class InvalidEventEnd extends IllegalArgumentException {
        public InvalidEventEnd() {
            super(DukeString.EXCEPTION_INVALID_EVENTEND);
        }
    }

    public static class StorageReadError extends IllegalArgumentException {
        public StorageReadError() {
            super(DukeString.EXCEPTION_STORAGE_READ_ERROR);
        }
    }
    
    public static class StorageWriteError extends IllegalArgumentException {
        public StorageWriteError() {
            super(DukeString.EXCEPTION_STORAGE_WRITE_ERROR);
        }
    }
}
