package com.b22cn539.expense_management.DTO.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegister {
    @Email(message = "EMAIL_INVALID")
    private String email;
    @Size(min = 8, message = "PASSWORD_LENGTH_NOT_CORRECT")
    private String password;
    @NotBlank(message = "FULL_NAME_NOT_NULL")
    private String fullName;
    private String phone;
    @Size(min = 8, message = "PASSWORD_LENGTH_NOT_CORRECT")
    private String confirmPassword;
    private String role;
}
