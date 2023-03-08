/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.model;

import lombok.Data;


/**
 * The type Gpt alpha model.
 */
@Data
public class GptAlphaModel {



    private String model;


    private String prompt;


    private String size;


    private Integer num_images;


    private String response_format;


}
