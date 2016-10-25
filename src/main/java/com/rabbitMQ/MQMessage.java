package com.rabbitMQ;

public class MQMessage {
    /** session id recover key fields */
    private String source;
    private String topic;
    private String content;
    private String destination;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
