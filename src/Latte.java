
public class Latte implements CoffeeFactory{

	@Override
	public Coffee getSkinny() {
		// TODO Auto-generated method stub
		return new Coffee("Skinny Latte", "regular espresso", "Low fat milk", "images/skinnyLatte.jpg");
	}

	@Override
	public Coffee getSoy() {
		// TODO Auto-generated method stub
		return new Coffee("Soy Latte", "regular espresso", "Soy milk", "images/soyLatte.jpg");
	}

	@Override
	public Coffee getDecaff() {
		// TODO Auto-generated method stub
		return new Coffee("Decaf Latte", "decaff espresso", "Full fat milk", "images/decaffLatte.jpg");
	}

}
