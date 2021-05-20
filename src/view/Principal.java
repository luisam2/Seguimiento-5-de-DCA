package view;

import controller.Control;
import processing.core.PApplet;

public class Principal extends PApplet{

	private Control control;
	
	public static void main(String[] args) {
		PApplet.main(Principal.class.getName());
	}

	@Override
	public void settings() {
		size(800,600);
	}
	
	@Override
	public void setup() {
		control = new Control(this);
	}
	
	@Override
	public void draw() {
		background(255);

		control.drawRect(this);
		control.drawCircle(this);
		
		control.drawColorBar(this);
		control.drawButton1(this);
		control.drawButton2(this);
		
		control.text(this);
	}
	
	@Override
	public void mousePressed() {
		control.clearError();
		
		control.colorSquare(this);
		control.colorCircle(this);
		
		control.validateCompare(this);
		control.clicClean(this);

		control.changeColor(this);
	}

}
