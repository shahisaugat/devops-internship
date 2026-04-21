package app.interiors.aura;

public class TaskRequest {
  private String title;
  private String description;
  private boolean completed;

  public TaskRequest() {}

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public boolean getCompleted() {
    return completed;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
