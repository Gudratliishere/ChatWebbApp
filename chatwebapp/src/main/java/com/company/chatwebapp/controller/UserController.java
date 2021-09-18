package com.company.chatwebapp.controller;

import com.company.chatwebapp.storage.UserStorage;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dunay Gudratli
 */
@RestController
@CrossOrigin
public class UserController
{

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(
            @PathVariable String userName
    )
    {
        System.out.println("handling register user request: " + userName);
        try
        {
            UserStorage.getInstance().addUser(userName);
        } catch (Exception ex)
        {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll()
    {
        return UserStorage.getInstance().getUsers();
    }
}
