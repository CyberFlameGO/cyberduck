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
import ch.cyberduck.core.deepbox.io.swagger.client.model.BoxAccessPolicy;
import ch.cyberduck.core.deepbox.io.swagger.client.model.BoxRelation;
import ch.cyberduck.core.deepbox.io.swagger.client.model.CompanyEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * BoxInfo
 */



public class BoxInfo {
  @JsonProperty("company")
  private CompanyEntry company = null;

  @JsonProperty("deepBoxNodeId")
  private String deepBoxNodeId = null;

  @JsonProperty("deepBoxName")
  private String deepBoxName = null;

  @JsonProperty("boxNodeId")
  private String boxNodeId = null;

  @JsonProperty("boxName")
  private String boxName = null;

  @JsonProperty("boxType")
  private String boxType = null;

  @JsonProperty("boxVariant")
  private String boxVariant = null;

  @JsonProperty("roots")
  private Map<String, String> roots = null;

  @JsonProperty("accessGrantedBy")
  private List<CompanyEntry> accessGrantedBy = null;

  @JsonProperty("boxPolicy")
  private BoxAccessPolicy boxPolicy = null;

  @JsonProperty("queueCount")
  private Long queueCount = null;

  @JsonProperty("trashHasContent")
  private Boolean trashHasContent = null;

  @JsonProperty("supportedFeatureTags")
  private List<String> supportedFeatureTags = null;

  @JsonProperty("relations")
  private List<BoxRelation> relations = null;

  public BoxInfo company(CompanyEntry company) {
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @Schema(description = "")
  public CompanyEntry getCompany() {
    return company;
  }

  public void setCompany(CompanyEntry company) {
    this.company = company;
  }

  public BoxInfo deepBoxNodeId(String deepBoxNodeId) {
    this.deepBoxNodeId = deepBoxNodeId;
    return this;
  }

   /**
   * Get deepBoxNodeId
   * @return deepBoxNodeId
  **/
  @Schema(description = "")
  public String getDeepBoxNodeId() {
    return deepBoxNodeId;
  }

  public void setDeepBoxNodeId(String deepBoxNodeId) {
    this.deepBoxNodeId = deepBoxNodeId;
  }

  public BoxInfo deepBoxName(String deepBoxName) {
    this.deepBoxName = deepBoxName;
    return this;
  }

   /**
   * Get deepBoxName
   * @return deepBoxName
  **/
  @Schema(description = "")
  public String getDeepBoxName() {
    return deepBoxName;
  }

  public void setDeepBoxName(String deepBoxName) {
    this.deepBoxName = deepBoxName;
  }

  public BoxInfo boxNodeId(String boxNodeId) {
    this.boxNodeId = boxNodeId;
    return this;
  }

   /**
   * Get boxNodeId
   * @return boxNodeId
  **/
  @Schema(description = "")
  public String getBoxNodeId() {
    return boxNodeId;
  }

  public void setBoxNodeId(String boxNodeId) {
    this.boxNodeId = boxNodeId;
  }

  public BoxInfo boxName(String boxName) {
    this.boxName = boxName;
    return this;
  }

   /**
   * Get boxName
   * @return boxName
  **/
  @Schema(description = "")
  public String getBoxName() {
    return boxName;
  }

  public void setBoxName(String boxName) {
    this.boxName = boxName;
  }

  public BoxInfo boxType(String boxType) {
    this.boxType = boxType;
    return this;
  }

   /**
   * Get boxType
   * @return boxType
  **/
  @Schema(description = "")
  public String getBoxType() {
    return boxType;
  }

  public void setBoxType(String boxType) {
    this.boxType = boxType;
  }

  public BoxInfo boxVariant(String boxVariant) {
    this.boxVariant = boxVariant;
    return this;
  }

   /**
   * Box Variant. null is simple box.
   * @return boxVariant
  **/
  @Schema(description = "Box Variant. null is simple box.")
  public String getBoxVariant() {
    return boxVariant;
  }

  public void setBoxVariant(String boxVariant) {
    this.boxVariant = boxVariant;
  }

  public BoxInfo roots(Map<String, String> roots) {
    this.roots = roots;
    return this;
  }

  public BoxInfo putRootsItem(String key, String rootsItem) {
    if (this.roots == null) {
      this.roots = new HashMap<>();
    }
    this.roots.put(key, rootsItem);
    return this;
  }

   /**
   * Get roots
   * @return roots
  **/
  @Schema(description = "")
  public Map<String, String> getRoots() {
    return roots;
  }

  public void setRoots(Map<String, String> roots) {
    this.roots = roots;
  }

  public BoxInfo accessGrantedBy(List<CompanyEntry> accessGrantedBy) {
    this.accessGrantedBy = accessGrantedBy;
    return this;
  }

  public BoxInfo addAccessGrantedByItem(CompanyEntry accessGrantedByItem) {
    if (this.accessGrantedBy == null) {
      this.accessGrantedBy = new ArrayList<>();
    }
    this.accessGrantedBy.add(accessGrantedByItem);
    return this;
  }

   /**
   * Get accessGrantedBy
   * @return accessGrantedBy
  **/
  @Schema(description = "")
  public List<CompanyEntry> getAccessGrantedBy() {
    return accessGrantedBy;
  }

  public void setAccessGrantedBy(List<CompanyEntry> accessGrantedBy) {
    this.accessGrantedBy = accessGrantedBy;
  }

  public BoxInfo boxPolicy(BoxAccessPolicy boxPolicy) {
    this.boxPolicy = boxPolicy;
    return this;
  }

   /**
   * Get boxPolicy
   * @return boxPolicy
  **/
  @Schema(description = "")
  public BoxAccessPolicy getBoxPolicy() {
    return boxPolicy;
  }

  public void setBoxPolicy(BoxAccessPolicy boxPolicy) {
    this.boxPolicy = boxPolicy;
  }

  public BoxInfo queueCount(Long queueCount) {
    this.queueCount = queueCount;
    return this;
  }

   /**
   * Get queueCount
   * @return queueCount
  **/
  @Schema(description = "")
  public Long getQueueCount() {
    return queueCount;
  }

  public void setQueueCount(Long queueCount) {
    this.queueCount = queueCount;
  }

  public BoxInfo trashHasContent(Boolean trashHasContent) {
    this.trashHasContent = trashHasContent;
    return this;
  }

   /**
   * Get trashHasContent
   * @return trashHasContent
  **/
  @Schema(description = "")
  public Boolean isTrashHasContent() {
    return trashHasContent;
  }

  public void setTrashHasContent(Boolean trashHasContent) {
    this.trashHasContent = trashHasContent;
  }

  public BoxInfo supportedFeatureTags(List<String> supportedFeatureTags) {
    this.supportedFeatureTags = supportedFeatureTags;
    return this;
  }

  public BoxInfo addSupportedFeatureTagsItem(String supportedFeatureTagsItem) {
    if (this.supportedFeatureTags == null) {
      this.supportedFeatureTags = new ArrayList<>();
    }
    this.supportedFeatureTags.add(supportedFeatureTagsItem);
    return this;
  }

   /**
   * Get supportedFeatureTags
   * @return supportedFeatureTags
  **/
  @Schema(description = "")
  public List<String> getSupportedFeatureTags() {
    return supportedFeatureTags;
  }

  public void setSupportedFeatureTags(List<String> supportedFeatureTags) {
    this.supportedFeatureTags = supportedFeatureTags;
  }

  public BoxInfo relations(List<BoxRelation> relations) {
    this.relations = relations;
    return this;
  }

  public BoxInfo addRelationsItem(BoxRelation relationsItem) {
    if (this.relations == null) {
      this.relations = new ArrayList<>();
    }
    this.relations.add(relationsItem);
    return this;
  }

   /**
   * Get relations
   * @return relations
  **/
  @Schema(description = "")
  public List<BoxRelation> getRelations() {
    return relations;
  }

  public void setRelations(List<BoxRelation> relations) {
    this.relations = relations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BoxInfo boxInfo = (BoxInfo) o;
    return Objects.equals(this.company, boxInfo.company) &&
        Objects.equals(this.deepBoxNodeId, boxInfo.deepBoxNodeId) &&
        Objects.equals(this.deepBoxName, boxInfo.deepBoxName) &&
        Objects.equals(this.boxNodeId, boxInfo.boxNodeId) &&
        Objects.equals(this.boxName, boxInfo.boxName) &&
        Objects.equals(this.boxType, boxInfo.boxType) &&
        Objects.equals(this.boxVariant, boxInfo.boxVariant) &&
        Objects.equals(this.roots, boxInfo.roots) &&
        Objects.equals(this.accessGrantedBy, boxInfo.accessGrantedBy) &&
        Objects.equals(this.boxPolicy, boxInfo.boxPolicy) &&
        Objects.equals(this.queueCount, boxInfo.queueCount) &&
        Objects.equals(this.trashHasContent, boxInfo.trashHasContent) &&
        Objects.equals(this.supportedFeatureTags, boxInfo.supportedFeatureTags) &&
        Objects.equals(this.relations, boxInfo.relations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, deepBoxNodeId, deepBoxName, boxNodeId, boxName, boxType, boxVariant, roots, accessGrantedBy, boxPolicy, queueCount, trashHasContent, supportedFeatureTags, relations);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BoxInfo {\n");
    
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    deepBoxNodeId: ").append(toIndentedString(deepBoxNodeId)).append("\n");
    sb.append("    deepBoxName: ").append(toIndentedString(deepBoxName)).append("\n");
    sb.append("    boxNodeId: ").append(toIndentedString(boxNodeId)).append("\n");
    sb.append("    boxName: ").append(toIndentedString(boxName)).append("\n");
    sb.append("    boxType: ").append(toIndentedString(boxType)).append("\n");
    sb.append("    boxVariant: ").append(toIndentedString(boxVariant)).append("\n");
    sb.append("    roots: ").append(toIndentedString(roots)).append("\n");
    sb.append("    accessGrantedBy: ").append(toIndentedString(accessGrantedBy)).append("\n");
    sb.append("    boxPolicy: ").append(toIndentedString(boxPolicy)).append("\n");
    sb.append("    queueCount: ").append(toIndentedString(queueCount)).append("\n");
    sb.append("    trashHasContent: ").append(toIndentedString(trashHasContent)).append("\n");
    sb.append("    supportedFeatureTags: ").append(toIndentedString(supportedFeatureTags)).append("\n");
    sb.append("    relations: ").append(toIndentedString(relations)).append("\n");
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
