
public class Dog{
	public int weightInPounds;
	public static String binomen = "doggy";

	/** one integer constructor for dogs. */
	public Dog(int w) {
		weightInPounds = w;
	}
	
	/**Instance method or non-static method for Dog */
	public void makeNoise() {
		if (weightInPounds < 10) 
			System.out.println("yipyipyip");
		else if (weightInPounds < 30)
			System.out.println("bark. bark.");
		else
			System.out.println("woof!");
	}

	public static Dog higher(Dog d1, Dog d2) {
		if (d1.weightInPounds > d2.weightInPounds) {
			return d1;
		}
		return d2;
	}

	public Dog higherNonStatic(Dog d2) {
		if (this.weightInPounds > d2.weightInPounds) {
			return this;
		}
		return d2;
	}
}
