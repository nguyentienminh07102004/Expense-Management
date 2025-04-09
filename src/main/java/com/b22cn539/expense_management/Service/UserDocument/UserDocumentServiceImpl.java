package com.b22cn539.expense_management.Service.UserDocument;

import com.b22cn539.expense_management.Common.Enum.AppException;
import com.b22cn539.expense_management.Common.Exception.DataInvalidException;
import com.b22cn539.expense_management.Document.UserDocument;
import com.b22cn539.expense_management.Repository.IUserDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDocumentServiceImpl implements IUserDocumentService {
    private final IUserDocumentRepository userDocumentRepository;

    @Override
    @Transactional
    public UserDocument findByEmail(String email) {
        return this.userDocumentRepository.findByEmail(email)
                .orElseThrow(() -> new DataInvalidException(AppException.USER_NOT_FOUND));
    }
}
