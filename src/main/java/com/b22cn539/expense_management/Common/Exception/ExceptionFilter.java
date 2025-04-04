package com.b22cn539.expense_management.Common.Exception;

import com.b22cn539.expense_management.Common.Enum.AppException;
import com.b22cn539.expense_management.DTO.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ExceptionFilter {
    @ExceptionHandler(value = DataInvalidException.class)
    public ResponseEntity<APIResponse<?>> handleDataInvalidException(DataInvalidException exception) {
        APIResponse<?> response = APIResponse.builder()
                .message(exception.getMessage())
                .status(exception.getStatus())
                .build();
        return ResponseEntity.status(exception.getStatus()).body(response);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<?>> handle(MethodArgumentNotValidException exception) {
        String error = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
        AppException appException = AppException.valueOf(error);
        APIResponse<?> response = APIResponse.builder()
                .message(appException.getMessage())
                .status(appException.getStatus())
                .build();
        return ResponseEntity.status(appException.getStatus()).body(response);
    }
}
