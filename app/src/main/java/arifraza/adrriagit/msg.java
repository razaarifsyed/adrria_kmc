package arifraza.adrriagit;

public class msg {



    String mId;
    String mname;
    String mmsg;
    String con;
    String rdd;
    String seml;
    String mmsg2;
    String rnm2;
    String rml2;
    String dat;
    String dat2;

    public msg(){

    }

    public msg(String mId,String mname,String con, String mmsg,String rdd,String seml,String mmsg2,String rnm2,String rml2,String dat,String dat2) {
        this.mId=mId;
        this.mname = mname;
        this.con=con;
        this.mmsg = mmsg;
        this.rdd=rdd;
        this.seml=seml;
        this.mmsg2=mmsg2;
        this.rnm2=rnm2;
        this.rml2=rml2;
        this.dat=dat;
        this.dat2=dat2;


    }
    public String getmId(){return mId;}

    public String getmname() {
        return mname;
    }

    public String getmmsg() {
        return mmsg;
    }
    public String getcon() {
        return con;
    }
    public String getrdd() {
        return rdd;
    }

    public String getseml(){return seml;}
    public String getmmsg2(){return mmsg2;}
    public String getrnm2(){return rnm2;}
    public String getrml2(){return rml2;}
    public String getdat(){return dat;}
    public String getdat2(){return dat2;}

}
