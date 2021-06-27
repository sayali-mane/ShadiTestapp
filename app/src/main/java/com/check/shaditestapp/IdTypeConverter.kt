package com.check.shaditestapp

import android.text.TextUtils
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IdTypeConverter {

    @TypeConverter
    fun  fromPost(value: Id): String {
        val gson = Gson()
        val type = object : TypeToken<Id>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toPost(value: String): Id {
        if (!TextUtils.isEmpty(value)){
            val gson = Gson()
            val type = object : TypeToken<Id>() {}.type
            return gson.fromJson(value, type)
        }
        return Id()
    }
}

class DobTypeConverter {

    @TypeConverter
    fun  fromPost(value: Dob): String {
        val gson = Gson()
        val type = object : TypeToken<Dob>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toPost(value: String): Dob {
        if (!TextUtils.isEmpty(value)){
            val gson = Gson()
            val type = object : TypeToken<Dob>() {}.type
            return gson.fromJson(value, type)
        }
        return Dob()
    }
}

class PictureTypeConverter {

    @TypeConverter
    fun  fromPost(value: Picture): String {
        val gson = Gson()
        val type = object : TypeToken<Picture>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toPost(value: String): Picture {
        if (!TextUtils.isEmpty(value)){
            val gson = Gson()
            val type = object : TypeToken<Picture>() {}.type
            return gson.fromJson(value, type)
        }
        return Picture()
    }
}

class RegisteredTypeConverter {

    @TypeConverter
    fun  fromPost(value: Registered): String {
        val gson = Gson()
        val type = object : TypeToken<Registered>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toPost(value: String): Registered {
        if (!TextUtils.isEmpty(value)){
            val gson = Gson()
            val type = object : TypeToken<Registered>() {}.type
            return gson.fromJson(value, type)
        }
        return Registered()
    }
}

class NameTypeConverter {

    @TypeConverter
    fun  fromPost(value: Name): String {
        val gson = Gson()
        val type = object : TypeToken<Name>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toPost(value: String): Name {
        if (!TextUtils.isEmpty(value)){
            val gson = Gson()
            val type = object : TypeToken<Name>() {}.type
            return gson.fromJson(value, type)
        }
        return Name()
    }
}