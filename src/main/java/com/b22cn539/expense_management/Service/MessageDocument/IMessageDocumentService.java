package com.b22cn539.expense_management.Service.MessageDocument;

import com.b22cn539.expense_management.DTO.MessageDocument.MessageRequest;
import com.b22cn539.expense_management.Document.MessageDocument;

import java.security.Principal;
import java.util.List;

public interface IMessageDocumentService {
    MessageDocument saveMessageDocument(MessageRequest messageRequest, Principal principal);
    List<MessageDocument> findAllMessageBySenderAndReceiver(String sender, String receiver, Integer page, Integer limit);
}
