package action;

public class data {
    private String id;
    private String type;
    private String right;

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public data(String id, String type){
        this.id=id;
        this.type=type;
    }
    public data(String id, String type, String right){
        this.id=id;
        this.type=type;
        this.right=right;
    }
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
