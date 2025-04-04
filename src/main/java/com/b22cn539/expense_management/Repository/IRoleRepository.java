package com.b22cn539.expense_management.Repository;

import com.b22cn539.expense_management.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, String> {
    Optional<RoleEntity> findByCode(String code);

    boolean existsByCode(String code);
}
