package com.ssafyss.board_practice.todo.domain;

import com.ssafyss.board_practice.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "fk_todo_user"), nullable = false)
    private User user;

    @Column(length = 50, nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean completed = false;

    @Column(nullable = false)
    private boolean delete = false;

    public Todo(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }

    public void toggleDelete() {
        this.delete = !this.delete;
    }

}
