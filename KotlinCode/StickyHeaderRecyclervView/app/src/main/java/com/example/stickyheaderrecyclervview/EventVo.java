package com.example.stickyheaderrecyclervview;

public class EventVo {
    public EventVo(int value) {
        this.value = value;
        date = value / 10;
        isHeader = value % 10 == 0;
    }
    private int value;

    private int date;
    private boolean isHeader = false;

    public int getValue() {
        return value;
    }

    public int getDate() {
        return date;
    }

    public boolean isHeader() {
        return isHeader;
    }

    @Override
    public String toString() {
        return "EventVo{" +
                "date=" + date +
                ", isHeader=" + isHeader +
                '}';
    }
}
