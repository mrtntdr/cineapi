package com.martint.cinemaapi.repositories;

import com.martint.cinemaapi.domain.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
}
