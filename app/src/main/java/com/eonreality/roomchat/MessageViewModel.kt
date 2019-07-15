package com.eonreality.roomchat

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.eonreality.roomchat.Room.MessageRepository

class MessageViewModel (application: Application) : AndroidViewModel(application) {

    private var repository:MessageRepository = MessageRepository(application)

    fun getMessages() = repository.getMessages()

    fun setMessage(message: Message) { repository.setMessage(message)}

}