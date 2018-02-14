public class Main {

	private PApplet processing;
	private PImage backgroundImage;
	//	private PImage bedImage;    
	//	private float[][] bedPositions;
	//	private int dragFurnitureIndex;
	private Furniture[] furniture;
	private CreateBedButton bedButton;
	private CreateSofaButton sofaButton;

	public Main(PApplet processing) {
		this.processing = processing;
		backgroundImage = processing.loadImage("images/background.png");
		//bedImage = processing.loadImage("images/bed.png");
		bedButton = new CreateBedButton(50, 24, processing);
		sofaButton = new CreateSofaButton(150, 24, processing);
		furniture = new Furniture[6];
		for (int i=0; i<6; i++) {
			furniture[i] = null;
		}

		//		bedPositions = new float[6][2];
		//		for (int i=0; i<6; i++) {
		//			bedPositions[i] = null;
		//		}
		//		dragFurnitureIndex = -1;
	}

	public static void main(String[] args) {
		Utility.startApplication();
		//Main.bedPositions[0][0] = 1;
	}


	//	public void setup() {
	//		bedPositions = new float[6][2];
	//		dragFurnitureIndex = -1;
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
		bedButton.update();
		sofaButton.update();

		for (int i=0; i<6; i++) {
			if (furniture[i] != null) {
				furniture[i].update();

			}
		}

		//		for (int i=0; i<6; i++) {
		//			if (furniture[i] != null) {
		//				if (furniture[i].isMouseOver()) {
		//					furniture[i].mouseUp();
		//				}
		//				furniture[i].update();
		//				
		//			}
		//		}

		for (int i=0; i<6; i++) {
			if (furniture[i] != null) {
				//				processing.image(bedImage, processing.mouseX, processing.mouseY);
				//				bedPositions[dragFurnitureIndex][0] = processing.mouseX;
				//				bedPositions[dragFurnitureIndex][1] = processing.mouseY;
			}	
		}
	}		

	public void mouseDown() {
		for (int i=0; i<6; i++) {
			if (furniture[i] == null) {
				break;
			}
			else if(furniture[i].isMouseOver()) {
				furniture[i].mouseDown();
				break;
			}

		}
		for (int i=0; i<6; i++) {
			if (furniture[i] == null && bedButton.isMouseOver()) {
				bedButton.mouseDown();
				furniture[i] = new Furniture("bed", processing);
				break;
			}
		}
		for (int i=0; i<6; i++) {
			if (furniture[i] == null && sofaButton.isMouseOver()) {
				sofaButton.mouseDown();
				furniture[i] = new Furniture("sofa", processing);
				break;
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
		//				dragFurnitureIndex = i;
		//				break;
		//			} 		
		//		}	
		//	}
		//
	}
	public void mouseUp() {
		for (int i=0; i<6; i++) {
			if (furniture[i] == null) {
				break;
			}
			else {
				furniture[i].mouseUp();
			}
		}
		//		dragFurnitureIndex = -1;
	}

	public void keyPressed() {
//		if (processing.key == 'B' || processing.key == 'b') {
//
//			for (int i=0; i<6; i++) {
//				if (furniture[i] == null) {
//					furniture[i] = new Furniture(processing);
//					break;
//				}
//			}
//		}
		if(processing.key == 'D' || processing.key == 'd') {
			for (int i=0; i<6; i++) {
				if(furniture[i] != null) {
					if(furniture[i].isMouseOver()) {
						furniture[i] = null;
						break;
					}
				}

			}
		}
		else if(processing.key == 'R' || processing.key == 'r') {
			for (int i=0; i<6; i++) {
				if (furniture[i] != null) {
					if (furniture[i].isMouseOver()) {
						furniture[i].rotate();
						break;
					}
				}
			}

		}
	}



}
