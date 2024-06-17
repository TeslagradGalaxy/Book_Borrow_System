package com.example.Service;

import com.example.Pojo.Book;
import com.example.Pojo.User;

import java.util.List;

public interface UserService {
    public void insertUser(User user);

    public void deleteUser(Integer id);

    public User login(User user);

    public List<Book> showBorrowedBookHistory(Integer id);

    public List<Book> showBorrowedBookById(Integer id);
}
