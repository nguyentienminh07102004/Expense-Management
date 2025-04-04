package com.b22cn539.expense_management.Service.Jwt;

import com.b22cn539.expense_management.Common.BeanCustomer.AppConstant;
import com.b22cn539.expense_management.Common.Enum.AppException;
import com.b22cn539.expense_management.Common.Exception.DataInvalidException;
import com.b22cn539.expense_management.DTO.Jwt.JwtDTO;
import com.b22cn539.expense_management.Entity.JwtEntity;
import com.b22cn539.expense_management.Entity.UserEntity;
import com.b22cn539.expense_management.Repository.IJwtRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements IJwtService {
    @Value(value = "${signerKey}")
    private String signerKey;
    private final IJwtRepository jwtRepository;

    @Override
    @Transactional
    public JwtDTO generateJwt(UserEntity user) {
        try {
            JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
            String jwtId = UUID.randomUUID().toString();
            Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
            JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                    .subject(user.getEmail())
                    .expirationTime(expiration)
                    .jwtID(jwtId)
                    .claim(AppConstant.ROLE_CLAIM, user.getRole().getCode())
                    .build();
            JWSObject jwsObject = new JWSObject(header, new Payload(jwtClaimsSet.getClaims()));
            jwsObject.sign(new MACSigner(signerKey.getBytes()));
            JwtEntity jwtEntity = JwtEntity.builder()
                    .id(jwtId)
                    .expires(expiration)
                    .refreshToken(UUID.randomUUID().toString())
                    .refreshExpires(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                    .user(user)
                    .build();
            jwtRepository.save(jwtEntity);
            return JwtDTO.builder()
                    .id(jwtId)
                    .expires(expiration)
                    .refreshExpires(jwtEntity.getRefreshExpires())
                    .refreshToken(jwtEntity.getRefreshToken())
                    .token(jwsObject.serialize())
                    .build();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JWTClaimsSet verifyJwt(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            signedJWT.verify(new MACVerifier(signerKey.getBytes()));
            return signedJWT.getJWTClaimsSet();
        } catch (ParseException | JOSEException e) {
            throw new DataInvalidException(AppException.TOKEN_INVALID);
        }
    }
}
