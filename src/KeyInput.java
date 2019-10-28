import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyInput extends KeyAdapter {
	private HashMap<String, Boolean> keyMap;
	private ScreenComponent screenComponent;
	
	public KeyInput() {
		this.keyMap = new HashMap<String, Boolean>();
		keyMap.put("left", false);
		keyMap.put("right", false);
		keyMap.put("up", false);
		keyMap.put("down", false);
		
	}
	
	
	public HashMap<String, Boolean> getKeyMap(){
		return keyMap;
	}
	public void setScreenComponent(ScreenComponent screenComponent) {
		this.screenComponent = screenComponent;
	}
	
	public void updatePaint() {
		this.screenComponent.repaint();
		
	}
	
	 @Override
     public void keyPressed(KeyEvent event) {
         int keyCode = event.getKeyCode();
        
         if (keyCode == event.VK_LEFT) {
        	 keyMap.put("left", true);
             System.out.println("leftpressed!");
             this.updatePaint();
             
         }
         if (keyCode == event.VK_RIGHT){
        	 keyMap.put("right", true);
         
        	 System.out.println("rightpressed!");
         }
         if (keyCode == event.VK_UP){
        	 keyMap.put("up", true);
         
        	 System.out.println("uppressed!");
        	
         }
         if (keyCode == event.VK_DOWN){
        	 keyMap.put("down", true);
         
        	 System.out.println("downpressed!");
         }
         if (keyCode == event.VK_U) {
        	 
         }
         
     }
	 @Override
     public void keyReleased(KeyEvent event) {
         int keyCode = event.getKeyCode();
         if (keyCode == event.VK_LEFT) {
        	 keyMap.put("left", false);
         }
         if (keyCode == event.VK_RIGHT){
        	 keyMap.put("right", false);
         
        	
         }
         if (keyCode == event.VK_UP){
        	 keyMap.put("up", false);
        	 
         }
         if (keyCode == event.VK_DOWN){
        	 keyMap.put("down", false);
         }
     }


	
}



