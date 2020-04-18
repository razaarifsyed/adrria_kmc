package arifraza.adrriagit;

public class report {



     String pId;
     String pName;
     String rp;
     String rml;
     String pLoc;
     String pGenre;
    String rem;
    String dat;
    String dnm;
    String rct;
    String cst;
    String nas;
    String ass3;
    String asse;
    String arem;
    String rpno;
    String dat2;


    public report(){

    }

    public report(String pId, String pName,String rp,String rml, String dat, String pLoc, String pGenre,String rem,String dnm,String rct,String cst,String nas,String ass3,String asse,String arem,String rpno,String dat2) {
        this.pId = pId;
        this.pName = pName;
        this.rp=rp;
        this.rml=rml;
        this.dat=dat;
        this.pLoc=pLoc;
        this.pGenre = pGenre;
        this.rem=rem;
        this.dnm=dnm;
        this.rct=rct;
        this.cst=cst;
        this.nas=nas;
        this.ass3=ass3;
        this.asse=asse;
        this.arem=arem;
        this.rpno=rpno;
        this.dat2=dat2;

    }


    public String getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }
    public String getrp() {
        return rp;
    }
    public String getdat() {
        return dat;
    }

    public String getpLoc(){
        return pLoc;
    }
    public String getpGenre() {
        return pGenre;
    }
    public String getrem(){return rem;}
    public String getdnm(){return dnm;}
    public String getrct(){return rct;}
    public String getcst(){return cst;}
    public String getnas(){return nas;}
    public String getass3(){return ass3;}
    public String getasse(){return asse;}
    public String getrml(){return rml;}
    public String getarem(){return arem;}
    public String getrpno(){return rpno;}
    public String getdat2() {
        return dat2;
    }

}
