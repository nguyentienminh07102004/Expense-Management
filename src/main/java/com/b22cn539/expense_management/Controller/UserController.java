package com.b22cn539.expense_management.Controller;

import com.b22cn539.expense_management.DTO.APIResponse;
import com.b22cn539.expense_management.DTO.Jwt.JwtResponse;
import com.b22cn539.expense_management.DTO.User.UserLogin;
import com.b22cn539.expense_management.DTO.User.UserRegister;
import com.b22cn539.expense_management.DTO.User.UserResponse;
import com.b22cn539.expense_management.Service.User.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final IUserService userService;

    @PostMapping(value = "/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<APIResponse<UserResponse>> register(@Valid @RequestBody UserRegister userRegister) {
        UserResponse userResponse = this.userService.register(userRegister);
        APIResponse<UserResponse> response = APIResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("SUCCESS")
                .data(userResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<APIResponse<JwtResponse>> login(@Valid @RequestBody UserLogin userLogin) {
        JwtResponse jwtResponse = this.userService.login(userLogin);
        APIResponse<JwtResponse> response = APIResponse.<JwtResponse>builder()
                .status(HttpStatus.OK.value())
                .message("SUCCESS")
                .data(jwtResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
