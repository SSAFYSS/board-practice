package com.ssafyss.board_practice.todo.infrastructure;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TodoDao {

    @Insert("INSERT INTO todo (content, completed) VALUES (#{content}, #{completed})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Todo todo);

    @Select("SELECT * FROM todo")
    public List<Todo> searchAll();

}
