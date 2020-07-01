package action;


import com.opensymphony.xwork2.ActionContext;
import scala.test1;

import java.util.ArrayList;
import java.util.List;

public class testAction {
    private  movieList list= new movieList();
    private  String msg="msg";
    private typeScoreList Scorelist=new typeScoreList();
    private String type,score,gender;

    public String getType() {
        return type;
    }

    public String getScore() {
        return score;
    }

    public String getGender() {
        return gender;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public typeScoreList getScorelist() {
        return Scorelist;
    }

    public void setScorelist(typeScoreList scorelist) {
        Scorelist = scorelist;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public movieList getList() {
        return list;
    }

    public void setList(movieList list) {
        this.list = list;
    }
    public String search() throws Exception {
//        System.out.println("1111   "+msg);
//        //msg="Carne (1991)";
//        ArrayList<movie> arr=new ArrayList<movie>();
//        String[] ans=test1.search(msg);
//        for(int i=0;i<ans.length;i++){
//            System.out.println(ans[i]);
//            movie m=new movie(ans[i]);
//            arr.add(m);
//        }
//        list.setList(arr);


        operation o =new operation();
        o.initconnection();
        List<typeScore> list1=o.queryTable("movieScore1");
        List<movie> arr=new ArrayList<movie>();
        for(typeScore ts:list1){
            movie m=new movie();
            m.setName(ts.getType());
            m.setType(ts.getMovietype());
            if((m.toString()).contains(msg)) arr.add(m);
            if((m.toString()).contains(msg)) System.out.println(m.toString());
        }
        list.setList(arr);
        return "success";
    }
    public String test() throws Exception {
//        String[] s= test1.getAllMovie();
//        List<movie> arr=new ArrayList<movie>();
//        for(int i=1;i<=100;i++){
//            movie m=new movie(s[i]);
//            arr.add(m);
//            System.out.println(m.toString());
//        }
//        list.setList(arr);
//        ActionContext.getContext().put("list", arr);

        operation o =new operation();
        o.initconnection();
        List<typeScore> list1=o.queryTable("movieScore1");
        List<movie> arr=new ArrayList<movie>();
        for(typeScore ts:list1){
            movie m=new movie();
            m.setName(ts.getType());
            m.setType(ts.getMovietype());
            arr.add(m);
            System.out.println(m.toString());
        }
        list.setList(arr);
        return "success";
    }
    public String test1(){
        String[] s= test1.test();
        ArrayList<movie> arr=new ArrayList<movie>();
        for(String i : s){
            movie m=new movie(i);
            arr.add(m);
            //System.out.println(m.toString());
        }
        list.setList(arr);
        return "success";
    }
    public String test2(){
        String[] s= test1.test1();
        ArrayList<movie> arr=new ArrayList<movie>();
        for(String i : s){
            movie m=new movie(i);
            arr.add(m);
            //System.out.println(m.toString());
        }
        list.setList(arr);
        return "success";
    }
    public String gettypeScore() throws Exception {
        operation o =new operation();
        o.initconnection();
        List<typeScore> list=o.queryTable("typeScore1");
        List<String> nameList=new ArrayList<String>();
        List<Integer> scoreList=new ArrayList<Integer>();
        for(typeScore ts :list){
            nameList.add(ts.getType());
            scoreList.add(ts.getScore());
        }
        Scorelist.setList(list);
        Scorelist.setNameList(nameList);
        Scorelist.setScoreList(scoreList);
        return "success";
    }
    public String gettypeCompare() throws Exception {
        operation o =new operation();
        o.initconnection();
        List<typeScore> list=o.queryTable("typeScore1");
        List<String> nameList=new ArrayList<String>();
        List<Integer> scoreList=new ArrayList<Integer>();
        for(typeScore ts :list){
            if(msg.equals(ts.getType())){
                nameList.add("男性平均评分");
                nameList.add("女性平均评分");
                scoreList.add(ts.getMScore());
                scoreList.add(ts.getFScore());
            }
        }
        Scorelist.setList(list);
        Scorelist.setNameList(nameList);
        Scorelist.setScoreList(scoreList);
        return "success";
    }
    public String getMovieScore() throws Exception {
        operation o =new operation();
        o.initconnection();
        List<typeScore> list=o.queryTable("movieScore1");
        List<String> nameList=new ArrayList<String>();
        List<Integer> scoreList=new ArrayList<Integer>();
        for(typeScore ts :list){
            if(msg.equals(ts.getType())){
                nameList.add("男性平均评分");
                nameList.add("女性平均评分");
                nameList.add("总平均评分");
                scoreList.add(ts.getMScore());
                scoreList.add(ts.getFScore());
                scoreList.add(ts.getScore());
            }
        }
        Scorelist.setList(list);
        Scorelist.setNameList(nameList);
        Scorelist.setScoreList(scoreList);
        return "success";
    }
    public void create() throws Exception {
        String[] ans=test1.create();
        operation o =new operation();
        o.initconnection();
        o.Put("typeScore1",ans);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
    public String put() throws Exception {
        type=type.replace("%20"," ");
        if(gender.equals("男性")) gender="m";
        else gender="f";

        //System.out.println(type+"$$"+score+"$$"+gender);
        //putScore(type,score,gender);
        operation o =new operation();
        o.initconnection();
        List<typeScore> list= o.queryTable("movieScore1");
        for(typeScore ts : list){
            if(type.equals(ts.getType())){
                //System.out.println("bbbbbbbbbbbbbb: "+ts.getMovietype());
                String[] typesplit=(ts.getMovietype()).split("\\|");
                for(int i=0;i<typesplit.length;i++){
                    //System.out.println(typesplit[i]);
                    putScore(typesplit[i],score,gender);
                }
            }
        }
        putmovieScore(type,score,gender);
        return "success";
    }
    public  void putmovieScore(String type ,String score ,String gender) throws Exception {
        operation o =new operation();
        o.initconnection();
        typeScore old=o.find_family("movieScore1",type);
        if(gender.equals("f")){
            int new_score=Integer.valueOf(old.getFscore())+Integer.valueOf(score);
            int num=Integer.valueOf(old.getFnum())+1;
            o.Putqualifier("movieScore1",type,"fscore",String.valueOf(new_score));
            o.Putqualifier("movieScore1",type,"fnum",String.valueOf(num));
        }
        else{
            int new_score=Integer.valueOf(old.getMscore())+Integer.valueOf(score);
            int num=Integer.valueOf(old.getMnum())+1;
            o.Putqualifier("movieScore1",type,"mscore",String.valueOf(new_score));
            o.Putqualifier("movieScore1",type,"mnum",String.valueOf(num));
        }
    }
    public  void putScore(String type ,String score ,String gender) throws Exception {
        operation o =new operation();
        o.initconnection();
        typeScore old=o.find_family("typeScore1",type);
        if(gender.equals("f")){
            int new_score=Integer.valueOf(old.getFscore())+Integer.valueOf(score);
            int num=Integer.valueOf(old.getFnum())+1;
            o.Putqualifier("typeScore1",type,"fscore",String.valueOf(new_score));
            o.Putqualifier("typeScore1",type,"fnum",String.valueOf(num));
        }
        else{
            int new_score=Integer.valueOf(old.getMscore())+Integer.valueOf(score);
            int num=Integer.valueOf(old.getMnum())+1;
            o.Putqualifier("typeScore1",type,"mscore",String.valueOf(new_score));
            o.Putqualifier("typeScore1",type,"mnum",String.valueOf(num));
        }
    }
    public static void main(String[] args) throws Exception {
        testAction t=new testAction();
        t.setMsg("Wings of Courage (1995)");
        t.search();
        //t.initmovie();
        //t.type="Toy Story (1995)";
        //t.put();
        //t.test();


    }
    public String initmovie() throws Exception {
        String[] s= test1.getAllMovie();
        List<movie> arr=new ArrayList<movie>();
        for(int i=1;i<=100;i++){
            movie m=new movie(s[i]);
            arr.add(m);
            System.out.println(m.toString());
        }
        operation o =new operation();
        o.initconnection();
        o.initmovie("movieScore1",arr);
        return "success";
    }
}
