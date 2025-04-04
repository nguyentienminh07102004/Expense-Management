package com.b22cn539.expense_management.Mapper.User;

import com.b22cn539.expense_management.DTO.User.UserRegister;
import com.b22cn539.expense_management.DTO.User.UserResponse;
import com.b22cn539.expense_management.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {
    @Mapping(target = "role", ignore = true)
    UserEntity registerToEntity(UserRegister userRegister);
    UserResponse entityToResponse(UserEntity userEntity);
}
