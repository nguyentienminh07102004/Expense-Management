package com.b22cn539.expense_management.Common.Exception;

import com.b22cn539.expense_management.Common.Enum.AppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class DataInvalidException extends RuntimeException {
    private Integer status;
    private String message;
    private HttpStatus httpStatus;

    public DataInvalidException(AppException exception) {
        this.status = exception.getStatus();
        this.message = exception.getMessage();
        this.httpStatus = exception.getHttpStatus();
    }
}
