package com.example.Controller;

import com.example.Pojo.BorrowBook;
import com.example.Pojo.Result;
import com.example.Service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/Borrows")
public class BorrowBookController {
    @Autowired
    private BorrowBookService borrowBookService;
    @PostMapping("/insertBorrow")
    public Result insertBorrow(@RequestParam("UserId") Integer UserId, @RequestParam("BookId") Integer BookId){
        Date time=new Date();
        BorrowBook borrowBook=new BorrowBook(UserId,BookId,time);
        if(borrowBookService.insertBorrow(borrowBook)){
            return Result.success();
        }
        return Result.error();
    }

    @PutMapping("/{id}")
    public Result insertReturn(@PathVariable Integer id){
        borrowBookService.insertReturn(id);
        return Result.success();
    }
    @GetMapping("/show")
    public Result showAllBorrowedBook(){
        return Result.success(borrowBookService.showAllBorrowedBook());
    }
}
