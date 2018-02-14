public class Main {

	private PApplet processing;
	private PImage backgroundImage;
//	private PImage bedImage;    
//	private float[][] bedPositions;
//	private int dragBedIndex;
	private Bed[] beds;

	public Main(PApplet processing) {
		this.processing = processing;
		backgroundImage = processing.loadImage("images/background.png");
		//bedImage = processing.loadImage("images/bed.png");

		beds = new Bed[6];
		for (int i=0; i<6; i++) {
			beds[i] = null;
		}

//		bedPositions = new float[6][2];
//		for (int i=0; i<6; i++) {
//			bedPositions[i] = null;
//		}
//		dragBedIndex = -1;
		System.out.println("Press the \"B\" key to create a new bed");
	}

	public static void main(String[] args) {
		Utility.startApplication();
		//Main.bedPositions[0][0] = 1;
	}


	//	public void setup() {
	//		bedPositions = new float[6][2];
	//		dragBedIndex = -1;
	//		bedImage = processing.loadImage("images/bed.png");
	//		
	//		for (int i=0; i<6; i++) {
	//			bedPositions[i] = null;
	//		}
	//		
	//		backgroundImage = processing.loadImage("images/background.png");
	//		System.out.println("Press the \"B\" key to create a new bed");
	//	}

	public void update() {
		processing.background(100,150,250);
		processing.image(backgroundImage, processing.width/2, processing.height/2);


		for (int i=0; i<6; i++) {
			if (beds[i] != null) {
				beds[i].update();
				
			}
		}
		
//		for (int i=0; i<6; i++) {
//			if (beds[i] != null) {
//				if (beds[i].isMouseOver()) {
//					beds[i].mouseUp();
//				}
//				beds[i].update();
//				
//			}
//		}

		for (int i=0; i<6; i++) {
			if (beds[i] != null) {
//				processing.image(bedImage, processing.mouseX, processing.mouseY);
//				bedPositions[dragBedIndex][0] = processing.mouseX;
//				bedPositions[dragBedIndex][1] = processing.mouseY;
			}	
		}
	}		

	public void mouseDown() {
		for (int i=0; i<6; i++) {
			if (beds[i] == null) {
				break;
			}
			else if(beds[i].isMouseOver()) {
				beds[i].mouseDown();
			}
			
		}
//		for (int i=0; i<6; i++) {
//			if (bedPositions[i] == null) {
//				break;
//			}
//			if (processing.mouseX > bedPositions[i][0] - bedImage.width/2 && 
//					processing.mouseX < bedPositions[i][0] + bedImage.width/2 &&
//					processing.mouseY > bedPositions[i][1] - bedImage.height/2 &&
//					processing.mouseY < bedPositions[i][1] + bedImage.height/2) {
//				dragBedIndex = i;
//				break;
//			} 		
//		}	
//	}
//
	}
	public void mouseUp() {
		for (int i=0; i<6; i++) {
			if (beds[i] == null) {
				break;
			}
			else {
				beds[i].mouseUp();
			}
		}
//		dragBedIndex = -1;
	}

	public void keyPressed() {
		if (processing.key == 'B' || processing.key == 'b') {

			for (int i=0; i<6; i++) {
				if (beds[i] == null) {
					beds[i] = new Bed(processing);
					beds[i].getMouseOver();
					break;
				}
			}
		}
	}

	

}