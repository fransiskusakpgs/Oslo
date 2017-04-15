package com.bliblifuture.request;

import java.io.Serializable;

public class ReportRequest implements Serializable {

    private String finishCountingTime;

    public String getFinishCountingTime() {
        return finishCountingTime;
    }

    public void setFinishCountingTime(String finishCountingTime) {
        this.finishCountingTime = finishCountingTime;
    }
}
