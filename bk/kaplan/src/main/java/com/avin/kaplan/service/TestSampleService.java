package com.avin.kaplan.service;

import com.avin.kaplan.model.TestSample;
import com.avin.kaplan.repository.TestSampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class TestSampleService {
    @Autowired
  private   TestSampleRepository testSampleRepository;
    public TestSample updateTestSample( Long id, TestSample test) {
        TestSample testSample;
        Optional<TestSample> testSampleData = testSampleRepository.findById(id);
        if (testSampleData.isPresent()) {
            testSample = testSampleData.get();
        } else {
            return null; // TODO: 1/18/2024 refactor in code
        }
        if (test.getId()!= null && test.getId() > 0) {
            testSample.setId(test.getId());
        }
        if (test.getName() != null) {
            testSample.setName(test.getName());
        }
        return testSampleRepository.save(testSample);
    }
}
