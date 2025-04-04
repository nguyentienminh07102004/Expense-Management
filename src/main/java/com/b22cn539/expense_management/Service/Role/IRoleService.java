package com.b22cn539.expense_management.Service.Role;

import com.b22cn539.expense_management.Entity.RoleEntity;

public interface IRoleService {
    RoleEntity findByCode(String code);
    boolean existsByCode(String code);
    RoleEntity save(RoleEntity role);
}
