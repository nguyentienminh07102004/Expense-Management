package com.b22cn539.expense_management.Repository;

import com.b22cn539.expense_management.Entity.JwtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJwtRepository extends JpaRepository<JwtEntity, String> {
}
