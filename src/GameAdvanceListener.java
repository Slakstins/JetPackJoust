import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAdvanceListener implements ActionListener {
	
	private ScreenComponent screenComponent;

	
	public GameAdvanceListener(ScreenComponent screenComponent) {
		this.screenComponent = screenComponent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		advanceOneTick();
		// TODO Auto-generated method stub
		
	}
	public void advanceOneTick() {
		System.out.println("Current time " + System.currentTimeMillis());
		// The component uses user actions from listeners
		// to change the state of the game.

		// update screen
		this.screenComponent.updateState();
		this.screenComponent.drawScreen();
	}

}
