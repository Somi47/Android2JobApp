package com.example.android2jobapp.client.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Application   {
  
  @SerializedName("email")
  private String email = null;
  
  @SerializedName("id")
  private String id = null;
  
  @SerializedName("jobid")
  private String jobid = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
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
  public String getJobid() {
    return jobid;
  }
  public void setJobid(String jobid) {
    this.jobid = jobid;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Application application = (Application) o;
    return Objects.equals(email, application.email) &&
        Objects.equals(id, application.id) &&
        Objects.equals(jobid, application.jobid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, id, jobid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Application {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    jobid: ").append(toIndentedString(jobid)).append("\n");
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
