package com.day6.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {


    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\\\s]{2,}$", message = "Name must contain only alphabets and spaces, First letter capitalized, minimum 3 characters")
    private String name;

    @Positive(message = "Salary must be positive")
    private double salary;

}
