package com.example.Controller;


import com.example.Pojo.Book;
import com.example.Pojo.PageBean;
import com.example.Pojo.Result;
import com.example.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public Result findAllBooks(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean pageBean=bookService.findAllBooks(page,pageSize);
        return Result.success(pageBean);

    }
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        return Result.success(bookService.findById(id));
    }

    @DeleteMapping("/deleteBook/{id}")
    public Result deleteBook(@PathVariable Integer id){
         bookService.deleteBook(id);
         return Result.success();
    }
    @PostMapping("/insertBook")
    public Result insertBook(@RequestBody Book book){
        bookService.insertBook(book);
        return Result.success();
    }
    @PutMapping
    public Result updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return Result.success();
    }
    @GetMapping("/sum")
    public Result getSum(){
        return Result.success(bookService.getSum());
    }
}
