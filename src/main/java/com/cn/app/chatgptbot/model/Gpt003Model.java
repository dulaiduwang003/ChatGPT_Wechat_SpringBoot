/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * The type Gpt 003 dto.
 */
@Data
public class Gpt003Model {


    private String model;


    private String prompt;


    private Integer max_tokens;

    private String stop;




}
