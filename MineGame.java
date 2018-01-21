import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MineGame extends JFrame implements ActionListener{
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
    private ImageIcon[] icons = new ImageIcon[10];
    private int buttonHeight;
    private int buttonWidth;

    public MineGame(){
    	reset(10,10,500,500);
    	menuSet();
    	h=10;
    	w=10;
    	flag();
        setIcons(50,50);
    }

    public void actionPerformed(ActionEvent e){
    	flagNum.setText(flagCount()+"/"+mines+" mines flagged");
    	String s=e.getActionCommand();
    	if (s.equals("Easy")){
    		this.dispose();
    		System.out.println(s);
    		MineGame f= new MineGame("easy");
    		f.setVisible(true);
    	}
    	if (s.equals("Medium")){
    		this.dispose();
    		System.out.println(s);
    		MineGame f= new MineGame();
    		f.setVisible(true);
    	}
    	if (s.equals("Hard")){
    		this.dispose();
    		System.out.println(s);
    		MineGame f= new MineGame("hard");
    		f.setVisible(true);
    	}
    }


    public void reset(int h,int w, int a, int b){
    	grid= new GridLayout(h,w,1,1);
    	board= new char[h][w];
    	buttonMap= new MineButton[h][w];
    	this.setTitle("MineSweeper");
    	this.setSize(a,b);
    	this.setLocation(5,5);
        this.setResizable(false);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//	game = this;

	//BorderPane pane= new BorderPane();
    	pane=this.getContentPane();
    	pane.setLayout(grid);
    	pane.setBackground(Color.BLUE);
    	makeBoard();
    	for (int i=0; i < board.length * board[0].length; i++){
    		buttonMap[i / h][i % w] = new MineButton(board, i / h, i % w, buttonMap, icons);
    		buttonMap[i/h][i%w].addActionListener(this);
    		buttonMap[i / h][i % w].addMouseListener(new MineListener(buttonMap[i / h][i % w],buttonMap,board));
    		buttonMap[i / h][i % w].setText("");
    		pane.add(buttonMap[i / h][i % w]);
        /*    buttonHeight = buttonMap[i / h][i % w].getHeight();
            buttonWidth = buttonMap[i / h][i % w].getWidth();
    	*/}

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

    public MineGame(String mode){
    	if (mode.equals("easy")){
    		reset(5,5,500,500);
    		h=5;
    		w=5;
    		menuSet();
    		flag();
            setIcons(110,110);
    	}
    	if (mode.equals("hard")){
    		reset(20,20,500,500);
    		h=20;
    		w=20;
    		menuSet();
    		flag();
            setIcons(25,22);
    	}

    }

    public void setIcons(int width, int height){
        for (int i = 0; i < 10; i++){
            String location = "" + i;
            if (i == 0){
                location = "flag";
            }
            if (i == 9){
                location = "mine";
            }
            ImageIcon icon= new ImageIcon("Icons/" + location + ".png");
            Image image = icon.getImage();
            Image imageScaled = image.getScaledInstance(width,height,Image.SCALE_FAST);
            icons[i] = new ImageIcon(imageScaled);
        }
    }




    public static void main(String[] args) {
    	MineGame g = new MineGame();
    	g.setVisible(true);
    }
}