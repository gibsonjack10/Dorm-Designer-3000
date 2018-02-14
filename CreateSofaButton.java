
public class CreateSofaButton {

	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	 
	private PApplet processing;
	private float[] position;
	private String label;
	 
	
	
	
	
	public CreateSofaButton(float x, float y, PApplet processing) {
		this.processing = processing;
		position = new float[2];
		position[0] = x;
		position[1] = y;
		label = new String("Create Sofa");
	}
	
	
	
	
	
	public void update() { 
		if (isMouseOver() == true) {
			processing.fill(100);
		} else {
			processing.fill(200);
		}
		processing.rect(position[0] - WIDTH/2, position[1] + HEIGHT/2, position[0] + WIDTH/2, position[1] - HEIGHT/2);
		
		processing.fill(0);
		processing.text(label, position[0], position[1]);
	}
	
	
	
	
	
	public Furniture mouseDown() {
		
	} // After step 10, this method will instead return Furniture	
	
	
	
	
	
	public boolean isMouseOver() {
		
	}	
}
