package com.example.Service.Impl;

import com.example.Mapper.BookMapper;
import com.example.Mapper.BorrowBookMapper;
import com.example.Mapper.UserMapper;
import com.example.Pojo.Book;
import com.example.Pojo.BorrowBook;
import com.example.Pojo.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BorrowBookMapper borrowBookMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        BorrowBook borrowBook=new BorrowBook();
        borrowBook.setUserId(userId);
        LocalDate defaultDate = LocalDate.of(  1000, 1, 1);
        Date date=java.sql.Date.valueOf(defaultDate);
        borrowBook.setReturnDate(date);
        //List<Integer> bookIdList=borrowBookMapper.selectByCondition1(borrowBook);
        //bookIdList.forEach(oneBorrow->bookMapper.returnBook(oneBorrow));
        borrowBookMapper.deleteByUserId(userId);
        userMapper.deleteUser(userId);
        //bookIdList.forEach(bookId->bookMapper.returnBook(bookId));

    }

    @Override
    public User login(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public List<Book> showBorrowedBookHistory(Integer id) {
        return userMapper.showBorrowedBookHistory(id);
    }
    @Override
    public List<Book> showBorrowedBookById(Integer id){
        return userMapper.showBorrowedBookById(id);
    }
}
