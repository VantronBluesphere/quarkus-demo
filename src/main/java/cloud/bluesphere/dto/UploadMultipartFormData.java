package cloud.bluesphere.dto;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.ws.rs.core.MediaType;

public class UploadMultipartFormData {

  @RestForm
  @PartType(MediaType.TEXT_PLAIN)
  private String note;

  @RestForm("image")
  private FileUpload file;

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public FileUpload getFile() {
    return file;
  }

  public void setFile(FileUpload file) {
    this.file = file;
  }
}
