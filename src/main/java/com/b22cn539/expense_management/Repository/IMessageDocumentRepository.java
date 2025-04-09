package com.b22cn539.expense_management.Repository;

import com.b22cn539.expense_management.Document.MessageDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageDocumentRepository extends MongoRepository<MessageDocument, String> {
    List<MessageDocument> findBySender_IdAndRecipient_Id(String senderId, String recipientId, Pageable pageable);
}
