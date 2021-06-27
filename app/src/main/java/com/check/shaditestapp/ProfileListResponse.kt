package com.check.shaditestapp


//import androidx.room.Entity
//import androidx.room.TypeConverters
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ProfileListResponse(
    @JsonProperty("info")
    val info: Info? = null,
    @JsonProperty("results")
    val results: List<ProfileShadi?>? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Info(
    @JsonProperty("page")
    val page: Int? = null,
    @JsonProperty("results")
    val results: Int? = null,
    @JsonProperty("seed")
    val seed: String? = null,
    @JsonProperty("version")
    val version: String? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
data class ProfileShadi(
    @JsonProperty("cell")
    val cell: String? = null,
    @JsonProperty("dob")
    @TypeConverters(DobTypeConverter::class)
    val dob: Dob? = null,
    @PrimaryKey
    @JsonProperty("email")
    val email: String,
    @JsonProperty("gender")
    val gender: String? = null,
    @JsonProperty("id")
    @TypeConverters(IdTypeConverter::class)
    val id: Id? = null,


    @JsonProperty("name")
    @TypeConverters(NameTypeConverter::class)
    val name: Name? = null,
    @JsonProperty("nat")
    val nat: String? = null,
    @JsonProperty("phone")
    val phone: String? = null,
    @JsonProperty("picture")
    @TypeConverters(PictureTypeConverter::class)
    val picture: Picture? = null,
    @JsonProperty("registered")
   @TypeConverters(RegisteredTypeConverter::class)
    val registered: Registered? = null,
    @JsonProperty("isAccept")
    var isAccept: Boolean = false,
    @JsonProperty("isDecline")
    var isDecline: Boolean = false

)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Entity
data class Dob(
    @JsonProperty("age")
    val age: Int? = null,
    @JsonProperty("date")
    val date: String? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Parcelize
//@Entity
data class Id(
    @JsonProperty("name")
    val name: String? = null,
    @JsonProperty("value")
    val value: Any? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Entity
data class Location(
    @JsonProperty("city")
    val city: String? = null,
    @JsonProperty("coordinates")
    val coordinates: Coordinates? = null,
    @JsonProperty("country")
    val country: String? = null,
    @JsonProperty("postcode")
    val postcode: Any? = null,
    @JsonProperty("state")
    val state: String? = null,
    @JsonProperty("street")
    val street: Street? = null,
    @JsonProperty("timezone")
    val timezone: Timezone? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Parcelize
//@Entity
data class Coordinates(
    @JsonProperty("latitude")
    val latitude: String? = null,
    @JsonProperty("longitude")
    val longitude: String? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Parcelize
data class Street(
    @JsonProperty("name")
    val name: String? = null,
    @JsonProperty("number")
    val number: Int? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Parcelize
//@Entity
data class Timezone(
    @JsonProperty("description")
    val description: String? = null,
    @JsonProperty("offset")
    val offset: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Entity
data class Login(
    @JsonProperty("md5")
    val md5: String? = null,
    @JsonProperty("password")
    val password: String? = null,
    @JsonProperty("salt")
    val salt: String? = null,
    @JsonProperty("sha1")
    val sha1: String? = null,
    @JsonProperty("sha256")
    val sha256: String? = null,
    @JsonProperty("username")
    val username: String? = null,
    @JsonProperty("uuid")
    val uuid: String? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Entity
data class Name(
    @JsonProperty("first")
    val first: String? = null,
    @JsonProperty("last")
    val last: String? = null,
    @JsonProperty("title")
    val title: String? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Parcelize
//@Entity
data class Picture(
    @JsonProperty("large")
    val large: String? = null,
    @JsonProperty("medium")
    val medium: String? = null,
    @JsonProperty("thumbnail")
    val thumbnail: String? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@Entity
data class Registered(
    @JsonProperty("age")
    val age: Int? = null,
    @JsonProperty("date")
    val date: String? = null
)

