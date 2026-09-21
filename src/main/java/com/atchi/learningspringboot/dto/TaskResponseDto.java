package com.atchi.learningspringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskResponseDto {
    private  Long id;
    private String title;
    private boolean completed;
    private Long userId;

}
