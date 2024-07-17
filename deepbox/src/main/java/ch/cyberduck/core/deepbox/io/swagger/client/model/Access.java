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
import ch.cyberduck.core.deepbox.io.swagger.client.model.AccessPath;
import ch.cyberduck.core.deepbox.io.swagger.client.model.AccessPolicy;
import ch.cyberduck.core.deepbox.io.swagger.client.model.Permission;
import ch.cyberduck.core.deepbox.io.swagger.client.model.TimeUserContext;
import ch.cyberduck.core.deepbox.io.swagger.client.model.UserContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Access
 */



public class Access {
  @JsonProperty("accessId")
  private String accessId = null;

  @JsonProperty("displayName")
  private String displayName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("permission")
  private Permission permission = null;

  @JsonProperty("withUser")
  private UserContext withUser = null;

  @JsonProperty("created")
  private TimeUserContext created = null;

  @JsonProperty("policy")
  private AccessPolicy policy = null;

  @JsonProperty("accessPath")
  private AccessPath accessPath = null;

  public Access accessId(String accessId) {
    this.accessId = accessId;
    return this;
  }

   /**
   * Get accessId
   * @return accessId
  **/
  @Schema(description = "")
  public String getAccessId() {
    return accessId;
  }

  public void setAccessId(String accessId) {
    this.accessId = accessId;
  }

  public Access displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @Schema(description = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Access email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @Schema(description = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Access permission(Permission permission) {
    this.permission = permission;
    return this;
  }

   /**
   * Get permission
   * @return permission
  **/
  @Schema(description = "")
  public Permission getPermission() {
    return permission;
  }

  public void setPermission(Permission permission) {
    this.permission = permission;
  }

  public Access withUser(UserContext withUser) {
    this.withUser = withUser;
    return this;
  }

   /**
   * Get withUser
   * @return withUser
  **/
  @Schema(description = "")
  public UserContext getWithUser() {
    return withUser;
  }

  public void setWithUser(UserContext withUser) {
    this.withUser = withUser;
  }

  public Access created(TimeUserContext created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @Schema(description = "")
  public TimeUserContext getCreated() {
    return created;
  }

  public void setCreated(TimeUserContext created) {
    this.created = created;
  }

  public Access policy(AccessPolicy policy) {
    this.policy = policy;
    return this;
  }

   /**
   * Get policy
   * @return policy
  **/
  @Schema(description = "")
  public AccessPolicy getPolicy() {
    return policy;
  }

  public void setPolicy(AccessPolicy policy) {
    this.policy = policy;
  }

  public Access accessPath(AccessPath accessPath) {
    this.accessPath = accessPath;
    return this;
  }

   /**
   * Get accessPath
   * @return accessPath
  **/
  @Schema(description = "")
  public AccessPath getAccessPath() {
    return accessPath;
  }

  public void setAccessPath(AccessPath accessPath) {
    this.accessPath = accessPath;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Access access = (Access) o;
    return Objects.equals(this.accessId, access.accessId) &&
        Objects.equals(this.displayName, access.displayName) &&
        Objects.equals(this.email, access.email) &&
        Objects.equals(this.permission, access.permission) &&
        Objects.equals(this.withUser, access.withUser) &&
        Objects.equals(this.created, access.created) &&
        Objects.equals(this.policy, access.policy) &&
        Objects.equals(this.accessPath, access.accessPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessId, displayName, email, permission, withUser, created, policy, accessPath);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Access {\n");
    
    sb.append("    accessId: ").append(toIndentedString(accessId)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
    sb.append("    withUser: ").append(toIndentedString(withUser)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    accessPath: ").append(toIndentedString(accessPath)).append("\n");
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
