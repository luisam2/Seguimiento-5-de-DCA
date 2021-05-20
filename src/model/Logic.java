package model;

import java.util.ArrayList;


import exception.ValidateCompareException;
import processing.core.PApplet;

public class Logic {
	public ArrayList<ColorBar> colorBar;
	public Square square;
	public Circle circle;
	
	private int[] colors;
	private String[] colorNames;
	private int figureActual;
	private String error;

	public Logic(PApplet app) {
		colorBar = new ArrayList<ColorBar>();
		
		square = new Square(220, 120, 150, 255,1, "");
		circle = new Circle(500, 200, 160, 255,2, "");
		
		error = "";
		figureActual = 0;
		
		colors = new int [10];
		colors[0] = app.color(233, 0, 0);
		colors[1] = app.color(233, 113, 0);
		colors[2] = app.color(255, 216, 0);
		colors[3] = app.color(166, 255, 0);
		colors[4] = app.color(0, 255, 4);
		colors[5] = app.color(0, 255, 143);
		colors[6] = app.color(0, 236, 255);
		colors[7] = app.color(0, 81, 255);
		colors[8] = app.color(66, 0, 255);
		colors[9] = app.color(205, 0, 255);
		
		
		colorNames = new String [10];
		colorNames[0] = "Rojo";
		colorNames[1] = "Naranja";
		colorNames[2] = "Amarillo";
		colorNames[3] = "VerdeL";
		colorNames[4] = "Verde";
		colorNames[5] = "AguaMarina";
		colorNames[6] = "AzulCielo";
		colorNames[7] = "Azul";
		colorNames[8] = "Morado";
		colorNames[9] = "Fucsia";
		
	}

	public void drawRect(PApplet app) {
		square.drawSquare(app);
	}
	
	public void drawCircle(PApplet app) {
		circle.drawCircle(app);
	}
	
	public void drawColorBar(PApplet app) {
		for(int i=0;i<10;i++) {
			colorBar.add(new ColorBar((50*i)+150,app.height/2,50,colors[i],3, colorNames[i]));
			}
		
		for (int i = 0; i < colorBar.size(); i++) {
			ColorBar bar = colorBar.get(i);
			bar.drawColorBar(app);
		}
	}
	
	public void drawButton1(PApplet app) {
		app.fill(255);
		app.stroke(0);
		app.rect(230, 380, 150, 50, 10);
		
		app.fill(0);
		app.textSize(18);
		app.text("Comparar", 265, 410);
		
		if (app.mouseX > 230 && app.mouseX < 230 + 150 && app.mouseY > 380 && app.mouseY < 380 + 50) {
			app.fill(255, 191, 0);
			app.stroke(0);
			app.rect(230, 380, 150, 50, 10);
			
			app.fill(255);
			app.textSize(18);
			app.text("Comparar", 265, 410);
		}
	}
	
	public void drawButton2(PApplet app) {
		app.fill(255);
		app.stroke(0);
		app.rect(410, 380, 150, 50, 10);
		
		app.fill(0);
		app.textSize(18);
		app.text("Limpiar", 455, 410);
		
		if (app.mouseX > 410 && app.mouseX < 410 + 150 && app.mouseY > 380 && app.mouseY < 380 + 50) {
			app.fill(255, 191, 0);
			app.stroke(0);
			app.rect(410, 380, 150, 50, 10);
			
			app.fill(255);
			app.textSize(18);
			app.text("Limpiar", 455, 410);
		}
	}
	
	public void colorSquare(PApplet app) {
		if (app.mouseX > 220 && app.mouseX < 220 + 150 && app.mouseY > 120 && app.mouseY < 120 + 150) {
			figureActual = square.getId();
		}
	}
	
	public void changeColor (PApplet app) {
		int newColor = 0;
		for (int i = 0; i < colorBar.size(); i++) {
			ColorBar obj = colorBar.get(i);
			if (app.mouseX > obj.getPosX() && app.mouseX < obj.getPosX() + obj.getLength() && app.mouseY > obj.getPosY() && app.mouseY < obj.getPosY() + obj.getLength()) {
				newColor = obj.getColor();
				
				switch (figureActual) {
				case 1:
					square.setColor(newColor);
					square.setName(obj.getName());
					break;
				case 2:
					circle.setColor(newColor);
					circle.setName(obj.getName());
				break;
				}
			}
		}
	}
	
	public void colorCircle(PApplet app) {
		if(app.dist(app.mouseX, app.mouseY, 500, 200) < 80) {
			figureActual = circle.getId();
		}
	}

	public void validateCompare(PApplet app)  {
		if (app.mouseX > 230 && app.mouseX < 230 + 150 && app.mouseY > 380 && app.mouseY < 380 + 50) {
			try {
			nullColor();
			error = funCompare();
			} catch (Exception e) {
			error = e.getMessage();
			//e.printStackTrace();
			}
		}
	}
	
	public void text (PApplet app) {
		app.text(error, 150, 500);
	}
	
	public void nullColor() throws NullPointerException {
		if(square.getColor() == 255) {
			throw new NullPointerException("Error no se ha seleccionado ningún color para la figura"+square.getId());
		}
		
		if(circle.getColor() == 255) {
			throw new NullPointerException("Error no se ha seleccionado ningún color para la figura"+circle.getId());
		}
	}

	public void clicClean(PApplet app) {
		if (app.mouseX > 410 && app.mouseX < 410 + 150 && app.mouseY > 380 && app.mouseY < 380 + 50) {
			square.setColor(255);
			circle.setColor(255);
		}
	}

	public String funCompare() throws ValidateCompareException {
		if (square.getColor() == circle.getColor()) {
			return "Los colores de las figuras son iguales "+square.getId()+square.getName()+" y "+circle.getId()+circle.getName();
		}else {
			throw new ValidateCompareException("Los colores de las figuras no son iguales "+square.getId()+square.getName()+" y "+circle.getId()+circle.getName());
		}
	}
	
	public void setError(String error) {
		 this.error = error;
	}
}
