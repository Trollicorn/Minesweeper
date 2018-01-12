import javax.swing.*;

public class MineButton extends JButton{

    private char[][] board;
    private int row;
    private int col;
    private boolean flagged;
    private boolean covered;
    private int minesAround;
    private boolean endgame=false;
    private boolean minehit=false;
    private boolean zero;
    private int i;
    private int j;

    //Constructors 

    public MineButton(char[][] board, int row, int col){
	super();
	this.board = board;
	this.row = row;
	this.col = col;
	flagged = false;
	covered = true;
	minesAround = countMinesAround();
    }

    //getters

    public boolean isFlagged(){
	return flagged;
    }

    public boolean isCovered(){
	return covered;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    //setters 

    public void uncover(){
	covered = false;
	if (board[getRow()][getCol()] == 'm'){
	    setLabel(""+board[getRow()][getCol()]);
	    endgame=true;
	    minehit=true;
	}else{
	    if (countMinesAround()!=0){
		setLabel(""+countMinesAround());
		zero=false;
	    }
	    else{
		setLabel("");
		zero=true;
	    }
	}
    }

    public void uncover0(){
	if (board[i][j]!=0){
	    setLabel(""+countMinesAround());
	    zero=false;
	}
	else{
	    setLabel("");
	    zero=true;
	}
    }
    
    
    public void reset(){
	zero=true;
	i=row;
	j=col;
    }
    
    public void multuncover(){
	if (zero==true){
	    reset();
		
	    //diagonals
	    
	    while(i<board.length && j<board[i].length && zero==true){
		board[i][j].uncover0();
		i++;
		j++;
	    }
	    
	    reset();
	    
	    while(i>0 && j>0 && zero==true){
		board[i][j].uncover0();
		i--;
		j--;
	    }
	    
	    reset();
	    
	    while(i>0 && j<board[i].length && zero==true){
		board[i][j].uncover0();
		i--;
		j++;
	    }

	    reset();

	    //sides
	    
	    while(i>0 && j<board[i].length && zero==true){
		board[i][j].uncover0();
		i--;
	    }

	    reset();
	    
	    while(i<board.length && j>0 && zero==true){
		board[i][j].uncover0();
		j--;
	    }

	    reset();
	    
	    while(i>0 && j<board[i].length && zero==true){
		board[i][j].uncover0();
		i++;
	    }

	    reset();
	    
	    while(i>board.length && j<board[i].length && zero==true){
		board[i][j].uncover0();
		j++;
	    }

	}
	
    }
    
    public boolean getminehit(){
	return minehit;
    }

    public boolean getendgame(){
	return endgame;
    }

    public void flag(){
	flagged = !flagged;
	if (isFlagged()){
	    setLabel("f");
	}else{
	    setLabel("-");
	}
    }

    public int countMinesAround(){
	int count = 0; 
	boolean notRowZero = getRow() != 0; 
	boolean notColZero = getCol() != 0; 
	boolean notRowLast = getRow() != board.length - 1;
	boolean notColLast = getCol() != board[0].length - 1;

	if (notRowZero && notColZero && board[getRow()-1][getCol()-1] == 'm'){  // top left
	    count += 1;
	}
	if (notRowZero && board[getRow()-1][getCol()] == 'm'){                  // top mid 
	    count += 1;
	}
	if (notRowZero && notColLast && board[getRow()-1][getCol()+1] == 'm'){                // top right 
	    count += 1;
	}
	if (notColLast && board[getRow()][getCol()+1] == 'm'){                  // mid right 
	    count += 1;
	}
	if (notRowLast && notColLast && board[getRow()+1][getCol()+1] == 'm'){  // bot right 
	    count += 1;
	}
	if (notRowLast && board[getRow()+1][getCol()] == 'm'){                  // bot mid 
	    count += 1;
	}
	if (notRowLast && notColZero && board[getRow()+1][getCol()-1] == 'm'){  // bot left 
	    count += 1;
	}
	if (notColZero && board[getRow()][getCol()-1] == 'm'){                  // mid left 
	    count += 1;
	}
	return count;
    }




}
