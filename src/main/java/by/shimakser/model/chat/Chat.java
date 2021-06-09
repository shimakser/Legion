package by.shimakser.model.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat {
    private MessageType type;
    private String content;
    private String sender;
}
