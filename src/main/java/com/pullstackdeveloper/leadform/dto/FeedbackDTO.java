package com.pullstackdeveloper.leadform.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class FeedbackDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Rating is mandatory")
    @Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be more than 5")
    private Integer rating;

    @NotBlank(message = "Comments are mandatory")
    private String comments;
}
