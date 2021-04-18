package com.example.android2jobapp.client.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Job   {
  
  @SerializedName("company")
  private String company = null;
  
  @SerializedName("description")
  private String description = null;
  
  @SerializedName("id")
  private String id = null;
  
  @SerializedName("location")
  private String location = null;
  
  @SerializedName("title")
  private String title = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Job job = (Job) o;
    return Objects.equals(company, job.company) &&
        Objects.equals(description, job.description) &&
        Objects.equals(id, job.id) &&
        Objects.equals(location, job.location) &&
        Objects.equals(title, job.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, description, id, location, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Job {\n");
    
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
