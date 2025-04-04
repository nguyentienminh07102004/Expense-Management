package com.b22cn539.expense_management.Service.User;

import com.b22cn539.expense_management.Common.BeanCustomer.AppConstant;
import com.b22cn539.expense_management.Common.Enum.AppException;
import com.b22cn539.expense_management.Common.Enum.UserStatus;
import com.b22cn539.expense_management.Common.Exception.DataInvalidException;
import com.b22cn539.expense_management.DTO.Role.RoleResponse;
import com.b22cn539.expense_management.DTO.User.UserRegister;
import com.b22cn539.expense_management.DTO.User.UserResponse;
import com.b22cn539.expense_management.Entity.RoleEntity;
import com.b22cn539.expense_management.Entity.UserEntity;
import com.b22cn539.expense_management.Mapper.Role.IRoleMapper;
import com.b22cn539.expense_management.Mapper.User.IUserMapper;
import com.b22cn539.expense_management.Repository.IUserRepository;
import com.b22cn539.expense_management.Service.Jwt.IJwtService;
import com.b22cn539.expense_management.Service.Role.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IJwtService jwtService;
    private final IUserMapper userMapper;
    private final IRoleMapper roleMapper;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;

    @Override
    @Transactional
    public UserResponse register(UserRegister userRegister) {
        boolean isEmailExist = this.existsByEmail(userRegister.getEmail());
        if (isEmailExist) {
            throw new DataInvalidException(AppException.EMAIL_ALREADY_EXISTS);
        }
        if (!userRegister.getPassword().equals(userRegister.getConfirmPassword())) {
            throw new DataInvalidException(AppException.PASSWORD_CONFIRM_PASSWORD_NOT_MATCH);
        }
        UserEntity user = this.userMapper.registerToEntity(userRegister);
        if (StringUtils.hasText(userRegister.getRole())) {
            RoleEntity role = roleService.findByCode(userRegister.getRole());
            user.setRole(role);
        } else {
            user.setRole(this.roleService.findByCode(AppConstant.ROLE_USER));
        }
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setStatus(UserStatus.ACTIVE);
        this.userRepository.save(user);
        return this.entityToResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new DataInvalidException(AppException.USER_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public UserResponse entityToResponse(UserEntity userEntity) {
        UserResponse userResponse = this.userMapper.entityToResponse(userEntity);
        RoleResponse roleResponse = this.roleMapper.entityToResponse(userEntity.getRole());
        userResponse.setRole(roleResponse);
        return userResponse;
    }
}
