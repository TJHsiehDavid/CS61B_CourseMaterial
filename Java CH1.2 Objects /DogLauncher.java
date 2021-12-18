
public class DogLauncher{
	public static void main (String[] args) {
		Dog dog = new Dog(51);
		dog.weightInPounds = 20;
		dog.makeNoise();
		
		/**Use array to create object */
		Dog[] dogs = new Dog[2];
		dogs[0] = new Dog(8);
		dogs[1] = new Dog(20);
		dogs[0].makeNoise();
		dogs[0].weightInPounds = 20;
		dogs[0].makeNoise();

		/**Static and non-static 
		1.Static is using class method like: each dog are the same kind of speice
		2.Non-static is using instance method like: each dog have their height or color.
		*/
		Dog d1 = new Dog(51);
		Dog d2 = new Dog(20);
		Dog higher = Dog.higher(d1, d2);
		higher.makeNoise();

		Dog bigger = d1.higherNonStatic(d2);
		bigger.makeNoise();
		
		System.out.println(Dog.binomen);
	}
}
