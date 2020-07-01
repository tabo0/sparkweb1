package action;

public class insertAction {
    private String name,gender,score;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getScore() {
        return score;
    }
    public String put() throws Exception {
        System.out.println(name+"$$"+gender+"$$"+score);
        return "success";
    }
}
