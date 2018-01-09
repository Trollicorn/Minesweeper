import javax.swing.*;
import java.awt.event.*;

public class MineListener extends MouseAdapter{

	private MineButton myButton;

	public MineListener(MineButton button){
		myButton = button;
	}

	public void mouseClicked(MouseEvent click){
		if (myButton.isCovered()){
			if (SwingUtilities.isLeftMouseButton(click)){
				myButton.uncover();
			}
			if (SwingUtilities.isRightMouseButton(click)){
				myButton.flag();
			}
		}
	}


}