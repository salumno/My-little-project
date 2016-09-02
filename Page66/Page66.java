
/*

*/

class Dog {
	int size;
	String breed;
	String name;
	
	void bark() {
		System.out.println ("Гав! Гав!");
	}
}

class DogTestDrive {
	public static void main (String[] args) {
		Dog d = new Dog();
		d.size = 40;
		d.bark();
		System.out.println("Размер собачки = " + d.size);
		Dog g  = new Dog();
		g.size = 7;
		g.breed = "Dvornyaga";
		g.name = "Hvostic"; 
	}
}
