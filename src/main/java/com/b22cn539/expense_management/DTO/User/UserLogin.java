package com.b22cn539.expense_management.DTO.User;

import jakarta.validation.constraints.Email;
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
public class UserLogin {
    @Email(message = "EMAIL_INVALID")
    private String email;
    @Size(min = 8, message = "PASSWORD_LENGTH_NOT_CORRECT")
    private String password;
}
