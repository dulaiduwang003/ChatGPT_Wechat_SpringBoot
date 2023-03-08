/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.dto;

import com.cn.app.chatgptbot.model.GptTurboModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GptTurboDto {

    @NotEmpty(message = "消息数据不能为空")
    private List<GptTurboModel.Message> messages;

    @NotBlank(message = "OpenKey不能为空")
    private String openKey;

    /**
     * Convert to gpt turbo model gpt turbo model.
     *
     * @param item the item
     * @return the gpt turbo model
     */
    public static GptTurboModel convertToGptTurboModel(GptTurboDto item) {
        if (item == null) {
            return null;
        }
        GptTurboModel result = new GptTurboModel();
        result.setModel("gpt-3.5-turbo");
        result.setMax_tokens(2048);
        result.setStop("");
        result.setMessages(item.getMessages());
        return result;
    }


}
