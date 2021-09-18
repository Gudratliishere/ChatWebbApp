package com.company.chatwebapp.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Dunay Gudratli
 */
@Getter
@Setter
public class MessageModel
{

    private String sender;
    private String message;

    @Override
    public String toString()
    {
        return "MessageModel{" + "sender=" + sender + ", message=" + message + '}';
    }
}
