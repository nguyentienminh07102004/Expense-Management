package com.b22cn539.expense_management.Entity;

import com.b22cn539.expense_management.Common.Enum.UserStatus;
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
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column()
	private String id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column()
	private String fullName;
	@Column()
	private String password;
	@Column()
	private String phone;
    @Column()
    private String avatar;
    @Column()
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "code")
    private RoleEntity role;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @Cascade(value = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<JwtEntity> jwts;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @Cascade(value = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<CategoryEntity> categories;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @Cascade(value = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<TransactionEntity> transactions;
}
