package com.example.Service.Impl;

import com.example.Mapper.BookMapper;
import com.example.Mapper.BorrowBookMapper;
import com.example.Pojo.Book;
import com.example.Pojo.BorrowBook;
import com.example.Service.BorrowBookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BorrowBookMapper borrowBookMapper;
    @Override
    public boolean insertBorrow(BorrowBook borrowBook) {
        Date time=new Date();
        borrowBook.setBorrowDate(time);
        if(bookMapper.checkState(borrowBook.getBookId())){
            return false;
        }
        else {borrowBookMapper.insertBorrow(borrowBook);
            bookMapper.borrowBook(borrowBook.getBookId());/*书被借阅后更改其状态*/
            return true;
        }
    }
    @Override
    public void insertReturn(Integer bookId){
        Date time=new Date();
        borrowBookMapper.insertReturn(bookId,time);
        bookMapper.returnBook(bookId);
    }
    @Override
    public List<Book> showAllBorrowedBook(){
        return borrowBookMapper.showAllBorrowedBook();
    }

}
