package com.example.appunpar;

public class appointmentInput {
    private String title;
    private String description;
    private String start_datetime;
    private String end_datetime;

    public appointmentInput(String title,String description,String start_datetime,String end_datetime){
        this.title = title;
        this.description = description;
        this.start_datetime = start_datetime;
        this.end_datetime = end_datetime;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDatetime(String start_datetime) {
        this.start_datetime = start_datetime;
    }

    public void setEndDatetime(String end_datetime) {
        this.end_datetime = end_datetime;
    }


    public String getEndDatetime() {
        return end_datetime;
    }
    public String getStartDatetime() {
        return start_datetime;
    }
    public String getDescription() {
        return description;

    }
    public String getTitle() {
        return title;
    }


}
