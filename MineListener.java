import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MineListener extends MouseAdapter{

	private MineButton myButton;
	//private JTextField text;

	public MineListener(MineButton button){
		myButton = button;
	}

	public void mouseClicked(MouseEvent click){
		if (myButton.isCovered()){
			if (SwingUtilities.isLeftMouseButton(click) && !myButton.isFlagged()){
				myButton.uncover();
				if (myButton.isEndGame()){
					GameOver();
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

	public void GameOver(){
		if (myButton.isMineHit()){
			EndPage("Game Over. You Lose.");
		}
		else{
			EndPage("Congratulations! You won!");
		}
	}

	public void EndPage(String message){
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
