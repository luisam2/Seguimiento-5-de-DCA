package controller;

import exception.ValidateCompareException;
import model.Logic;
import processing.core.PApplet;

public class Control {

	public Logic logic;
	
	public Control(PApplet app) {
		logic = new Logic(app);
	}
	
	public void drawRect(PApplet app) {
		logic.drawRect(app);
	}
	
	public void drawCircle(PApplet app) {
		logic.drawCircle(app);
	}
	
	public void drawColorBar(PApplet app) {
		logic.drawColorBar(app);
	}
	
	public void colorSquare(PApplet app) {
		logic.colorSquare(app);
	}
	
	public void colorCircle(PApplet app) {
		logic.colorCircle(app);
	}
	
	public void drawButton1(PApplet app) {
		logic.drawButton1(app);
	}
	
	public void drawButton2(PApplet app) {
		logic.drawButton2(app);
	}
	
	public void validateCompare(PApplet app) {
		logic.validateCompare(app);
	}
	
	public void clicClean(PApplet app) {
		logic.clicClean(app);
	}
	
	public void changeColor(PApplet app) {
		logic.changeColor(app);
	}
	
	public void clearError() {
		logic.setError("");
	}
	
	public void funCompare() throws ValidateCompareException {
		logic.funCompare();
	}
	
	public void nullColor() {
		logic.nullColor();
	}
	
	public void text(PApplet app) {
		logic.text(app);
	}
}
