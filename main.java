import java.io.*;
import java.util.*;
public class main {
    public static void main(String [] args)throws IOException{
        Scanner input=new Scanner(new File("puzzle.txt"));
        Tile[][] arr=new Tile[4][11];
        for(int i=0;i<4;++i){
            for(int j=0;j<11;++j){
                String x=input.next();
                Tile t=new Tile(x,i+" "+j);
                arr[i][j]=t;
            }
        }
        Maze board=new Maze(arr);
        
        Scanner userInput=new Scanner(System.in);
        while(!board.checkWin()){
            board.print();
            board.move(userInput.next());
            if(board.checkWin()){
                System.out.println("You win");
            }
        }
    }
}
