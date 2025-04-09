package com.b22cn539.expense_management.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document(collection = "Messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDocument {
    @MongoId(targetType = FieldType.STRING)
    public String id;
    @Field(targetType = FieldType.STRING)
    private String message;
    @Field(targetType = FieldType.DATE_TIME)
    @CreatedDate
    private Date sendDate;
    @DBRef()
    private UserDocument sender;
    @DBRef()
    private UserDocument recipient;
}
