package com.cn.app.chatgptbot.msg;



import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 结果
 *
 * @author 时间海
 * @date 2022/11/24
 */
@SuppressWarnings("all")
public class Result extends LinkedHashMap<String, Object> implements Serializable {

    /** 串行版本uid */
    private static final long serialVersionUID = 1L;
    /** 代码成功 */
    public static final int CODE_SUCCESS = 20000;
    /** 代码错误 */
    public static final int CODE_ERROR = 50000;

    /**
     * 结果
     */
    public Result() {
    }

    public Result(int code, String msg, Object data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    /**
     * 结果
     *
     * @param map 地图
     */
    public Result(Map<String, ?> map) {
        this.setMap(map);
    }

    /**
     * 获取代码
     *
     * @return {@link Integer}
     */
    public Integer getCode() {
        return (Integer)this.get("code");
    }

    /**
     * 得到
     *
     * @return {@link String}
     */
    public String getMsg() {
        return (String)this.get("msg");
    }

    /**
     * 获取数据
     *
     * @return {@link Object}
     */
    public Object getData() {
        return this.get("data");
    }

    /**
     * 设置代码
     *
     * @param code 代码
     * @return {@link Result}
     */
    public Result setCode(int code) {
        this.put("code", code);
        return this;
    }

    /**
     * 设置
     *
     * @param msg 味精
     * @return {@link Result}
     */
    public Result setMsg(String msg) {
        this.put("msg", msg);
        return this;
    }

    /**
     * 集数据
     *
     * @param data 数据
     * @return {@link Result}
     */
    public Result setData(Object data) {
        this.put("data", data);
        return this;
    }

    /**
     * 集
     *
     * @param key  关键
     * @param data 数据
     * @return {@link Result}
     */
    public Result set(String key, Object data) {
        this.put(key, data);
        return this;
    }


    /**
     * 设置Map
     *
     * @param map 地图
     * @return {@link Result}
     */
    public Result setMap(Map<String, ?> map) {
        Iterator var2 = map.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            this.put(key, map.get(key));
        }

        return this;
    }

    /**
     *
     *
     * @return {@link Result}
     */
    public static Result ok() {
        return new Result(20000, "操作成功", (Object)null);
    }

    /**
     *
     *
     * @param msg 味精
     * @return {@link Result}
     */
    public static Result ok(String msg) {
        return new Result(20000, msg, (Object)null);
    }

    /**
     *
     *
     * @param code 代码
     * @return {@link Result}
     */
    public static Result code(int code) {
        return new Result(code, (String)null, (Object)null);
    }

    /**
     *
     *
     * @param data 数据
     * @return {@link Result}
     */
    public static Result data(Object data) {
        return new Result(20000, "ok", data);
    }

    /**
     *
     *
     * @return {@link Result}
     */
    public static Result error() {
        return new Result(50000, "error", (Object)null);
    }

    /**
     *
     *
     * @param msg 味精
     * @return {@link Result}
     */
    public static Result error(String msg) {
        return new Result(50000, msg, (Object)null);
    }

    /**
     *
     *
     * @param code 代码
     * @param msg  味精
     * @param data 数据
     * @return {@link Result}
     */
    public static Result build(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    public String toString() {
        return "{\"code\": " + this.getCode() + ", \"msg\": " + this.transValue(this.getMsg()) + ", \"data\": " + this.transValue(this.getData()) + "}";
    }

    /**
     * 反式值
     *
     * @param value 价值
     * @return {@link String}
     */
    private String transValue(Object value) {
        return value instanceof String ? "\"" + value + "\"" : String.valueOf(value);
    }
}
