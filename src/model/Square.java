package model;

import processing.core.PApplet;

public class Square extends Figure{
	
	private int length;

	public Square(int posX, int posY, int length,int color, int id, String name) {
		super(posX,posY,color,id, name);
		this.length = length;
	}
	
	public void drawSquare(PApplet app) {
		app.fill(color);
		app.stroke(0);
		app.rect(posX,posY,length, length);
		app.fill(0);
		app.text("Figura 1", posX+40, posY+80);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
