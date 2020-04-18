package arifraza.adrriagit;

public class user {



    String did;
    String dname;
    String deml;
    String dhid;
    String dds;
    String dpn;



    public user(){

    }

    public user(String did, String dname,String dhid,  String dds, String dpn,String deml) {
        this.did=did;
        this.dname=dname;
        this.dhid=dhid;
        this.dds=dds;
        this.dpn=dpn;
        this.deml=deml;
    }


    public String getdid() {
        return did;
    }

    public String getdname() {
        return dname;
    }
    public String getdhid() {
        return dhid;
    }

    public String getdds(){
        return dds;
    }
    public String getdpn() {
        return dpn;
    }
    public String getdeml() {
        return deml;
    }

}
