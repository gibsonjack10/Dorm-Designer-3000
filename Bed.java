public class Bed {

	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	
	// initializes the fields of a new bed object positioned in the center of the display
	public Bed(PApplet processing) {
		this.processing = processing;
		image = processing.loadImage("images/bed.png");
		position = new float[2];
		position[0] = processing.width/2;
		position[1] = processing.height/2;
		
		
	}
	
	
	// draws this bed at its current position
	public void update() { 
		
		//processing.image(image, position[0], position[1]);
		
		
		if (isDragging == true) {
			position[0] = processing.mouseX;
			position[1] = processing.mouseY;
			processing.image(image, position[0], position[1]);
//			position[0] = processing.mouseX;
//			position[1] = processing.mouseY;`bb
		}
		else {
			processing.image(image, position[0], position[1]);
		}
	}
	
	// used to start dragging the bed, when the mouse is over this bed when it is pressed
	public void mouseDown() {
		if (isMouseOver() == true); {
			isDragging = true;
		}
		
	}
	
	// used to indicate that the bed is no longer being dragged
	public void mouseUp() {
		isDragging = false;
	}
	
	// helper method to determine whether the mouse is currently over this bed
	public boolean isMouseOver() {
		
		if (processing.mouseX > position[0] - image.width/2 && 
				processing.mouseX < position[0] + image.width/2 &&
				processing.mouseY > position[1] - image.height/2 &&
				processing.mouseY < position[1] + image.height/2) {
			return true;
		} 	
		return false;
		
	}
	
	public void getMouseOver() {
		System.out.println(isMouseOver());
		System.out.println(isDragging);
	}

}