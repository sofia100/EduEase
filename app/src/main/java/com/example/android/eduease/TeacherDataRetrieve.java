package com.example.android.eduease;

public class TeacherDataRetrieve {
    String name,timeTo,TimeFrom;
    TeacherDataRetrieve(String n,String t,String f)
    {
        name=n;
        timeTo = t;
        TimeFrom=f;
    }

    public String getName() {
        return name;
    }

    public String getTimeFrom() {
        return TimeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }
}
