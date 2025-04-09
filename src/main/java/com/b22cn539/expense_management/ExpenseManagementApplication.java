package com.b22cn539.expense_management;

import com.b22cn539.expense_management.Common.BeanCustomer.AppConstant;
import com.b22cn539.expense_management.Entity.RoleEntity;
import com.b22cn539.expense_management.Service.Role.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
@EnableMongoAuditing
public class ExpenseManagementApplication {
    private final IRoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementApplication.class, args);
	}

    @Bean
    protected CommandLineRunner init() {
        return args -> {
            if (!this.roleService.existsByCode(AppConstant.ROLE_USER)) {
                RoleEntity role = new RoleEntity();
                role.setCode(AppConstant.ROLE_USER);
                role.setName(AppConstant.ROLE_USER);
                this.roleService.save(role);
            }
            if (!this.roleService.existsByCode(AppConstant.ROLE_ADMIN)) {
                RoleEntity role = new RoleEntity();
                role.setCode(AppConstant.ROLE_ADMIN);
                role.setName(AppConstant.ROLE_ADMIN);
                this.roleService.save(role);
            }
        };
    }
}
