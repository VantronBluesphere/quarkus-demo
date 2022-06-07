package cloud.bluesphere.assist;

import javax.json.JsonObject;

public class ApiErrorResult {

  private final ApiErrorCode code;
  private String description;
  private JsonObject data;

  public ApiErrorResult(ApiErrorCode code) {
    this.code = code;
  }

  public ApiErrorResult(ApiErrorCode code, String description) {
    this.code = code;
    this.description = description;
  }

  public ApiErrorResult(ApiErrorCode code, String description, JsonObject data) {
    this.code = code;
    this.description = description;
    this.data = data;
  }

  public ApiErrorCode getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public JsonObject getData() {
    return data;
  }

}
