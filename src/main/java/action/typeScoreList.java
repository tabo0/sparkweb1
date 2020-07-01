package action;

import java.util.ArrayList;
import java.util.List;

public class typeScoreList {
    List<typeScore> list;
    List<String> nameList;
    List<Integer> scoreList;

    public List<String> getNameList() {
        return nameList;
    }

    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public void setList(List<typeScore> list) {
        this.list = list;
    }

    public List<typeScore> getList() {
        return list;
    }
}
