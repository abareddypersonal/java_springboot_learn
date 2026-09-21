package com.atchi.learningspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskRequestDto {

    @NotBlank(message = "Title is Required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    private Boolean completed;

    @NotNull(message = "User Id is Required")
    private Long userId;


}
