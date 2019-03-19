package com.myCompany.conferenceManagmentSystem.entity;


import org.apache.commons.lang.StringUtils;

public class Review extends AbstractEntity<Long>{
    private String topic;
    private int countRegistered;
    private int countVisitors;
    private long idSpeaker;
    private long idSpeaking;

    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public int getCountRegistered() {
        return countRegistered;
    }
    public void setCountRegistered(int countRegistered) {
        this.countRegistered = countRegistered;
    }
    public int getCountVisitors() {
        return countVisitors;
    }
    public void setCountVisitors(int countVisitors) {
        this.countVisitors = countVisitors;
    }
    public long getIdSpeaker() {
        return idSpeaker;
    }
    public void setIdSpeaker(long idSpeaker) {
        this.idSpeaker = idSpeaker;
    }
    public long getIdSpeaking() {
        return idSpeaking;
    }
    public void setIdSpeaking(long idSpeaking) {
        this.idSpeaking = idSpeaking;
    }

    public String getShortTopic(){
        if(StringUtils.length(topic) > 20){
            return topic.substring(0, 17) + "...";
        }else{
            return topic;
        }
    }
}
