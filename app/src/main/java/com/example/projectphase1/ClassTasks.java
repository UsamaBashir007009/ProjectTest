package com.example.projectphase1;

public class ClassTasks {
    private int jobId;
    private String jobName;
    private int jobPhoto;

    public ClassTasks(int jobId, String jobName, int jobPhoto) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobPhoto = jobPhoto;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setJobPhoto(int jobPhoto) {
        this.jobPhoto = jobPhoto;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public int getJobPhoto() {
        return jobPhoto;
    }
}
