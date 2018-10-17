package com.example.mudy.uibestpractice;

/**
 * Created by mudy on 2018/10/17.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;

    public static final int TYPE_SEND = 1;

    private String content;

    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}