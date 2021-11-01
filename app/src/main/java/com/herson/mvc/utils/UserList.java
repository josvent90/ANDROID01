package com.herson.mvc.utils;

import com.herson.mvc.interfaces.User;

import java.util.ArrayList;

public class UserList {
    public static ArrayList<User> generateUserList() {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User(1, "Herson", "hersontevez@gmail.com", "123"));
        users.add(new User(2, "Daniel", "danielzj12@hotmail.com", "daniel112"));
        users.add(new User(3, "Juanito", "juancomecerial@outlook.com", "juanito"));

        return users;
    }
}
