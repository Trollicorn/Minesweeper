import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Interface extends JFrame{
	private Container pane;
	private GridLayout grid=new GridLayout(10,10,1,1);
	private char[][] board = new char[10][10];
	private MineButton[][] buttonMap = new MineButton[10][10];


	public Interface(){
		this.setTitle("MineSweeper");
		this.setSize(500,500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);



	//BorderPane pane= new BorderPane();
		pane=this.getContentPane();
		pane.setLayout(grid);
		pane.setBackground(Color.BLUE);
		makeBoard();
		for (int i=0; i < board.length * board[0].length; i++){
			buttonMap[i / 10][i % 10] = new MineButton(board, i / 10, i % 10,this);
			buttonMap[i / 10][i % 10].addMouseListener(new MineListener(buttonMap[i / 10][i % 10]));
			buttonMap[i / 10][i % 10].setText("");
	//		MineButton button = new MineButton(board, i / 10, i % 10,buttonMap);
	//		buttonMap[i / 10][i % 10] = button;
		//	button.setForeground(Color.WHITE);
		//	button.addMouseListener(new MineListener(button));
		//	button.setText("");
			pane.add(buttonMap[i / 10][i % 10]);
		}

	}

	public MineButton getButton(int row, int col){
		return buttonMap[row][col];
	}


	public void makeBoard(){
		int minesWanted = 15;
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				if ((int)(Math.random() * 1000) % minesWanted == 0){
					board[i][j] = 'm';
				}else{
					board[i][j] = '-';
				}
			}
		}
	}

	public static void main(String[] args) {
		Interface g = new Interface();
		g.setVisible(true);
	}
}
