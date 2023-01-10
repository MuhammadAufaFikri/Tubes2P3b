package com.example.appunpar;

import java.util.List;

public class modelPengumuman {
    private String id;
    private String title;
    private List<String> tags;

    public modelPengumuman(String id, String title, List<String> tags) {
        this.id = id;
        this.title = title;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }
}
