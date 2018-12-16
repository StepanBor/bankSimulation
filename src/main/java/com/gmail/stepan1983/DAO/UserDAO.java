package com.gmail.stepan1983.DAO;

import com.gmail.stepan1983.model.User;

public interface UserDAO {

    User addUser(User userToAdd);

    void deleteUser(Long id);





}
