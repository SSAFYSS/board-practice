package com.ssafyss.board_practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ssafyss.board_practice.domain.*.dao")
@SpringBootApplication
public class BoardPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardPracticeApplication.class, args);
    }

}
