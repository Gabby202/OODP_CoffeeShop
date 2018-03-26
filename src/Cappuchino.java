public class Cappuchino implements CoffeeFactory{

	AdapterCappuchino capp = new AdapterCappuchino();
	@Override
	public Coffee getSkinny() {
		return capp.getSkinnyCapp();
		
	}

	@Override
	public Coffee getSoy() {
		// TODO Auto-generated method stub
		return capp.getSoyCapp();
	}

	@Override
	public Coffee getDecaff() {
		// TODO Auto-generated method stub
		return capp.getDecaffCapp();
	}

}

