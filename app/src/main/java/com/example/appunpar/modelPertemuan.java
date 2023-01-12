package com.example.appunpar;

import java.util.List;

public class modelPertemuan {
    private String id;
    private String title;
    private String description;
    private String start_datetime;
    private String end_datetime;
    private String organizer_id;
    private String organizer_name;


    public modelPertemuan(String id,String title,String description,String start_datetime, String end_datetime,String organizer_id,String organizer_name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.start_datetime = start_datetime;
        this.end_datetime = end_datetime;
        this.organizer_id = organizer_id;
        this.organizer_name = organizer_name;
    }
    //getter
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStartDatetime() { return start_datetime; }
    public String getEndDatetime() { return end_datetime; }
    public String getOrganizerId() { return organizer_id; }
    public String getOrganizerName() { return organizer_name; }

    //setter
    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStartDatetime(String start_datetime) { this.start_datetime = start_datetime; }
    public void setEndDatetime(String end_datetime) { this.end_datetime = end_datetime; }
    public void setOrganizerId(String organizer_id) { this.organizer_id = organizer_id; }
    public void setOrganizerName(String organizer_name) { this.organizer_name = organizer_name; }


}
