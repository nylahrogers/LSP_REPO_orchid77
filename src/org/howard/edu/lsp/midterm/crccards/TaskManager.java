package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages Tasks
 * @author Nylah
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException();
        }
        tasks.put(task.getTaskId(), task);
    }

    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks.values()) {
            if (t.getStatus().equals(status)) {
                result.add(t);
            }
        }
        return result;
    }
}
