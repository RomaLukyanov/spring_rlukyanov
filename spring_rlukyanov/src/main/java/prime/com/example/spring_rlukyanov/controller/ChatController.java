package prime.com.example.spring_rlukyanov.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import prime.com.example.spring_rlukyanov.dto.MessageDTO;

@Controller
public class ChatController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public MessageDTO handleMessage(@RequestBody MessageDTO message) {
        return message; // просто пересылаем сообщение всем подписчикам
    }
}
