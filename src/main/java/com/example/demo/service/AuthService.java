package com.example.demo.service;

import com.example.demo.model.LoginForm;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService {

    ArrayList<User> users_table = new ArrayList<User>(){};

    public AuthService(){
        User u = new User("test1", "test@gmail.com", "123");
        u.setId(1);
        users_table.add(u);
    }

    public User add_user(User newUser){

        for (int i = 0 ; i < users_table.size() ; i++){ //// unique email constraint
            if(users_table.get(i).getEmail() == newUser.getEmail()){
                return null;
            }
        }

        Integer newId = 1;

        if(users_table.size() > 0){
            User last_exist_user = users_table.get(users_table.size()-1);
            newId = last_exist_user.getId() + 1;
        }

        newUser.setId(newId);

        users_table.add(newUser);
        return  newUser;
    }

    public User get_user(LoginForm loginData){

        User user = null;


        for(int i = 0 ; i < users_table.size() ; i++){
            User it_user = users_table.get(i);

            if(it_user.getEmail().equals(loginData.getEmail()) && it_user.getPassword().equals(loginData.getPassword())){
                user = it_user;
            }
        }

        return  user;
    }

    // get user by name
    public User get_user_by_name(String name){
        User user = null;
        for(int i = 0 ; i < users_table.size() ; i++){
            User it_user = users_table.get(i);
            if(it_user.getName().equals(name)){
                user = it_user;
            }
        }
        return  user;
    }

}
