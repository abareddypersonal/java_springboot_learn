package com.atchi.learningspringboot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
//@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    //    public Task(){
//
//    }
//    public Task(String title, boolean completed) {
//        this.title = title;
//        this.completed = completed;
//
//    }
////
//    public  Long getId(){
//        return id;
//    }
//    public  void setId(Long id){
//        this.id=id;
//    }
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
//
//    public void setCompleted(boolean completed) {
//        this.completed = completed;
//    }
}
