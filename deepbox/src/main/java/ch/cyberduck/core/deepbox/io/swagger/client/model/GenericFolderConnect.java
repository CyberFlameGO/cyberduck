/*
 * DeepBox
 * DeepBox API Documentation
 *
 * OpenAPI spec version: 1.0
 * Contact: info@deepcloud.swiss
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.deepbox.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.deepbox.io.swagger.client.model.GenericFolderAddItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * GenericFolderConnect
 */



public class GenericFolderConnect {
  @JsonProperty("folders")
  private List<GenericFolderAddItem> folders = new ArrayList<>();

  public GenericFolderConnect folders(List<GenericFolderAddItem> folders) {
    this.folders = folders;
    return this;
  }

  public GenericFolderConnect addFoldersItem(GenericFolderAddItem foldersItem) {
    this.folders.add(foldersItem);
    return this;
  }

   /**
   * Get folders
   * @return folders
  **/
  @Schema(required = true, description = "")
  public List<GenericFolderAddItem> getFolders() {
    return folders;
  }

  public void setFolders(List<GenericFolderAddItem> folders) {
    this.folders = folders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericFolderConnect genericFolderConnect = (GenericFolderConnect) o;
    return Objects.equals(this.folders, genericFolderConnect.folders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(folders);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericFolderConnect {\n");
    
    sb.append("    folders: ").append(toIndentedString(folders)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
