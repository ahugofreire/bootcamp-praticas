package com.meli.qabug.service;

import com.meli.qabug.model.TestCase;
import com.meli.qabug.repository.TestCaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    private final TestCaseRepository testCaseRepository;

    @Override
    public TestCase create(TestCase testCase) {
        return this.testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCase> find() {
        return this.testCaseRepository.findAll();
    }

    @Override
    public TestCase findOne(Long id) {

        return this.testCaseRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public TestCase update(Long id, TestCase testCase) {
        Optional<TestCase> opTestCase = this.testCaseRepository.findById(id);
        if (opTestCase.isEmpty()) {
            throw new RuntimeException();
        }

        testCase.setId_case(opTestCase.get().getId_case());
        this.testCaseRepository.save(testCase);

        return testCase;
    }

    @Override
    public void delete(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        testCase.ifPresent(value -> this.testCaseRepository.deleteById(value.getId_case()));
    }

    @Override
    public List<TestCase> listByDate(LocalDate date) {

        return this.testCaseRepository.findAll().stream().filter(v -> v.getLast_update().isAfter(date)).collect(Collectors.toList());
    }
}
