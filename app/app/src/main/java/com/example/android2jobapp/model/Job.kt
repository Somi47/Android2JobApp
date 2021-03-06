package com.example.android2jobapp.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
class Job {
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("company")
    var company: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("description")
    var description: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("location")
    var location: String? = null

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("title")
    var title: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val job = o as Job
        return company == job.company &&
                description == job.description &&
                id == job.id &&
                location == job.location &&
                title == job.title
    }

    override fun hashCode(): Int {
        return Objects.hash(company, description, id, location, title)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Job {\n")
        sb.append("    company: ").append(toIndentedString(company)).append("\n")
        sb.append("    description: ").append(toIndentedString(description)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    location: ").append(toIndentedString(location)).append("\n")
        sb.append("    title: ").append(toIndentedString(title)).append("\n")
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