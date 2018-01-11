import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MineListener extends MouseAdapter{

    private Container endpane;
    private MineButton myButton;
    private JTextField text;

    public MineListener(MineButton button){
	myButton = button;
    }

    public void mouseClicked(MouseEvent click){
	if (myButton.isCovered()){
	    if (SwingUtilities.isLeftMouseButton(click) && !myButton.isFlagged()){
		myButton.uncover();
		if (myButton.getendgame()==true){
		    GameOver();
		}
	    }
	    if (SwingUtilities.isRightMouseButton(click)){
		myButton.flag();
	    }
	}
    }

    public void GameOver(){
	if (myButton.getminehit()==true){
	    EndPage("Game Over. You Lose.");
	}
	else{
	    EndPage("Congratulations! You won!");
	}
    }

    public void EndPage(String message){
	this.setTitle("The Game Has Ended");
	this.setSize(200,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	endpane=this.getContentPane();
	endpane.setLayout(new FlowLayout());

	text= new JTextField(30);
	text.setText(message);
	text.setEditable(false);

	endpane.setVisible(true);
    }

}
