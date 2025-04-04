package com.b22cn539.expense_management.Service.Jwt;

import com.b22cn539.expense_management.DTO.Jwt.JwtDTO;
import com.b22cn539.expense_management.Entity.UserEntity;
import com.nimbusds.jwt.JWTClaimsSet;

public interface IJwtService {
    JwtDTO generateJwt(UserEntity user);
    JWTClaimsSet verifyJwt(String token);
}
