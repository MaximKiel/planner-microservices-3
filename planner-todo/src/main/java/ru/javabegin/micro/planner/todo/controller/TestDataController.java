package ru.javabegin.micro.planner.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javabegin.micro.planner.todo.service.*;

@RestController
@RequestMapping("/data")
public class TestDataController {

    private final TestDataService testDataService;

    public TestDataController(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    @PostMapping("/init")
    public ResponseEntity<Boolean> init(@RequestBody String userId) {

        testDataService.initTestData(userId);

        // если пользователя НЕ существует
        return ResponseEntity.ok(true);
    }
}