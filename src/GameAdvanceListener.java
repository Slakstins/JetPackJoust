import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAdvanceListener implements ActionListener {

	private ScreenComponent screenComponent;
	private double time;

	public GameAdvanceListener(ScreenComponent screenComponent) {
		this.screenComponent = screenComponent;
		this.time = 0;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		advanceOneTick();
		// TODO Auto-generated method stub

	}

	public void advanceOneTick() {
		// The component uses user actions from listeners
		// to change the state of the game.
		// update screen
		
		screenComponent.updateIsPaused();

		this.time++;
		this.screenComponent.updateDraw();
		if (this.time % 60 == 0) {
			if (this.screenComponent.getIsPaused() == false ) {
				if ( this.screenComponent.getLevel() < 20) {
					screenComponent.addSecond();
				}
				screenComponent.lowerComboTimer();
			}
		}

	}

}
