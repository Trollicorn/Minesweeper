import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Interface extends JFrame implements ActionListener{
	private Container pane;
	private JMenuBar menuBar;
	private JMenu menu;
	private JButton easy;
	private JButton med;
	private JButton hard;
    private GridLayout grid;//=new GridLayout(10,10,1,1);
    private char[][] board;// = new char[10][10];
    private MineButton[][] buttonMap;// = new MineButton[10][10];
    private JTextField flagNum;
    private int mines;
    private int h;
    private int w;

    public Interface(){
    	reset(10,10,500,500);
    	menuSet();
    	h=10;
    	w=10;
    	flag();
    }

    public void actionPerformed(ActionEvent e){
    	flagNum.setText(flagCount()+"/"+mines+" mines flagged");
    	String s=e.getActionCommand();
    	if (s.equals("Easy")){
    		this.dispose();
    		System.out.println(s);
    		Interface f= new Interface("easy");
    		f.setVisible(true);
    	}
    	if (s.equals("Medium")){
    		this.dispose();
    		System.out.println(s);
    		Interface f= new Interface();
    		f.setVisible(true);
    	}
    	if (s.equals("Hard")){
    		this.dispose();
    		System.out.println(s);
    		Interface f= new Interface("hard");
    		f.setVisible(true);
    	}
    }


    public void reset(int h,int w, int a, int b){
    	grid= new GridLayout(h,w,1,1);
    	board= new char[h][w];
    	buttonMap= new MineButton[h][w];
    	this.setTitle("MineSweeper");
    	this.setSize(a,b);
    	this.setLocation(100,100);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//	game = this;

	//BorderPane pane= new BorderPane();
    	pane=this.getContentPane();
    	pane.setLayout(grid);
    	pane.setBackground(Color.BLUE);
    	makeBoard();
    	for (int i=0; i < board.length * board[0].length; i++){
    		buttonMap[i / h][i % w] = new MineButton(board, i / h, i % w, buttonMap);
    		buttonMap[i/h][i%w].addActionListener(this);
    		buttonMap[i / h][i % w].addMouseListener(new MineListener(buttonMap[i / h][i % w],buttonMap,board));
    		buttonMap[i / h][i % w].setText("");
    		pane.add(buttonMap[i / h][i % w]);
    	}

    }

    public MineButton getButton(int row, int col){
    	return buttonMap[row][col];
    }


    public void menuSet(){
    	menuBar= new JMenuBar();

	//menu=new JMenu("Options");
	//menu.getAccessibleContext().setAccessibleDescription("Select Options");

    	menu= new JMenu ("New Game");
    	menu.getAccessibleContext().setAccessibleDescription("Create a new game");
    	easy= new JButton ("Easy");
    	easy.addActionListener(this);
	//newgame.setBounds(11,11,10,1);
    	menu.add(easy);

    	med=new JButton ("Medium");
    	med.addActionListener(this);
    	menu.add(med);

    	hard=new JButton ("Hard");
    	hard.addActionListener(this);
    	menu.add(hard);

    	menuBar.add(menu);
    	setJMenuBar(menuBar);
    }

    public void flag(){
    	flagNum=new JTextField(5);
    	flagNum.setText(flagCount()+"/"+mines+" mines flagged");
    	flagNum.setEditable(false);
    	menuBar.add(flagNum);
    }

    public int flagCount(){
    	int count=0;
    	for (int i=0; i < board.length * board[0].length; i++){
    		if((buttonMap[i / h][i % w]).isFlagged()){
    			count++;
    		}
    	}    

    	return count;
    }

    public void makeBoard(){
    	int denominator = 5;
    	for (int i = 0; i < board.length; i++){
    		for (int j = 0; j < board[i].length; j++){
    			if ((int)(Math.random() * 1000) % denominator == 0){
    				board[i][j]='m';
    				mines++;
    			}else{
    				board[i][j] = '-';
    			}
    		}
    	}
    }

    public Interface (String mode){
    	if (mode.equals("easy")){
    		reset(5,5,500,500);
    		h=5;
    		w=5;
    		menuSet();
    		flag();
    	}
    	if (mode.equals("hard")){
    		reset(20,20,1000,1000);
    		h=20;
    		w=20;
    		menuSet();
    		flag();
    	}

    }

    public static void main(String[] args) {
    	Interface g = new Interface();
    	g.setVisible(true);
    }
}
