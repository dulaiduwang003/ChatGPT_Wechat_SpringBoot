/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.api;

import com.alibaba.fastjson.JSONObject;
import com.cn.app.chatgptbot.dto.Gpt003Dto;
import com.cn.app.chatgptbot.dto.GptAlphaDto;
import com.cn.app.chatgptbot.dto.GptTurboDto;
import com.cn.app.chatgptbot.model.Gpt003Model;
import com.cn.app.chatgptbot.model.GptAlphaModel;
import com.cn.app.chatgptbot.model.GptTurboModel;
import com.cn.app.chatgptbot.msg.Result;
import com.cn.app.chatgptbot.uitls.ProxyUtil;
import com.cn.app.chatgptbot.uitls.WebClientUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * The type Gpt api controller.
 */
@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
public class GptApi {

    private final ProxyUtil proxyUtil;


    /**
     * Gpt turbo result.
     *
     * @param dto the dto
     * @return the result
     */
    @PostMapping(value = "/local/gpt", name = "GPT-Turbo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result gptTurbo(@Validated @RequestBody final GptTurboDto dto) {

        final GptTurboModel gptTurboModel = GptTurboDto.convertToGptTurboModel(dto);

        final String build = WebClientUtil.build(proxyUtil.getProxy(), dto.getOpenKey(), "chat/completions", gptTurboModel);

        final JSONObject jsonObject = JSONObject.parseObject(build);

        return Result.data(
                jsonObject
        );
    }


    /**
     * Gets order list.
     *
     * @param dto the dto
     * @return the order list
     */
    @PostMapping(value = "/local/003", name = "GPT-003", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result gpt003(@Validated @RequestBody final Gpt003Dto dto) {

        final Gpt003Model gpt003Model = Gpt003Dto.convertToGpt003Model(dto);

        return Result.data(
                JSONObject.parseObject(WebClientUtil.build(proxyUtil.getProxy(), dto.getOpenKey(), "completions", gpt003Model))
        );

    }

    @PostMapping(value = "/local/alpha", name = "GPT-Alpha", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result gptAlpha(@Validated @RequestBody final GptAlphaDto dto) {

        final GptAlphaModel gptAlphaModel = GptAlphaDto.convertToGptAlphaModel(dto);

        return Result.data(
                JSONObject.parseObject(WebClientUtil.build(proxyUtil.getProxy(), dto.getOpenKey(), "images/generations", gptAlphaModel))
        );

    }



}
