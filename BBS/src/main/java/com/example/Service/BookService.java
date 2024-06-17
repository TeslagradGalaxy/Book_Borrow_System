package com.example.Service;

import com.example.Pojo.Book;
import com.example.Pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {
    public PageBean findAllBooks(Integer page,Integer pageSize);
    public Book findById(Integer id);
    public void deleteBook(Integer id);
    public void insertBook(Book book);
    public void updateBook(Book book);
    public double getSum();
}
