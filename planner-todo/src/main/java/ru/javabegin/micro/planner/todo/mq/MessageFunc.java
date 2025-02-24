package ru.javabegin.micro.planner.todo.mq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import ru.javabegin.micro.planner.todo.service.TestDataService;

import java.util.function.Consumer;

@Configuration
public class MessageFunc {

    private TestDataService testDataService;

    public MessageFunc(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    @Bean
    public Consumer<Message<Long>> newUserActionConsumer() {
        return message -> testDataService.initTestData(message.getPayload());
    }
}