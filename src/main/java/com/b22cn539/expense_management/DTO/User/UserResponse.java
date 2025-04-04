package com.b22cn539.expense_management.DTO.User;

import com.b22cn539.expense_management.Common.Enum.UserStatus;
import com.b22cn539.expense_management.DTO.Role.RoleResponse;
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
public class UserResponse {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String avatar;
    private UserStatus status;
    private RoleResponse role;
}
