public class Mocha implements CoffeeFactory{

	@Override
	public Coffee getSkinny() {
		// TODO Auto-generated method stub
		return new Coffee("Skinny Mocha", "regular espresso", "Low fat milk, chocolate syroup", "images/skinnyMocha.jpg");
	}

	@Override
	public Coffee getSoy() {
		// TODO Auto-generated method stub
		return new Coffee("Soy Mocha", "regular espresso", "Soy milk, chocolate syroup", "images/soyMocha.jpg");
	}

	@Override
	public Coffee getDecaff() {
		// TODO Auto-generated method stub
		return new Coffee("Decaf Mocha", "decaff espresso", "Full fat milk, chocolate syroup", "images/decaffMocha.jpg");
	}

}
