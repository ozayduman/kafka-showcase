package com.ozayduman.message;
public class Message{
    private String uuid;
    private String content;

    public Message() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uuuid='" + uuid + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
