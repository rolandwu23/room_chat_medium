package com.eonreality.roomchat

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "message_table")
data class Message(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int,

    @ColumnInfo(name = "message")
    var message:String

)