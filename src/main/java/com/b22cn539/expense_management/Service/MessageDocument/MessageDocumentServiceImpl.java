package com.b22cn539.expense_management.Service.MessageDocument;

import com.b22cn539.expense_management.Common.Utils.PageableUtils;
import com.b22cn539.expense_management.DTO.MessageDocument.MessageRequest;
import com.b22cn539.expense_management.Document.MessageDocument;
import com.b22cn539.expense_management.Document.UserDocument;
import com.b22cn539.expense_management.Repository.IMessageDocumentRepository;
import com.b22cn539.expense_management.Service.UserDocument.IUserDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageDocumentServiceImpl implements IMessageDocumentService {
    private final IMessageDocumentRepository messageDocumentRepository;
    private final IUserDocumentService userDocumentService;

    @Override
    @Transactional
    public MessageDocument saveMessageDocument(MessageRequest messageRequest, Principal principal) {
        UserDocument sender = this.userDocumentService.findByEmail(principal.getName());
        UserDocument receiver = this.userDocumentService.findByEmail(messageRequest.getReceiver());
        MessageDocument messageDocument = new MessageDocument();
        messageDocument.setSender(sender);
        messageDocument.setRecipient(receiver);
        messageDocument.setMessage(messageRequest.getMessage());
        return this.messageDocumentRepository.save(messageDocument);
    }

    @Override
    public List<MessageDocument> findAllMessageBySenderAndReceiver(String sender, String receiver, Integer page, Integer limit) {
        UserDocument senderDocument = this.userDocumentService.findByEmail(sender);
        UserDocument receiverDocument = this.userDocumentService.findByEmail(receiver);
        return this.messageDocumentRepository.findBySender_IdAndRecipient_Id(senderDocument.getId(), receiverDocument.getId(), PageableUtils.pagination(page, limit));
    }
}
