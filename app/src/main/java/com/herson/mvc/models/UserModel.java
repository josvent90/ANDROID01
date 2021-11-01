package com.herson.mvc.models;

import com.herson.mvc.interfaces.User;

import java.util.ArrayList;

public class UserModel {
    private ArrayList<User> users = new ArrayList<>();
    private User currentUser;

    public UserModel(ArrayList<User> users) {
        this.users = users;
    }

    public boolean resolveCredential(String email, String password, User user) {
        return user.getEmail().equals(email) && user.getPassword().equals(password);
    }

    public boolean authLogin(String email, String password, ArrayList<User> users) {
        boolean flag = false;

        for (int index = 0; index < users.size(); index++) {
            User user = users.get(index);
            flag = resolveCredential(email, password, user);
            if (flag) {
                currentUser = user;
                break;
            }
        }

        return flag;
    }

    public boolean doLogin(String email, String password) {
        return authLogin(email, password, users);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUserById(int userId) {
        User user = null;
        for (int index = 0; index < users.size(); index++) {
            User userByIndex = users.get(index);
            if (userByIndex.getId() == userId) {
                user = userByIndex;
                break;
            }
        }

        return user;
    }
}
