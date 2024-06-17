package com.example.Service;

import com.example.Pojo.Book;
import com.example.Pojo.BorrowBook;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BorrowBookService {
    public boolean insertBorrow(BorrowBook borrowBook);
    public void insertReturn(Integer bookId);

    public List<Book> showAllBorrowedBook();
}
