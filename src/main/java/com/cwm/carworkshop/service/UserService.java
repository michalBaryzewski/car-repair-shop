package com.cwm.carworkshop.service;

import com.cwm.carworkshop.model.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(User user);
}
