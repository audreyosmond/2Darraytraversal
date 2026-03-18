public class Tile{
    boolean visited;
    String value;
    private String chr;
    private String position;
    private boolean atPlayerPosition;
    public Tile(String v, String pos){
        value=v;
        chr=value;
        visited=false;
        position=pos;
        
    }
    public void setVisited(boolean flag){
        if(!isStart()&&!isEnd()){
            visited=flag;
            if(flag){
                chr="."
            }
        }
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
    
}