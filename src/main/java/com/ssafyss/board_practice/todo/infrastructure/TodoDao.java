package com.ssafyss.board_practice.todo.infrastructure;

import com.ssafyss.board_practice.todo.application.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.UpdateTodoDto;
import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TodoDao {

    @Insert("INSERT INTO todo (userid, content) VALUES (#{userid}, #{content}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Todo insert(CreateTodoDto cDto);

    @Select("SELECT * FROM todo")
    public List<Todo> searchAll();


}
