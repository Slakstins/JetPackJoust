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
		this.keyMap.put("left", false);
		this.keyMap.put("right", false);
		this.keyMap.put("up", false);
		this.keyMap.put("down", false);
		
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
        	 this.keyMap.put("left", true);
             System.out.println("leftpressed!");
             this.updatePaint();
             
         }
         if (keyCode == event.VK_RIGHT){
        	 this.keyMap.put("right", true);
         
        	 System.out.println("rightpressed!");
        	 this.updatePaint();
         }
         if (keyCode == event.VK_UP){
        	 this.keyMap.put("up", true);
         
        	 System.out.println("uppressed!");
        	 this.updatePaint();
        	
         }
         if (keyCode == event.VK_DOWN){
        	 this.keyMap.put("down", true);
         
        	 System.out.println("downpressed!");
        	 this.updatePaint();
         }
         if (keyCode == event.VK_U) {
        	 
         }
         
     }
	 @Override
     public void keyReleased(KeyEvent event) {
         int keyCode = event.getKeyCode();
         if (keyCode == event.VK_LEFT) {
        	 this.keyMap.put("left", false);
         }
         if (keyCode == event.VK_RIGHT){
        	 this.keyMap.put("right", false);
         
        	
         }
         if (keyCode == event.VK_UP){
        	 this.keyMap.put("up", false);
        	 
         }
         if (keyCode == event.VK_DOWN){
        	 this.keyMap.put("down", false);
         }
     }


	
}


