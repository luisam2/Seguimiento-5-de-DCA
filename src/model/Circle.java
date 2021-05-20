package model;

import processing.core.PApplet;

public class Circle extends Figure{
	
	private int radius;

	public Circle(int posX, int posY, int radius,int color, int id, String name) {
		super(posX,posY,color, id, name);
		this.radius = radius;
	}
	
	public void drawCircle(PApplet app) {
		app.fill(color);
		app.stroke(0);
		app.ellipse(posX, posY, radius, radius);
		app.fill(0);
		app.text("Figura 2", posX-30, posY+8);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
