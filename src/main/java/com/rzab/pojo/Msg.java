package com.rzab.pojo;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    //返回编码：100成功，200失败:
    private int code;
    //返回成功或失败的信息:成功，失败
    private String msg;
    //返回的结果集
    private Map<String,Object> extend=new HashMap<String,Object>();
    //setter and getter
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Map<String, Object> getExtend() {
        return extend;
    }
    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
    //成功
    public static Msg success() {
        Msg result=new Msg();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;

    }

    //失败
    public static Msg fail() {
        Msg result=new Msg();
        result.setCode(100);
        result.setMsg("处理失败！");
        return result;
    }
    //添加返回的数据
    public Msg add(String key,Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", extend=" + extend +
                '}';
    }
}
