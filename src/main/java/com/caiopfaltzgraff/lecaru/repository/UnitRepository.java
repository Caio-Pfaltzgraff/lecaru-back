package com.caiopfaltzgraff.lecaru.repository;

import com.caiopfaltzgraff.lecaru.domain.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, String> {

    @Query(value = """
        SELECT u FROM Unit u
        ORDER BY RANDOM()
        LIMIT 3
    """)
    List<Unit> findRandomUnits();

}
