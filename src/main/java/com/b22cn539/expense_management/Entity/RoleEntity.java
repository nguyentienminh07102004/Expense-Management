package com.b22cn539.expense_management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column()
	private String id;
	@Column(unique = true, nullable = false)
	private String code;
	@Column()
	private String name;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;
}
