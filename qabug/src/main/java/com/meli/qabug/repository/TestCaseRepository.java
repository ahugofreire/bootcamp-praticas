package com.meli.qabug.repository;

import com.meli.qabug.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> { }
