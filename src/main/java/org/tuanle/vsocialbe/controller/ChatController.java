package org.tuanle.vsocialbe.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tuanle.vsocialbe.dto.request.ChatMessageRequest;

@Controller
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.sendMessage") // Maps to "/app/chat.sendMessage"
    public void sendMessage(ChatMessageRequest message) {
        // Send the message to the specific user
        messagingTemplate.convertAndSendToUser(
                message.getReceiver(), // Target user
                "/queue/messages",    // Destination
                message               // Message content
        );
    }
}
