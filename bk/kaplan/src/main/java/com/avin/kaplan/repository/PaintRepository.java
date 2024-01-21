package com.avin.kaplan.repository;

import com.avin.kaplan.model.Paint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintRepository extends JpaRepository<Paint, Long> {
}
