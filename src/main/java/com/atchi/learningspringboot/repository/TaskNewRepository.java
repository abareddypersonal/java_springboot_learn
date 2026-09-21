package com.atchi.learningspringboot.repository;

import com.atchi.learningspringboot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskNewRepository extends JpaRepository<Task,Long> {

}
