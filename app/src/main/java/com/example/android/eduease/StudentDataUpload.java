package com.example.android.eduease;

class StudentDataUpload {
    String name,cllg;

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

    StudentDataUpload(String NAME,String CLLG)
    {
        name = NAME;
        cllg=CLLG;
    }
    StudentDataUpload()
    {
        name = null;
        cllg=null;
    }
}
