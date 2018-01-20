import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Interface extends JFrame implements ActionListener{
    private Container pane;
    private JMenuBar menuBar;
    private JMenu menu;
    private JButton newgame;
    private GridLayout grid=new GridLayout(10,10,1,1);
    private char[][] board = new char[10][10];
    private MineButton[][] buttonMap = new MineButton[10][10];
    private JTextField flagnum;
    private int mines;
    //private MineGame game;

    public Interface(){
	reset();
	menuset();
    }

    public void actionPerformed(ActionEvent e){
	String s=e.getActionCommand();
	if (s.equals("New Game")){
	    this.dispose();
	    System.out.println(s);
	    Interface f= new Interface();
	    f.setVisible(true);
	}
    }


    public void reset(){
	this.setTitle("MineSweeper");
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//	game = this;

	//BorderPane pane= new BorderPane();
	pane=this.getContentPane();
	pane.setLayout(grid);
	pane.setBackground(Color.BLUE);
	makeBoard();
	for (int i=0; i < board.length * board[0].length; i++){
	    buttonMap[i / 10][i % 10] = new MineButton(board, i / 10, i % 10, buttonMap);
	    buttonMap[i / 10][i % 10].addMouseListener(new MineListener(buttonMap[i / 10][i % 10],buttonMap,board));
	    buttonMap[i / 10][i % 10].setText("");
	    /*		MineButton button = new MineButton(board, i / 10, i % 10,buttonMap);
			buttonMap[i / 10][i % 10] = button;
			button.setForeground(Color.WHITE);
			button.addMouseListener(new MineListener(button));
			button.setText("");
	    */		pane.add(buttonMap[i / 10][i % 10]);
	}

    }

    public MineButton getButton(int row, int col){
	return buttonMap[row][col];
    }


    public void menuset(){
	menuBar= new JMenuBar();

	menu=new JMenu("Options");
	menu.getAccessibleContext().setAccessibleDescription("Select Options");

	newgame= new JButton ("New Game");
	newgame.addActionListener(this);
	//newgame.setBounds(11,11,10,1);
	menu.add(newgame);

	flagnum=new JTextField(5);
	flagnum.setText(flagcount()+"/"+mines+" mines flagged");
	flagnum.setEditable(false);

	menuBar.add(menu);
	menuBar.add(flagnum);
	setJMenuBar(menuBar);
    }


    public int flagcount(){
	int count=0;
	for (int i=0; i < board.length * board[0].length; i++){
	    if((buttonMap[i / 10][i % 10]).isFlagged()){
		count++;
	    }
	    else{}
	}    

	return count;
    }

    public void makeBoard(){
	int denominator = 5;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		if ((int)(Math.random() * 1000) % denominator == 0){
		    board[i][j] = 'm';
		    mines++;
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
