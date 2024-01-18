package com.avin.kaplan.controller;

import com.avin.kaplan.model.TestSample;
import com.avin.kaplan.repository.TestSampleRepository;
import com.avin.kaplan.service.TestSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("test")
public class TestSampleController {
    @Autowired
    private TestSampleService testSampleService;
    @Autowired
    private TestSampleRepository testRepository;

    @GetMapping
    public List<TestSample> tests() {
        return testRepository.findAll();
    }

    @PostMapping
    public TestSample save(@RequestBody TestSample test) {
        return testRepository.save(test);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        testRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public TestSample updateTestSample(@PathVariable("id") Long id, @RequestBody TestSample test) {
        return testSampleService.updateTestSample(id, test);
    }


}
