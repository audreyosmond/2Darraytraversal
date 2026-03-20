public class Tile{
    boolean visited;
    String value;
    private String chr;
    private boolean atPlayerPosition;
    public Tile(String v){
        value=v;
        chr=value;
        visited=false;
    }
    public void reset(){
        atPlayerPosition=false;
        setVisited(false);
    }
    public void setVisited(boolean flag){
        visited=flag;
        if(flag){
            chr=".";
        }else{
            chr=value;
        }
    }
    public void setAtPlayerPos(boolean flag){
        if(flag){
            chr="*";
        }else{
            if(visited){
                chr=".";
            }else{
                chr=value;
            }
        }
        atPlayerPosition=flag;
    }
    public String getChr(){
        return chr;
    }
    public boolean isStart(){
        if(value.equals("S")){
            return true;
        }
        return false;
    }
    public boolean isEnd(){
        if(value.equals("E")){
            return true;
        }
        return false;
    }
    public boolean isWall(){
        if(value.equals("1")){
            return true;
        }
        return false;
    }
    public String getValue(){
        return value;
    }
}