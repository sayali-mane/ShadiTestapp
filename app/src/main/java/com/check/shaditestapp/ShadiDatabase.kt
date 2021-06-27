package com.check.shaditestapp

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.check.shaditestapp.AppConstant.DB_VERSION

@Database(entities = [ProfileShadi::class],
    version = DB_VERSION, exportSchema = false)
@TypeConverters(IdTypeConverter::class,NameTypeConverter::class,RegisteredTypeConverter::class,PictureTypeConverter::class,DobTypeConverter::class)
abstract class ShadiDatabase : RoomDatabase() {

    abstract fun getShadiData() : ShadiStatusDao
}