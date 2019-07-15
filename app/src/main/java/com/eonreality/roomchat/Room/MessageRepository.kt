package com.eonreality.roomchat.Room

import android.app.Application
import com.eonreality.roomchat.Message
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


class MessageRepository(application: Application) : CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var messageDao: MessageDao?

    init {
        val db = MessageDatabase.getDatabase(application)
        messageDao = db?.messageDao()
    }

    fun getMessages() = messageDao?.getMessages()

    fun setMessage(message: Message) {
            launch  { setMessageBG(message) }
    }

    private suspend fun setMessageBG(message: Message){
       withContext(Dispatchers.IO){
           messageDao?.setMessage(message)
       }
    }

}
