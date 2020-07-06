package com.example.eventbus.two;

/**
 * @author Administrator
 */
public class EventBusMessageBean {
    public int type;
    public Object date;
    public static int TEST_TYPE = 10000;

    public EventBusMessageBean(int type, Object date) {
        this.type = type;
        this.date = date;
    }
}
