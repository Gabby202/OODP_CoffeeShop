
public abstract class Tea {
	private String name, image;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void displayTea() {
		System.out.println("" + getName());
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	 

}
