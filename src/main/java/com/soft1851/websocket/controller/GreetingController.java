package com.soft1851.websocket.controller;

import com.soft1851.websocket.bean.Chat;
import com.soft1851.websocket.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author 12559
 */
@Controller
public class GreetingController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(Message message) {
        simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }
}