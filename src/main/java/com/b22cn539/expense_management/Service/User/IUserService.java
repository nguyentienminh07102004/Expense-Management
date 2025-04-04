package com.b22cn539.expense_management.Service.User;

import com.b22cn539.expense_management.DTO.User.UserRegister;
import com.b22cn539.expense_management.DTO.User.UserResponse;
import com.b22cn539.expense_management.Entity.UserEntity;

public interface IUserService {
    UserResponse register(UserRegister userRegister);
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
}
