package com.shinepond.composetutorial.common.db.user

import androidx.room.*


@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM User WHERE phone= :phone")
    fun getUserByPhone(phone: String)

    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("DELETE FROM User WHERE name = :name")
    fun deleteUserByName(name: String)
}