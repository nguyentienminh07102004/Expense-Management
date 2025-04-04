package com.b22cn539.expense_management.Service.Role;

import com.b22cn539.expense_management.Common.Enum.AppException;
import com.b22cn539.expense_management.Common.Exception.DataInvalidException;
import com.b22cn539.expense_management.Entity.RoleEntity;
import com.b22cn539.expense_management.Repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public RoleEntity findByCode(String code) {
        return this.roleRepository.findByCode(code)
                .orElseThrow(() -> new DataInvalidException(AppException.ROLE_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByCode(String code) {
        return this.roleRepository.existsByCode(code);
    }

    @Override
    @Transactional
    public RoleEntity save(RoleEntity role) {
        return this.roleRepository.save(role);
    }
}
