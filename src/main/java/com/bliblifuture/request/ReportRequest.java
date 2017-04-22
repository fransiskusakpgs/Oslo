package com.bliblifuture.request;

import java.io.Serializable;

public class ReportRequest implements Serializable {

    private String reportDate;

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }
}
