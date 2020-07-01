package action;

public class typeScore {
    String type,fscore,fnum,mscore,mnum,movietype;
    public void  set(String name,String value){
        if(name.equals("fscore")) fscore=value;
        else if(name.equals("fnum")) fnum=value;
        else if(name.equals("mscore")) mscore=value;
        else if(name.equals("mnum")) mnum=value;
        else movietype=value;
    }

    public String getMovietype() {
        return movietype;
    }

    public void setMovietype(String movietype) {
        this.movietype = movietype;
    }

    public Integer getScore(){
        int num=Integer.valueOf(fnum)+Integer.valueOf(mnum);
        int score=Integer.valueOf(fscore)+Integer.valueOf(mscore);
        if(num==0) return 0;
        return score/num;
    }
    public Integer getFScore(){
        int num=Integer.valueOf(fnum);
        int score=Integer.valueOf(fscore);
        if(num==0) return 0;
        return score/num;
    }
    public Integer getMScore(){
        int num=Integer.valueOf(mnum);
        int score=Integer.valueOf(mscore);
        if(num==0) return 0;
        return score/num;
    }
    public String toString(){
        return type+" "+fscore+" "+fnum+" "+mscore+" "+mnum;
    }
    public String getType() {
        return type;
    }

    public String getFscore() {
        return fscore;
    }

    public String getFnum() {
        return fnum;
    }

    public String getMscore() {
        return mscore;
    }

    public String getMnum() {
        return mnum;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFscore(String fscore) {
        this.fscore = fscore;
    }

    public void setFnum(String fnum) {
        this.fnum = fnum;
    }

    public void setMscore(String mscore) {
        this.mscore = mscore;
    }

    public void setMnum(String mnum) {
        this.mnum = mnum;
    }
}
