/**
 * (This class creates Furniture objects.)
 *
 * <p>Bugs: (no known bugs)
 *
 * @author (Bennett Majerowski and John Gibson)
 */
public class Furniture {

	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations;
	private String type;
	
	public Furniture(String type, PApplet processing) {
		this.type = type;
		this.processing = processing;
		image = processing.loadImage("images/" + type + ".png");
		position = new float[2];
		position[0] = processing.width/2;
		position[1] = processing.height/2;
		isDragging = false;
		rotations = 0;
		
	}
	
	/**
	 * (Update changes the position of the bed or sofa objects and prints them)
	 */
	public void update() { 
		if (isDragging == true) {
			position[0] = processing.mouseX;
			position[1] = processing.mouseY;
			processing.image(image, position[0], position[1], rotations*PApplet.PI/2);
		} else {
			processing.image(image, position[0], position[1], rotations*PApplet.PI/2);
		}
	}
	
	/**
	 * (MouseDown allows Update to move the furniture when the mouse is clicked)
	 */
	public void mouseDown() {
		if (isMouseOver() == true);
			isDragging = true;
	}
	
	/**
	 * (MouseUp identifies when the furniture should no longer be moved.)
	 */
	public void mouseUp() {
		isDragging = false;
	}
	
	/**
	 * (isMouseOver is a helper method that identifies when the mouse is 
	 * over one of the furniture objects. No alterations to the furniture can
	 * occur unless this method returns true.)
	 */
	public boolean isMouseOver() {
		if (rotations % 2 == 0) {
			if (processing.mouseX > position[0] - image.width/2 && 
					processing.mouseX < position[0] + image.width/2 &&
					processing.mouseY > position[1] - image.height/2 &&
					processing.mouseY < position[1] + image.height/2) {
				return true;
			}
		} else if (processing.mouseX > position[0] - image.height/2 && 
					processing.mouseX < position[0] + image.height/2 &&
					processing.mouseY > position[1] - image.width/2 &&
					processing.mouseY < position[1] + image.width/2) {
				return true;
		}
		
		return false;	
	}
	
	/**
	 * (rotate is a counter that increases by one every time the user input
	 * specifies that the furniture should rotate. It is referred to in update.)
	 */
	public void rotate() {
		rotations++;
	}

	
}
