import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MineListener extends MouseAdapter{

	private MineButton myButton;
	private MineButton[][] buttonMap;
	private char[][] board;
	//private JTextField text;

	public MineListener(MineButton button,MineButton[][] buttonMap, char[][] board){
		myButton = button;
		this.buttonMap = buttonMap;
		this.board = board;
	}

	public void mouseClicked(MouseEvent click){
		if (myButton.isCovered()){
			if (SwingUtilities.isLeftMouseButton(click) && !myButton.isFlagged()){
				if (myButton.isFirstHit()){
					boolean notRowZero = myButton.getRow() != 0; 
					boolean notColZero = myButton.getCol() != 0; 
					boolean notRowLast = myButton.getRow() != board.length - 1;
					boolean notColLast = myButton.getCol() != board[0].length - 1;

					board[myButton.getRow()][myButton.getCol()] = '-'; //mid mid 

					if (notRowZero && notColZero){  
						board[myButton.getRow()-1][myButton.getCol()-1] = '-'; //top left 
					} 
					if (notRowZero){              
						board[myButton.getRow()-1][myButton.getCol()] = '-'; //top mid 
					}
					if (notRowZero && notColLast){               
						board[myButton.getRow()-1][myButton.getCol()+1] = '-'; //top right 
					}
					if (notColLast){	
						board[myButton.getRow()][myButton.getCol()+1] = '-'; //mid right 
					}
					if (notRowLast && notColLast){ 
						board[myButton.getRow()+1][myButton.getCol()+1] = '-'; //bot right
					}
					if (notRowLast){  
						board[myButton.getRow()+1][myButton.getCol()] = '-'; //bot mid
					}
					if (notRowLast && notColZero){ 
						board[myButton.getRow()+1][myButton.getCol()-1] = '-'; //bot left
					}
					if (notColZero){ 
						board[myButton.getRow()][myButton.getCol()-1] = '-'; // mid left 
					}
					for (int i = 0; i < board.length; i++){
						for (int j = 0; j < board[0].length; j++){
							buttonMap[i][j].notFirst();
						}
					}
				}
				myButton.uncover();
				if (myButton.isEndGame()){
					gameOver();
				}
				myButton.setEnabled(false);
			}
			if (SwingUtilities.isRightMouseButton(click)){
				myButton.flag();
			}
		}
	}

	public void reveal(){

	}

	public void gameOver(){
		if (myButton.isMineHit()){
			endPage("Game Over. You Lose.");
		}
		else{
			endPage("Congratulations! You won!");
		}
	}

	public void endPage(String message){
		JFrame endpane=new JFrame();
		endpane.setTitle("The Game Has Ended");
		endpane.setSize(500,100);
		endpane.setLocation(100,100);
	//endpane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		endpane.getContentPane();
		endpane.setLayout(new FlowLayout());

		JTextField text = new JTextField(25);
		text.setText(message);
		text.setEditable(false);
		endpane.add(text);

		endpane.setVisible(true);
	}

}
