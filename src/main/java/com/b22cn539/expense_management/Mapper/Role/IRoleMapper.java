package com.b22cn539.expense_management.Mapper.Role;

import com.b22cn539.expense_management.DTO.Role.RoleResponse;
import com.b22cn539.expense_management.Entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IRoleMapper {
    RoleResponse entityToResponse(RoleEntity role);
}
