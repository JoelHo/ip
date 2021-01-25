package duke.task;

import duke.common.DukeException;
import duke.common.DukeString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private final List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    private TaskList(List<Task> list) {
        this.taskList = list;
    }


    public static TaskList deserialise(String input) throws DukeException.StorageError {
        List<Task> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            switch (line.split("\255")[0]) {
            case DukeString.COMMAND_DEADLINE :
                list.add(DeadlineTask.deserialise(line));
            case DukeString.COMMAND_EVENT :
                list.add(EventTask.deserialise(line));
            case DukeString.COMMAND_TODO :
                list.add(TodoTask.deserialise(line));
            default:
                throw new DukeException.StorageError();
            }
        }

        return new TaskList(list);
    }

    public void addTask(final Task task) {
        taskList.add(task);
    }

    public String doneTask(final int idx) {
        taskList.get(idx - 1).markDone();
        return taskList.get(idx - 1).toString();
    }

    public String deleteTask(final int idx) {
        return taskList.remove(idx - 1).toString();
    }

    public int size() {
        return taskList.size();
    }

    public String serialise() {
        StringBuilder out = new StringBuilder();
        for (Task task : taskList) {
            out.append(task.serialise());
            out.append('\n');
        }

        return out.toString();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < taskList.size(); i++) {
            out.append(i + 1);
            out.append(". ");
            out.append(taskList.get(i));

            if (i != taskList.size() - 1) {
                out.append('\n');
            }
        }

        return out.toString();
    }
}
