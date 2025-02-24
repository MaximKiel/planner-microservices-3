package ru.javabegin.micro.planner.users.mq;

import lombok.Getter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
@Getter
public class MessageFuncAction {

    private MessageFunc messageFunc;

    public MessageFuncAction(MessageFunc messageFunc) {
        this.messageFunc = messageFunc;
    }

    public void sendNewUserMessage(Long id) {
        messageFunc.getInnerBus().emitNext(MessageBuilder.withPayload(id).build(), Sinks.EmitFailureHandler.FAIL_FAST);
        System.out.println("<Message sent>: " + id);
    }
}
