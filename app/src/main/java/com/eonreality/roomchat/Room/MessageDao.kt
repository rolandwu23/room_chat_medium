package com.eonreality.roomchat.Room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.eonreality.roomchat.Message


@Dao
interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMessage(movie: Message)

    @Query("SELECT * from message_table ORDER BY id ASC")
    fun getMessages() : LiveData<List<Message>>

    @Query("DELETE FROM message_table")
    fun deleteAll()

}