/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.dto;

import com.cn.app.chatgptbot.model.Gpt003Model;
import com.cn.app.chatgptbot.model.GptAlphaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * The type Gpt 003 dto.
 */
@Data
public class GptAlphaDto {

    @NotBlank(message = "消息数据不能为空")
    private String prompt;

    @NotBlank(message = "图片大小不能为空")
    private String size;

    @NotNull(message = "生成图片数量不能为空")
    private Integer num_images;

    @NotBlank(message = "OpenKey不能为空")
    private String openKey;


    public static GptAlphaModel convertToGptAlphaModel(GptAlphaDto item) {
        if (item == null) {
            return null;
        }
        GptAlphaModel result = new GptAlphaModel();
        result.setModel("image-alpha-001");
        result.setPrompt(item.getPrompt());
        result.setSize(item.getSize());
        result.setNum_images(item.getNum_images());
        result.setResponse_format("url");
        return result;
    }
}
