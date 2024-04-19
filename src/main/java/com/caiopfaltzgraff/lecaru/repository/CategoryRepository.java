package com.caiopfaltzgraff.lecaru.repository;

import com.caiopfaltzgraff.lecaru.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
