package app.interiors.aura;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
  private final List<TaskRequest> tasks = new ArrayList<>();

  public TaskResponse<TaskRequest> createTask(TaskRequest taskRequest) {
    tasks.add(taskRequest);
    return new TaskResponse<>(taskRequest, "Task created successfully!");
  }

  public TaskResponse<List<TaskRequest>> getAllTasks() {
    return new TaskResponse<>(tasks, "All tasks fetched successfully!");
  }

  public TaskResponse<TaskRequest> getTaskByTitle(String title) {
    return tasks.stream()
        .filter(task -> task.getTitle().equalsIgnoreCase(title))
        .findFirst()
        .map(task -> new TaskResponse<>(task, "Task fetched successfully!"))
        .orElse(new TaskResponse<>(null, "Task with this title doesn't exist."));
  }

  public TaskResponse<TaskRequest> deleteTaskByTitle(String title) {
    TaskRequest task =
        tasks.stream().filter(t -> t.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);

    if (task == null) {
      return new TaskResponse<>(null, "Task not found");
    }

    tasks.remove(task);
    return new TaskResponse<>(task, "Task deleted successfully!");
  }

  public TaskResponse<TaskRequest> markTaskAsCompleted(String title) {
    TaskRequest task =
        tasks.stream().filter(t -> t.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);

    if (task == null) {
      return new TaskResponse<>(null, "Task not found");
    }

    task.setCompleted(true);

    return new TaskResponse<>(task, "Task marked as completed");
  }
}
