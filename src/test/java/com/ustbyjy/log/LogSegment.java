package com.ustbyjy.log;

import java.io.Serializable;
import java.util.Date;

public class LogSegment implements Serializable, Comparable {
    private String requestId;
    private int startNum;
    private int endNum;
    private Date startTime;
    private long costInMillisecond;
    private String message;

    public String getRequestId() {
        return requestId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LogSegment{");
        sb.append("requestId='").append(requestId).append('\'');
        sb.append(", startNum=").append(startNum);
        sb.append(", endNum=").append(endNum);
        sb.append(", startTime=").append(startTime);
        sb.append(", costInMillisecond=").append(costInMillisecond);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getMessage() {
        return message;
    }

    public LogSegment setMessage(String message) {
        this.message = message;
        return this;
    }

    public LogSegment setRequestId(String requestId) {

        this.requestId = requestId;
        return this;
    }

    public int getStartNum() {
        return startNum;
    }

    public LogSegment setStartNum(int startNum) {
        this.startNum = startNum;
        return this;
    }

    public int getEndNum() {
        return endNum;
    }

    public LogSegment setEndNum(int endNum) {
        this.endNum = endNum;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public LogSegment setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public long getCostInMillisecond() {
        return costInMillisecond;
    }

    public LogSegment setCostInMillisecond(long costInMillisecond) {
        this.costInMillisecond = costInMillisecond;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (this.getCostInMillisecond() - ((LogSegment) o).getCostInMillisecond());
    }
}
