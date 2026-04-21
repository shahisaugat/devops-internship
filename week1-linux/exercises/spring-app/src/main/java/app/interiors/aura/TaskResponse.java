package app.interiors.aura;

public class TaskResponse<T> {
  private final T response;
  private final String message;

  public TaskResponse(T response, String message) {
    this.response = response;
    this.message = message;
  }

  public T getResponse() {
    return response;
  }

  public String getMessage() {
    return message;
  }
}
