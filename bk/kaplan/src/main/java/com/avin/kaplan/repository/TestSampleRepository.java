package com.avin.kaplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSampleRepository extends JpaRepository<com.avin.kaplan.model.TestSample , Long> {


}
