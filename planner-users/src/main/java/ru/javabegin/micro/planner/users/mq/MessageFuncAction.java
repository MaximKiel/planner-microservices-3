package ru.javabegin.micro.planner.users.mq;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class MessageFuncAction {

    private MessageFunc messageFunc;

    public MessageFuncAction(MessageFunc messageFunc) {
        this.messageFunc = messageFunc;
    }

    public void sendNewUserMessage(Long id) {
//        messageFunc.getInnerBus().emitNext(MessageBuilder.withPayload(id).build(), Sinks.EmitFailureHandler.FAIL_FAST);
        System.out.println("<Message sent>: " + id);
    }
}
