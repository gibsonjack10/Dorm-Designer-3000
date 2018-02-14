///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Dorm Designer 3000)
// Files:            (N/A)
// Semester:         (CS 300) Spring 2018
//
// Author:           (Bennett Majerowski)
// Email:            (majerowski@wisc.edu)
// Lecturer's Name:  (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     (John gibson)
// Email:            (jdgibson@wisc.edu)
// Lecturer's Name:  (Gary Dahl)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide ////////////////////////////////// 

/**
 * (This class opens a window in which the user can design
 *  a dorm room layout. They can create, rotate and delete
 *  beds and sofas.)
 *
 * <p>Bugs: (no known bugs)
 *
 * @author (Bennett Majerowski and John Gibson)
 */
public class Main {
	
	/**
	 * (Fields of Main)
	 */
	private PApplet processing;
	private PImage backgroundImage;
	private Furniture[] furniture;
	private CreateBedButton bedButton;
	private CreateSofaButton sofaButton;
	
	/**
	 * (Constructor of Main)
	 */
	public Main(PApplet processing) {
		this.processing = processing;
		backgroundImage = processing.loadImage("images/background.png");
		bedButton = new CreateBedButton(50, 24, processing);
		sofaButton = new CreateSofaButton(150, 24, processing);
		furniture = new Furniture[6];
		for (int i=0; i<6; i++) {
			furniture[i] = null;
		}
	}

	/**
	 * (Main starts the application and runs it from the .jar file)
	 */
	public static void main(String[] args) {
		Utility.startApplication();
	}

	/**
	 * (Update runs repeatedly and checks for user input. It calls the other classes to
	 * save those changes.)
	 */
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
	}		

	/**
	 * (Called when the mouse is pressed down and checks to see if the mouse 
	 * has clicked on an object. If it does it moves the center of the 
	 * bed or sofa to the mouses position or creates a bed or sofa if the mouse
	 * has clicked on a create button.)
	 */	
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
	}
	
	/**
	 * (Called after the mouse button is released and it further calls
	 * the the mouseUp method for the desired furniture object to make
	 * the bed stay where it is release.)
	 */
	public void mouseUp() {
		for (int i=0; i<6; i++) {
			if (furniture[i] == null) {
				break;
			}
			else {
				furniture[i].mouseUp();
			}
		}
	}

	/**
	 * (Checks any keys pressed by the user and, if it is one of 'd' or 'r',
	 * calls the furniture class to delete or rotate that furniture object)
	 */
	public void keyPressed() {
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
