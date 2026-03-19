package com.validation.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CandidateCreateDTO {

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 50, message = "Tên phải từ 5 đến 50 ký tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Ứng viên phải từ 18 tuổi trở lên")
    private Integer age;

    @NotNull(message = "Năm kinh nghiệm không được để trống")
    @Min(value = 0, message = "Năm kinh nghiệm không được là số âm")
    private Integer yearsOfExperience;
}