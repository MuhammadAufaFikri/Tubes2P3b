package com.example.appunpar;

import java.util.List;

public class modelMatkul {
    private String id;
    private String code;
    private String name;
    private int semester;

    public modelMatkul(String id, String code, String name, int semester) {
        this.id = id;
        this.code=code;
        this.name=name;
        this.semester=semester;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }
}
