import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1000, 900);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */

  PImage imgGarden;
  PImage imgBlueFlower;
  PImage imgRedFlower;
  PImage imgTallRedFlower;
  PImage imgSpiderFlower;
  PImage imgCoinFlower;
  PImage imgSunFlower;

  int intSizeX = 0;
  int intSizeY = 0;
  int intX = 0;
  int intY = 0;

  boolean upPressed = false;
  boolean dragging = false;
  boolean downPressed = false;
  boolean rightPressed = false;
  boolean leftPressed = false;
  boolean WPressed = false;
  boolean DPressed = false;
  boolean SPressed = false;
  boolean APressed = false;
  boolean MouseWheelUp = false;
  Boolean MouseWheelDown = false;


  String Password = "";

  boolean Entered = false;

  public void setup() {
    background(0);
    imgGarden = loadImage ("_9895870b-c84b-4f5d-a437-99e18ed489df.jpg");
    imgBlueFlower = loadImage("blue_flower-removebg-preview.png");
    imgRedFlower = loadImage("red_flower-removebg-preview.png");
    imgTallRedFlower = loadImage("tall_red_flower-removebg-preview.png");
    imgSpiderFlower = loadImage("spider_flower-removebg-preview.png");
    imgCoinFlower = loadImage("coin_flower-removebg-preview.png");
    imgSunFlower = loadImage("sunflower-removebg-preview.png");
  
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
  
    if (Password.equals("abcdef")) {
      
      Entered = true;

      image(imgGarden,0,0);

      fill(255, 223, 34);
      ellipse(intX,intY,intSizeX,intSizeY);

    // moues pressed variable 
    if (mousePressed) {
       if (mouseX > 600 && mouseY < 650 && mouseY > 500) {
        image(imgTallRedFlower, mouseX, mouseY - 150);
      }
    } 

  // limits where the sun can be 
  if (intX > width) {
    intX = width;
  } else if (intX < 0) {
    intX = 0;
  } else if (intY > 50) {
    intY = 50;
  } else if (intY < 0) {
    intY = 0;
  }

  // limits the size of the sun
  if (intSizeX > 40) {
    intSizeX = 40;
  } else if (intSizeY > 40) {
    intSizeY = 40;
  } else if (intSizeY < -40) {
    intSizeY = -40;
  } else if (intSizeX < -40) {
    intSizeX =  -40;
  }

  // handling multiple keys 
  if (upPressed == true) {
    intSizeY += 2;
  } if (downPressed == true) {
    intSizeY -= 2;
  } if (leftPressed == true) {
    intSizeX -= 2;
  } if (rightPressed == true) {
    intSizeX += 2;
  }

  // key variable are used to change the location of the sun
  if (DPressed == true) {
    intX += 10;

  } if (SPressed == true) {
    intY += 10;

  } if  (APressed == true) {
      intX -= 10;

  } if  (WPressed == true) {
      intY -= 10;
  }

 
    } else  {

      fill(255);
      text(Password, width / 2, height / 2);

    }
}


public void mouseMoved() {
  if (Entered == true) {
    // moues pressed variable 
       if (mouseX > 600 && mouseY < 650 && mouseY > 500) {
        
        image(imgBlueFlower, mouseX, mouseY - 150);
      } 
    } else {
      
    }
}
    
public void keyTyped() {

  if (Entered == false) {

      if (key == BACKSPACE) {

        Password = "";
        background(0);

    } else {

      Password += key;

    }

  } else if (Entered == true) {
    
  }
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

      } else if (key == 'w' || key =='W') {

        WPressed = true;

      } else if (key == 'd' || key == 'D') {

        DPressed = true;

      } else if (key == 's' || key== 'S') {

        SPressed = true;

      } else if (key == 'a' || key == 'A') {

        APressed = true;

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

      } else if (key == 'w' || key =='W') {

        WPressed = false;

      } else if (key == 'd' || key == 'D') {

        DPressed = false;

      } else if (key == 's' || key== 'S') {

        SPressed = false;

      } else if (key == 'a' || key == 'A') {

        APressed = false;
  }
}


  // define other methods down here.
}