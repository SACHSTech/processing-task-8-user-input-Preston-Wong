import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */


  int intSizeX = 0;
  int intSizeY = 0;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean rightPressed = false;
  boolean leftPressed = false;

  public void setup() {

    background(0);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    // moues pressed variable 
    if (mousePressed) {
      background(0);
    } else {
      background(255);
    }

    // moue location 
    if (mouseX <= 200 && mouseY <= 200) {
      fill(255,0,255);
      ellipse(mouseX,mouseY,intSizeX,intSizeY);
    }

    // handling multiple keys 
    if (upPressed == true) {
    intSizeY += 2;
    } else if (downPressed == true) {
      intSizeY -= 2;
    } else if (leftPressed == true) {
      intSizeX -= 2;
    } else if (rightPressed == true) {
      intSizeX += 2;
    }
    
    // key pressed variable 
    if (keyPressed) {

        // key variable 
        if (key == 'd' || key == 'D') {
          fill(0,255,255);
          rect(mouseX,mouseY,mouseX + 10, mouseY + 10);

      } else if (key == 's' || key == 'S') {
          fill(190,222,0);
          rect(mouseX,mouseY,mouseX + 10, mouseY + 10);

      } else if  (key == 'a' || key == 'A') {
          fill(90,10,0);
          rect(mouseX,mouseY,mouseX + 10, mouseY + 10);

      } else if  (key == 'w' || key == 'W') {
          fill(0,0,9);
          rect(mouseX,mouseY,mouseX + 10, mouseY + 10);

      }

  }    

}
  

  // mouse event 
  public void mouseDragged() {
    fill(180,180,180);
    ellipse(mouseX,mouseY,20,20);
  }

public void mouseClicked() {
  fill(200,200,200);
  ellipse(mouseX,mouseY,20,20);
}

  // key event
  public void keyPressed() {
    // key code variable 
    if (keyPressed) {

      if (keyCode == UP) {
        upPressed = true;
      } else if (keyCode == DOWN) {
        downPressed = true;
      } else if (keyCode == RIGHT) {
        rightPressed = true;
      } else if (keyCode == LEFT) {
        leftPressed = true;
      }
    }
  }

  public void keyReleased() {

      if (keyCode == UP) {
        upPressed = false;
      } else if (keyCode == DOWN) {
        downPressed = false;
      } else if (keyCode == RIGHT) {
        rightPressed = false;
      } else if (keyCode == LEFT) {
        leftPressed = false;
      }
  }

  // define other methods down here.
}