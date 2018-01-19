import javax.swing.*;

public class MineButton extends JButton{

	private char[][] board;
	private int row;
	private int col;
	private boolean flagged;
	private boolean covered;
	private int minesAround;
	private boolean endGame=false;
	private boolean mineHit=false;
	private MineButton[][] buttonMap;
	private boolean firstHit=true;
	private boolean revealTime=false;
/*	private boolean zero;
	private int i;
	private int j;
*/

    //Constructors 

	public MineButton(char[][] board, int row, int col, MineButton[][] buttonMap){
		super();
		this.board = board;
		this.row = row;
		this.col = col;
		this.buttonMap = buttonMap;
		flagged = false;
		covered = true;
		revealTime = false;
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

    public boolean isFirstHit(){
	return firstHit;
    }

    public boolean isRevealTime(){
	return revealTime;
    }

    public boolean isMineHit(){
	return mineHit;
    }

    public boolean isEndGame(){
	return endGame;
    }


    //setters 

    public void uncover(){
	if (!covered){
	    return;
	}
	covered = false;
	setBackground(Color.LIGHT_GRAY);
	if (buttonMap[0][0].isRevealTime()){
	    setBackground(Color.CYAN);
	}
		if (board[getRow()][getCol()] == 'm'){
			setText(""+board[getRow()][getCol()]);
			endGame=true;
			mineHit=true;
		}else{
			if (countMinesAround()!=0){
				setText(""+countMinesAround());
			//	zero=false;
			}
			else{
				setText("");
				boolean notRowZero = getRow() != 0; 
				boolean notColZero = getCol() != 0; 
				boolean notRowLast = getRow() != board.length - 1;
				boolean notColLast = getCol() != board[0].length - 1;
				if (notRowZero && notColZero){  // top left
					buttonMap[getRow()-1][getCol()-1].uncover();
				} 
				if (notRowZero){                  // top mid 
					buttonMap[getRow()-1][getCol()].uncover();
				}
				if (notRowZero && notColLast){                // top right 
					buttonMap[getRow()-1][getCol()+1].uncover();
				}
				if (notColLast){                  // mid right 
				    buttonMap[getRow()][getCol()+1].uncover();
				}
				if (notRowLast && notColLast){  // bot right 
				    buttonMap[getRow()+1][getCol()+1].uncover();
				}
				if (notRowLast){                  // bot mid 
				    buttonMap[getRow()+1][getCol()].uncover();
				}
				if (notRowLast && notColZero){  // bot left 
				    buttonMap[getRow()+1][getCol()-1].uncover();
				}
				if (notColZero){                  // mid left 
				    buttonMap[getRow()][getCol()-1].uncover();
				}
			}
			//	zero=true;
		}
		if (allUncovered()){
		    endGame = true;
		}

}
    
    public void flag(){
	flagged = !flagged;
	if (isFlagged()){
	    setText("f");
	}else{
	    setText("-");
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
