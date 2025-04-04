package com.b22cn539.expense_management.Common.Exception;

import com.b22cn539.expense_management.DTO.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
