package com.example.android2jobapp.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
class Application {
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("email")
    var email: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: Int? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("jobid")
    var jobid: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val application = o as Application
        return email == application.email &&
                id == application.id &&
                jobid == application.jobid
    }

    override fun hashCode(): Int {
        return Objects.hash(email, id, jobid)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Application {\n")
        sb.append("    email: ").append(toIndentedString(email)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    jobid: ").append(toIndentedString(jobid)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }
}