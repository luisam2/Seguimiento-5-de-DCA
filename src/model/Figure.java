package model;

public abstract class Figure {
	
	public final static String[] FIGURAS = {"Cuad","Circ"}; 
	
	protected int posX;
	protected int posY;
	protected int color;
	protected int id;
	protected String name;
	
	public Figure( int posX, int posY,int color, int id, String name) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void draw() {
		
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
