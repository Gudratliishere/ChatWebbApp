package com.company.chatwebapp.storage;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

/**
 *
 * @author Dunay Gudratli
 */
public class UserStorage
{

    private static UserStorage instance;
    @Getter
    private final Set<String> users;

    public UserStorage()
    {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance()
    {
        if (instance == null)
            instance = new UserStorage();

        return instance;
    }

    public void addUser(String userName) throws Exception
    {
        if (users.contains(userName))
            throw new Exception("There is already user with username: " + userName);

        users.add(userName);
    }
}
