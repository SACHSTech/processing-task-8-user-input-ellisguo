import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  float greenX = 200;
  float greenY = 200;
  String message = "";
  
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  float circleX = 150;
  float circleY = 150;

  
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // small flowers
	  float flowerSize = 20;
    if (mousePressed) {
      flower(mouseX, mouseY, flowerSize, 0);
    }

    // green snake
    if (keyPressed) {
      
      if (keyCode == UP) {
        greenY--;
      } else 
      if (keyCode == DOWN) {
        greenY++;
      } else
      if (keyCode == LEFT) {
        greenX--;
      } else
      if (keyCode == RIGHT) {
        greenX++;
      }
      
      // custom text
      textSize(50);
      fill(255);
      text(key,mouseX,mouseY);
      fill(0,128,0);
      
      // green snake 
      ellipse(greenX, greenY, 50, 50);

      // standard text
      text(message, 25, 100);
    }

    // yellow snake
    if (upPressed) {
    circleY--;
    }
    if (downPressed) {
      circleY++;
    }
    if (leftPressed) {
      circleX--;
    }
    if (rightPressed) {
      circleX++;
    }
    fill(249,215,28);
    ellipse(circleX, circleY, 50, 50);
  }

  // yellow snake controls
  public void keyPressed() {
    if (keyCode == TAB) {
      upPressed = true;
    }
    else if (keyCode == CONTROL) {
      downPressed = true;
    }
    else if (keyCode == SHIFT) {
      leftPressed = true;
    }
    else if (keyCode == ALT) {
      rightPressed = true;
    }
  }

  // yellow snake controls 
  public void keyReleased() {
    if (keyCode == TAB) {
      upPressed = false;
    }
    else if (keyCode == CONTROL) {
      downPressed = false;
    }
    else if (keyCode == SHIFT) {
      leftPressed = false;
    }
    else if (keyCode == ALT) {
      rightPressed = false;
    }
  }

  // standard message
  public void keyTyped() {
    message += key;
  }

  // big flowers
  public void mouseClicked() {
    flower(mouseX, mouseY, 30, 30);
  }

  // flower shapes, the method
  public void flower(float flowerX, float flowerY, float petalSize, float colour)  {

    float petalDistance = petalSize/2;

    fill(255, 128, colour);

    // upper-left petal
    ellipse(flowerX - petalDistance, flowerY - petalDistance, 
    petalSize, petalSize);

    // upper-right petal
    ellipse(flowerX + petalDistance, flowerY - petalDistance, 
    petalSize, petalSize);

    // lower-left petal
    ellipse(flowerX - petalDistance, flowerY + petalDistance, 
    petalSize, petalSize);

    // lower-right petal
    ellipse(flowerX + petalDistance, flowerY + petalDistance, 
    petalSize, petalSize);

    // center petal
    fill(255, colour, colour);
    ellipse(flowerX, flowerY, 
    petalSize, petalSize);
  }
  
  // define other methods down here.
}