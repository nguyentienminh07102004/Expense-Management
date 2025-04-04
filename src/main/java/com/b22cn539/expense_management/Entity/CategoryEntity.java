package com.b22cn539.expense_management.Entity;

import com.b22cn539.expense_management.Common.Enum.CategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private String id;
    @Column()
    private String name;
    @Column(unique = true, nullable = false)
    private String code;
    @Column()
    @Enumerated(value = EnumType.STRING)
    private CategoryType type;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private UserEntity user;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    @Cascade(value = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<TransactionEntity> transactions;
}
