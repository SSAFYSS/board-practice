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

    @Insert("INSERT INTO todo (userId, content) VALUES (#{userId}, #{content}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(CreateTodoDto cDto);

    @Select("SELECT * FROM todo")
    public List<Todo> searchAll();

    @Update("UPDATE todo SET completed = #{completed}, updatedAt = now() WHERE id = #{id}")
    public int update(UpdateTodoDto uDto);

    @Update("UPDATE todo SET deleted = 1, deletedAt = now() WHERE id = #{id}")
    public int delete(int id);

}
