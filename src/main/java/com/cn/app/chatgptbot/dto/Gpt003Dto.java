/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.dto;

import com.cn.app.chatgptbot.model.Gpt003Model;
import com.cn.app.chatgptbot.model.GptTurboModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * The type Gpt 003 dto.
 */
@Data
public class Gpt003Dto {

    @NotBlank(message = "模型不能为空")
    private String model;

    @NotBlank(message = "消息数据不能为空")
    private String prompt;

    @NotBlank(message = "OpenKey不能为空")
    private String openKey;


    /**
     * Convert to gpt 003 model gpt 003 model.
     *
     * @param item the item
     * @return the gpt 003 model
     */
    public static Gpt003Model convertToGpt003Model(Gpt003Dto item) {
        if (item == null) {
            return null;
        }
        Gpt003Model result = new Gpt003Model();
        result.setModel("text-davinci-003");
        result.setPrompt(item.getPrompt());
        result.setStop("");
        result.setMax_tokens(2048);
        return result;
    }
}
