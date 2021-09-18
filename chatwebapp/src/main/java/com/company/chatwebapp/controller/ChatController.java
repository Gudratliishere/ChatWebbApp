package com.company.chatwebapp.controller;

import com.company.chatwebapp.model.MessageModel;
import com.company.chatwebapp.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dunay Gudratli
 */
@RestController
public class ChatController
{

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/{to}")
    public void chatEndpoint(
            @DestinationVariable String to,
            MessageModel messageModel
    )
    {
        System.out.println(messageModel + " to " + to);
        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
        if (isExists)
            messagingTemplate.convertAndSend("/topic/messages/" + to, messageModel);
    }
}
