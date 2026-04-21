package app.interiors.aura;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/api/tasks")
  public TaskResponse<TaskRequest> createTask(@RequestBody TaskRequest taskRequest) {
    return taskService.createTask(taskRequest);
  }

  @GetMapping("/api/tasks")
  public TaskResponse<List<TaskRequest>> getAllTasks() {
    return taskService.getAllTasks();
  }

  @GetMapping("/api/tasks/search")
  public TaskResponse<TaskRequest> getTaskByTitle(@RequestParam String title) {
    return taskService.getTaskByTitle(title);
  }

  @DeleteMapping("/api/tasks")
  public TaskResponse<TaskRequest> deleteTaskByTitle(@RequestParam String title) {
    return taskService.deleteTaskByTitle(title);
  }

  @PutMapping("/api/tasks/complete")
  public TaskResponse<TaskRequest> markTaskAsCompleted(@RequestParam String title) {
    return taskService.markTaskAsCompleted(title);
  }
}
