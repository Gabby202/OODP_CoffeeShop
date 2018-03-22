
public class Coffee {
	
	private String milk, name, espresso, imageurl;
	
	
	public Coffee(String name, String espresso, String milk, String imageurl){
		this.name = name;
		this.milk = milk;
		this.espresso = espresso;
		this.imageurl = imageurl;
	}

	public String getMilk() {
		return milk;
	}



	public void setMilk(String milk) {
		this.milk = milk;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getEspresso() {
		return espresso;
	}

	public void setEspresso(String espresso) {
		this.espresso = espresso;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}



}
