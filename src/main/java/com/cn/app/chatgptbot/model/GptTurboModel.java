/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.model;

import com.cn.app.chatgptbot.dto.GptTurboDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * The type Gpt turbo model.
 */
@Data
public class GptTurboModel {

    private String model;

    private List<Message> messages;

    private Integer max_tokens;

    private String stop;



    /**
     * The type Message.
     */
    @Data
    public static class Message {
        private String role;

        private String content;
    }

}
