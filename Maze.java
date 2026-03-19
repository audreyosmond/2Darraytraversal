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
        visited.add(posR+" "+posC);
        board[posR][posC].setVisited(true);
        board[posR][posC].setAtPlayerPos();
    }
    
    public void addVisited(int row,int col){
        visited.add(row+" "+col);
    }

    public boolean checkWin(){
        return false;
    }
    
    public void move(String dir){
        if(dir.equals("w")){
            if(posR>0){
                if(!visited.contains((posR-1)+" "+posC)){
                    if(!board[posR-1][posC].isWall()){
                        if(board[posR-1][posC].isEnd()){
                            if(!checkWin()){
                                System.out.println("You did not visit every cell");
                                reset();
                            }
                        }
                        --posR;
                        addVisited(posR,posC);
                        board[posR][posC].setVisited(true);
                        board[posR][posC].setAtPlayerPos();
                    }else{
                        System.out.println("Cell is a wall");
                        reset();
                    }
                }else{
                    System.out.println("Cell already visited");
                    reset();
                }
            }else{
                System.out.println("Invalid position");
                reset();
            }
        }
        else if(dir.equals("s")){
            if(posR<board.length-1){
                if(!visited.contains((posR+1)+" "+posC)){
                    if(!board[posR+1][posC].isWall()){
                        ++posR;
                        addVisited(posR,posC);
                        board[posR][posC].setVisited(true);
                        board[posR][posC].setAtPlayerPos();
                    }else{
                        System.out.println("Cell is a wall");
                        reset();
                    }
                }else{
                    System.out.println("Cell already visited");
                    reset();
                }
            }else{
                System.out.println("Invalid position");
                reset();
            }
        }
        else if(dir.equals("a")){
            if(posC>0){
                if(!visited.contains(posR+" "+(posC-1))){
                    if(!board[posR][posC-1].isWall()){
                        --posC;
                        addVisited(posR,posC);
                        board[posR][posC].setVisited(true);
                        board[posR][posC].setAtPlayerPos();
                    }else{
                        System.out.println("Cell is a wall");
                        reset();
                    }
                }else{
                    System.out.println("Cell already visited");
                    reset();
                }
            }else{
                System.out.println("Invalid position");
                reset();
            }
        }
        else if(dir.equals("d")){
            if(posC<board[0].length-1){
                if(!visited.contains(posR+" "+(posC+1))){
                    if(!board[posR][posC+1].isWall()){
                        ++posC;
                        addVisited(posR,posC);
                        board[posR][posC].setVisited(true);
                        board[posR][posC].setAtPlayerPos();
                    }else{
                        System.out.println("Cell is a wall");
                        reset();
                    }
                }else{
                    System.out.println("Cell already visited");
                }
            }else{
                System.out.println("Invalid position");
            }
        }else{
            System.out.println("Enter a valid input");
        }
    }
    
    public void reset(){
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                board[i][j].reset();
            }
        }
        posR=startR;
        posC=startC;
        board[posR][posC].setVisited(true);
        board[posR][posC].setAtPlayerPos();
        visited.clear();
        visited.add(posR+" "+posC);
    }
    
    public void print(){
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                System.out.println(board[i][j].getChr()+" ");
            }
            System.out.println();
        }
    }
}








