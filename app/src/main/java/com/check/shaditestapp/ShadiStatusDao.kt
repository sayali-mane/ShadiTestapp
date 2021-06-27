package com.check.shaditestapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShadiStatusDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfileShadiData(shadiData: ProfileShadi)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfileShadi(profileShadi: ProfileShadi?)

    @Query("SELECT * FROM ProfileShadi WHERE email=:emailId")
    fun getProfileShadiById(emailId: String): ProfileShadi

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllProfile(results: List<ProfileShadi?>?)
}