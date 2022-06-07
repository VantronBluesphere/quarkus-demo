package cloud.bluesphere.resource;

import cloud.bluesphere.dto.UploadMultipartFormData;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Path("/api/v1")
public class FileUploadDownloadResource {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Path("/fileupload")
  public Uni<RestResponse<Void>> form(@MultipartForm UploadMultipartFormData uploadMultipartFormData) {
    // ...
    Log.debugf("note: %s, file name: %s, file size: %d, file path: %s",
        uploadMultipartFormData.getNote(), uploadMultipartFormData.getFile().fileName(),
        uploadMultipartFormData.getFile().size(), uploadMultipartFormData.getFile().uploadedFile().toUri());
    return Uni.createFrom().item(RestResponse.ok());
  }

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @Path("/filedownload")
  public Uni<RestResponse<File>> getFile() {
    File file = new File("/home/wangyongjun/图片/2021-12-22 15-30-40屏幕截图.png");
    String encodedFileName = URLEncoder.encode(file.getName(), StandardCharsets.UTF_8);
    RestResponse<File> response = RestResponse.ResponseBuilder.ok(file)
        .header("content-disposition", "attachment; filename=\"" + encodedFileName + "\"")
        .header("Content-Length", file.length())
        .build();
    return Uni.createFrom().item(response);
  }

}
