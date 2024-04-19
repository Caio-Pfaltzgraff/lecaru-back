package com.caiopfaltzgraff.lecaru.repository;

import com.caiopfaltzgraff.lecaru.domain.subcategory.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
}
