package com.example.projectphase1;

import java.util.Date;

public class ClassMyTask {
    private int TaskId;
    private int UserId;
    private String task_Job_Name;
    private  int task_job_id;
    private int TaskBill;
    private String TaskDate;
    private String TaskLocation;
    private int TaskImage;

    public ClassMyTask(int taskId, int userId, String task_Job_Name, int task_job_id, int taskBill, String taskDate, String taskLocation, int taskImage) {
        TaskId = taskId;
        UserId = userId;
        this.task_Job_Name = task_Job_Name;
        this.task_job_id = task_job_id;
        TaskBill = taskBill;
        TaskDate = taskDate;
        TaskLocation = taskLocation;
        TaskImage = taskImage;
    }

    public int getTaskId() {
        return TaskId;
    }

    public int getUserId() {
        return UserId;
    }

    public String getTask_Job_Name() {
        return task_Job_Name;
    }

    public int getTask_job_id() {
        return task_job_id;
    }

    public int getTaskBill() {
        return TaskBill;
    }

    public String getTaskDate() {
        return TaskDate;
    }

    public String getTaskLocation() {
        return TaskLocation;
    }

    public int getTaskImage() {
        return TaskImage;
    }
}


