package action;

public class movie {
    String id,name,type;
    public movie(String str){
        String[] arr=str.split(",");
        id=arr[0];
        type=arr[arr.length-1];
        name="";
        for(int i=1;i<arr.length-1;i++){
            name+=arr[i];
        }
    }
    public movie(){

    }
    public  String toString(){
        return id +"  "+name+"  "+type;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
