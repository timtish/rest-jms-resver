package ru.timtish.stub.jms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Slf4j
@Component
@RequiredArgsConstructor
public class Listener1 {

    final JmsTemplate jms;

    @JmsListener(destination = "test.input.queue")
    public void onMessage(Message msg) throws JMSException {
        log.info("new message from queue {} {}", msg.getJMSMessageID(), msg.getJMSType());
        jms.send("test.output.queue", s -> s.createTextMessage(msg.getBody(String.class)));
    }

}
