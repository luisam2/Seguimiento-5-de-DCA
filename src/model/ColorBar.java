package model;

import processing.core.PApplet;

public class ColorBar extends Figure{
	
	private int length;
	private int r,g,b;

	public ColorBar(int posX, int posY,int length,int color,int id, String name) {
		super(posX,posY,color,id, name);
		this.length = length;
	}
	
	public void drawColorBar(PApplet app) {
		app.fill(color);
		app.noStroke();
		app.rect(posX,posY,length, length);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int validateClic(PApplet app) {
		int colorActual = 0;
		if (app.mouseX > posX && app.mouseX < posX + length && app.mouseY > posY && app.mouseY < posY + length) {
			colorActual = color;
		}
		return colorActual;
	}
}
