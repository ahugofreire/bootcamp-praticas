package com.meli.qabug.controller;

import com.meli.qabug.model.TestCase;
import com.meli.qabug.service.ITestCaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
@AllArgsConstructor
public class TestCaseController {

    @Autowired
    private final ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase, UriComponentsBuilder uriBuilder) {
        TestCase testCaseCreated = testCaseService.create(testCase);

        URI uri = uriBuilder.path("/api/testcases/{id}")
                .buildAndExpand(testCaseCreated.getId_case())
                .toUri();

        return ResponseEntity.created(uri).body(testCaseCreated);
    }

    @GetMapping()
    public ResponseEntity<List<TestCase>> findAll(@RequestParam(required = false) String last_update) {

        if(last_update == null) {
            return ResponseEntity.ok().body(this.testCaseService.find());
        }

        return ResponseEntity.ok().body(this.testCaseService.listByDate(LocalDate.parse(last_update)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.testCaseService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> update(@PathVariable Long id, @RequestBody TestCase testCase ) {
        return ResponseEntity.ok().body(this.testCaseService.update(id,testCase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.testCaseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
