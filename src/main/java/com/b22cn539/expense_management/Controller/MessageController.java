package com.b22cn539.expense_management.Controller;

import com.b22cn539.expense_management.DTO.MessageDocument.MessageRequest;
import com.b22cn539.expense_management.Document.MessageDocument;
import com.b22cn539.expense_management.Service.MessageDocument.IMessageDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/messages")
public class MessageController {
    private final IMessageDocumentService messageDocumentService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping(value = "/send-message")
    public void sendMessage(@Payload MessageRequest messageRequest, Principal principal) {
        MessageDocument messageDocument = this.messageDocumentService.saveMessageDocument(messageRequest, principal);
        this.messagingTemplate.convertAndSendToUser(messageRequest.getReceiver(), "/queue/receive-message", messageDocument);
    }

    @GetMapping(value = "/{sender}/{receiver}")
    public List<MessageDocument> findAllMessageBySenderAndReceiver(@PathVariable String sender, @PathVariable String receiver,
                                                                   @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        List<MessageDocument> messageDocuments = this.messageDocumentService.findAllMessageBySenderAndReceiver(sender, receiver, page, limit);
        return messageDocuments;
    }
}
