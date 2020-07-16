package com.example.android.eduease;

public class TeacherDataRetrieve {
    String name,timeTo,TimeFrom,cllg,key;
    TeacherDataRetrieve(String n,String t,String f,String clg)
    {
        name=n;
        cllg=clg;
        timeTo = t;
        TimeFrom=f;
    }

    public String getCllg() {
        return cllg;
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
