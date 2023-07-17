package com.HMRS.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="Payrolls")
public class Payroll implements Serializable {
    @Id
    @Column(name="job_Id")
    private long jobId;

    @Column(name="title")
    private String title;
    @Column(name="linkToTraining")
    private String linkToTraining;

    public long getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkToTraining() {
        return linkToTraining;
    }

    public void setLinkToTraining(String linkToTraining) {
        this.linkToTraining = linkToTraining;
    }
}
