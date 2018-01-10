import javax.swing.*;

public class MineButton extends JButton{

	private char[][] board;
	private int row;
	private int col;
	private boolean flagged;
	private boolean covered;
	private int minesAround;

	//Constructors 

	public MineButton(char[][] board, int row, int col){
		super();
		this.board = board;
		this.row = row;
		this.col = col;
		flagged = false;
		covered = true;
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
	}

	public void flag(){
		flagged = !flagged;
	}



//	public int minesAround(){
		
//	}




}