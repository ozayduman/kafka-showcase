package com.ozayduman.message;

import java.io.Serializable;

public class Message implements Serializable {
    private String uuid;
    private String content;

    public Message() {
    }

    public Message(String content, String uuid) {
        this.content = content;
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uuid='" + uuid + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
