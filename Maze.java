import java.util.*;
public class Maze{
    private Tile[][] board;
    private int startR;
    private int startC;
    private int endR;
    private int endC;
    private ArrayList<String> visited;
    private int posR;
    private int posC;
    public Maze(Tile[][] mat){
        board=mat;
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j].equals("S")){
                    startR=i;
                    startC=j;
                }
                if(board[i][j].equals("E")){
                    endR=i;
                    endC=j;
                }
            }
        }
        visited=new ArrayList<>();
        posR=startR;
        posC=startC;
    }
    
    public void addVisited(int row,int col){
        visited.add(row+" "+col);
    }
    
    public void move(String dir){
        if(dir.equals("u")){
            if(posR>0){
                if(visited.contains((posR-1)+" "+posC)){
                    --posR;
                    addVisited(posR-1,posC);
                }else{
                    System.out.println("Cell already visited");
                }
            }else{
                System.out.println("Invalid position");
            }
        }
        if(dir.equals("d")){
            if(posR<board.length-1){
                if(visited.contains((posR+1)+" "+posC)){
                    ++posR;
                    addVisited(posR+1,posC);
                }else{
                    System.out.println("Cell already visited");
                }
            }else{
                System.out.println("Invalid position");
            }
        }
        if(dir.equals("l")){
            if(posC>0){
                if(visited.contains(posR+" "+(posC-1))){
                    --posC;
                    addVisited(posR,(posC-1));
                }else{
                    System.out.println("Cell already visited");
                }
            }else{
                System.out.println("Invalid position");
            }
        }
        if(dir.equals("r")){
            ++posC;
            if(posC<board[0].length-1){
                if(visited.contains(posR+" "+(posC+1))){
                    ++posC;
                    addVisited(posR,(posC+1));
                }else{
                    System.out.println("Cell already visited");
                }
            }else{
                System.out.println("Invalid position");
            }
        }
    }
    
    public void reset(){
        
    }
    
    public void print(){
        
    }
}








