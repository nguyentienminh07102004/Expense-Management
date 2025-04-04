package com.b22cn539.expense_management.Entity;

import com.b22cn539.expense_management.Common.Enum.FinancialGoalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "financialGoals")
@Getter
@Setter
public class FinancialGoalEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private String id;
    @Column(nullable = false)
    private String title;
    @Column()
    private String note;
    @Column()
    private BigDecimal targetAmount;
    @Column()
    private BigDecimal currentAmount = BigDecimal.ZERO;
    @Column()
    private Date deadline;
    @Column()
    @Enumerated(value = EnumType.STRING)
    private FinancialGoalStatus status;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private UserEntity user;
}
