package com.example.android.eduease;

public class TeacherDataUpload {
    String name, cllg, timeTo,timeFRom,key;
    boolean java,cpp,c,ds,daa,act,emfw,eem,aec,dec,shortTime,longTime,both;

    public boolean isC() {
        return c;
    }

    public boolean isAct() {
        return act;
    }

    public boolean isCpp() {
        return cpp;
    }

    public boolean isAec() {
        return aec;
    }

    public boolean isDaa() {
        return daa;
    }

    public boolean isDs() {
        return ds;
    }

    public boolean isEmfw() {
        return emfw;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isDec() {
        return dec;
    }

    public boolean isEem() {
        return eem;
    }

    public boolean isJava() {
        return java;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public String getTimeFRom() {
        return timeFRom;
    }

    public boolean isShortTime() {
        return shortTime;
    }

    public boolean isBoth() {
        return both;
    }

    public boolean isLongTime() {
        return longTime;
    }

    public String getName() {
        return name;
    }

    public String getCllg() {
        return cllg;
    }

    TeacherDataUpload(String NAME,String COLLEGE,String TIME_TO, boolean C,boolean DAA,boolean DS,boolean CPP,
    boolean ACT,boolean AEC,boolean DEC,boolean EEM,boolean EMFW,boolean JAVA,boolean BOTH,boolean SHORT,
                      boolean LONG,String TIMEFROM)
    {
        name= NAME;
        cllg=COLLEGE;
        timeTo= TIME_TO;
        c=C;
        cpp=CPP;
        daa= DAA;
        aec=AEC;
        dec=DEC;
        eem=EEM;
        emfw=EMFW;
        java = JAVA;
        both= BOTH;
        act= ACT;
        longTime = LONG;
        shortTime= SHORT;
        ds= DS;
timeFRom=TIMEFROM;

    }

    TeacherDataUpload()
    {
         name= cllg= timeTo=timeFRom=key=null;
         java=cpp=c=ds=daa=act=emfw=eem=aec=dec=shortTime=longTime=both=false;

    }
    public void setAct(boolean act) {
        this.act = act;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public void setAec(boolean aec) {
        this.aec = aec;
    }

    public void setCllg(String cllg) {
        this.cllg = cllg;
    }

    public void setBoth(boolean both) {
        this.both = both;
    }

    public void setCpp(boolean cpp) {
        this.cpp = cpp;
    }

    public void setDaa(boolean daa) {
        this.daa = daa;
    }

    public void setDs(boolean ds) {
        this.ds = ds;
    }

    public void setDec(boolean dec) {
        this.dec = dec;
    }

    public void setJava(boolean java) {
        this.java = java;
    }

    public void setEem(boolean eem) {
        this.eem = eem;
    }

    public void setEmfw(boolean emfw) {
        this.emfw = emfw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortTime(boolean shortTime) {
        this.shortTime = shortTime;
    }

    public void setLongTime(boolean longTime) {
        this.longTime = longTime;
    }

    public void setTimeTo(String time) {
        this.timeTo = time;
    }

    public void setTimeFRom(String timeFRom) {
        this.timeFRom = timeFRom;
    }
}
