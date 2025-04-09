package com.b22cn539.expense_management.Service.UserDocument;

import com.b22cn539.expense_management.Document.UserDocument;

public interface IUserDocumentService {
    UserDocument findByEmail(String email);
}
