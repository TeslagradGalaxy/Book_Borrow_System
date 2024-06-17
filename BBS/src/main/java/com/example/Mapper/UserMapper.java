package com.example.Mapper;

import com.example.Pojo.Book;
import com.example.Pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username, password) values (#{username}, #{password})")
    public void insertUser(User user);
    @Delete("delete from user where id=#{id}")
    public void deleteUser(Integer id);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User selectUser(User user);

    @Select("SELECT NAME,borrow_date,return_date FROM borrow_book,book WHERE borrow_book.book_id = book.id AND `borrow_book`.user_id=#{id}")
    public List<Book> showBorrowedBookHistory(Integer id);

    @Select("SELECT name,price FROM book WHERE id IN(SELECT id FROM borrow_book WHERE user_id=#{id}) ORDER BY price DESC")
    public List<Book> showBorrowedBookById(Integer id);

}
