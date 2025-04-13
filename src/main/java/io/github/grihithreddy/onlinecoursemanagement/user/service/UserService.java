package io.github.grihithreddy.onlinecoursemanagement.user.service;

import io.github.grihithreddy.onlinecoursemanagement.user.exception.UserNotFoundException;
import io.github.grihithreddy.onlinecoursemanagement.user.exception.UserValidationException;
import io.github.grihithreddy.onlinecoursemanagement.user.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user) throws UserValidationException;

    List<User> getAllUsers() throws UserNotFoundException;
    User getUserById(int id) throws UserNotFoundException;
    User updateUserName(int user, String newName) throws UserValidationException;
    User updateUserEmail(int id , String newEmail) throws UserValidationException;
    User updateUserPassword(int id , String newPassword) throws UserValidationException;
    User updateUserPhone(int id , String newPhone) throws UserValidationException;
    boolean deleteUser(int id) throws UserNotFoundException;
}
