package com.meli.qabug.service;

import com.meli.qabug.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public TestCase create(TestCase testCase);
    public List<TestCase> find();
    public TestCase findOne(Long id);
    public TestCase update(Long id, TestCase testCase);
    public void delete(Long id);
    public  List<TestCase> listByDate(LocalDate date);
}
