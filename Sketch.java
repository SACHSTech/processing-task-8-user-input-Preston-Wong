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

  // all image variables 
  PImage imgGarden;
  PImage imgBlueFlower;
  PImage imgRedFlower;
  PImage imgTallRedFlower;
  PImage imgSpiderFlower;
  PImage imgCoinFlower;
  PImage imgSunFlower;

  // sun size and location variables 
  int intSunSizeX = 10;
  int intSunSizeY = 10;
  int intSunX = 0;
  int intSunY = 0;

  // variables that allow the user to adust different aspects of the sun 
  boolean upPressed = false;
  boolean downPressed = false;
  boolean rightPressed = false;
  boolean leftPressed = false;
  boolean WPressed = false;
  boolean DPressed = false;
  boolean SPressed = false;
  boolean APressed = false;

  // the string for the password 
  String Password = "";

  // is used to determine if the user has enterted into the garden area
  boolean Entered = false;

  public void setup() {
    // gives a black screen when they enter their password to allow the text to be more easily read 
    background(0);
    imgGarden = loadImage("_9895870b-c84b-4f5d-a437-99e18ed489df.jpg");
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
  
    // checks to see if the user has enterted the right password to enter the garden area 
    if (Password.equals("abcdef")) {
      
      Entered = true;

      image(imgGarden,0,0);

      fill(255, 223, 34);

      ellipse(intSunX,intSunY,intSunSizeX,intSunSizeY);

    // moues pressed variable 
    if (mousePressed) {

      // checks to see if the mouse is over the right most flower bed 
      if (mouseX > 600 && mouseY < 630 && mouseY > 500) {
          
        image(imgTallRedFlower, mouseX, mouseY - 150);

      // checks to see if the mouse is over 1 of the 4 middle flower beds 
      } else if ((mouseX >= 200 && mouseX < 400 && mouseY >= 500 && mouseY < 600) || (mouseX >= 400 && mouseX < 620 && mouseY >= 550 && mouseY < 700) 
      || (mouseX >= 620 && mouseX < 800 && mouseY >= 700 && mouseY < 750) || (mouseX >= 800 && mouseX < 930 && mouseY >= 700 && mouseY < 1000)) {
      
        image(imgCoinFlower, mouseX - 20, mouseY - 50);

      // checks to see if the mouse is over the left most flower bed 
      } else if (mouseX <= 450 && mouseY > 590 && mouseY <= height) {

        image(imgRedFlower, mouseX - 20, mouseY - 50);

      }
    } 

    // limits where the sun can be 
    if (intSunX > width) {

      intSunX = width;

    } else if (intSunX < 0) {

      intSunX = 0;

    } else if (intSunY > 50) {

      intSunY = 50;
      
    } else if (intSunY < 0) {

      intSunY = 0;
    }

    // limits the size of the sun
    if (intSunSizeX > 60) {
      
      intSunSizeX = 60;

    } else if (intSunSizeY > 60) {
      
      intSunSizeY = 60;

    } else if (intSunSizeY < -60) {

      intSunSizeY = -60;

    } else if (intSunSizeX < -60) {

      intSunSizeX =  -60;
    }

    // handling multiple keys 
    if (upPressed == true) {

      intSunSizeY += 2;

    } if (downPressed == true) {

      intSunSizeY -= 2;

    } if (leftPressed == true) {

      intSunSizeX -= 2;

    } if (rightPressed == true) {

      intSunSizeX += 2;
    }

    // key variable are used to change the location of the sun
    if (DPressed == true) {

      intSunX += 10;

    } if (SPressed == true) {

      intSunY += 10;

    } if  (APressed == true) {

        intSunX -= 10;

    } if  (WPressed == true) {

        intSunY -= 10;
    }
  
    } else  {

      // gives the prompt to the user that they need to enter in a password in order to proceed 
      fill(255);
      textSize(50);
      text("Password: " + Password, width / 5, height / 2);

    }
  }


  // is used to print a different kind of flower 
  public void mouseMoved() {
    if (Entered == true) {

      // checks if the mouse is pressed, so that 2 flower don't overlap each other 
      if (!mousePressed) {
       
        // checks if the moues is over the right most flower bed
        if (mouseX > 600 && mouseY < 630 && mouseY > 500) {
        
          image(imgBlueFlower, mouseX, mouseY - 150);

        // checks if the moues is over 1 of the 4 middle flower beds
        } else if ((mouseX >= 200 && mouseX < 400 && mouseY >= 500 && mouseY < 600) || (mouseX >= 400 && mouseX < 620 && mouseY >= 550 && mouseY < 700) 
        || (mouseX >= 620 && mouseX < 800 && mouseY >= 700 && mouseY < 750) || (mouseX >= 800 && mouseX < 930 && mouseY >= 700 && mouseY < 1000)) {
        
          image(imgSpiderFlower, mouseX - 20, mouseY - 50);

        // checks if the moues is over the left most flower bed 
        } else if (mouseX <= 450 && mouseY > 590 && mouseY <= height) {

          image(imgSunFlower, mouseX - 20, mouseY - 50);

        }
      }
    }
  }
   
  // is used to record the users input when they fill in the password 
  public void keyTyped() {

    // sees if the user has enterted into the garden area 
    if (Entered == false) {

      // allows the user to delete their entry if it is incorrect 
      if (key == BACKSPACE) {

        Password = "";
        background(0);

      } else {

        Password += key;

    }

    // turns this method off once the password has been entered 
    } else if (Entered == true) {
      
    }
  }

  // is used to detect it the user is holding down a specific key to adjust the sun 
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

  // used to know when the user has let go the key to stop adujsting the sun 
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
}