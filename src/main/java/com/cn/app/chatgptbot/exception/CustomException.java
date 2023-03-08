package com.cn.app.chatgptbot.exception;


/**
 * The type Custom exception.
 */
@SuppressWarnings("all")
public class CustomException extends RuntimeException {

    private String message;



    /**
     * 自定义异常
     *
     * @param message 消息
     */
    public CustomException(final String message) {
        super(message);
        this.message = message;

    }
}
