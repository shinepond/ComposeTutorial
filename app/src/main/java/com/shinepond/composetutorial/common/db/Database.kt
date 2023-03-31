package com.shinepond.composetutorial.common.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shinepond.composetutorial.common.db.user.User
import com.shinepond.composetutorial.common.db.user.UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if (instance == null) {
                synchronized(UserDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }
}