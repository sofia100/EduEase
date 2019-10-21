package com.example.android.eduease;

class StudentDataUpload {
    String name,cllg,key;

    public String getCllg() {
        return cllg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCllg(String cllg) {
        this.cllg = cllg;
    }

    public void setKey(String key) {
        this.key = key;
    }

    StudentDataUpload(String NAME, String CLLG)
    {
        name = NAME;
        cllg=CLLG;
    }
    StudentDataUpload()
    {
        name = key=null;
        cllg=null;
    }
}
