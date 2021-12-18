
public class mystery_of_Walrus {
	public int height;
	public double weight;

	public mystery_of_Walrus(int h, double w) {
		height = h;
		weight = w;
	}

	public static void doStuff(mystery_of_Walrus W, int x) {
		W.height = 800;
		x = x - 5;
	}

	public static void main(String[] args) {
		mystery_of_Walrus Walrus_a = new mystery_of_Walrus(1000, 8.3);
		mystery_of_Walrus Walrus_b;

		Walrus_b = Walrus_a;
		Walrus_b.height = 500;
		/**
		 * 1.Walrus_b is an address which not save to the memory.
		 * 2.Walrus_a is equal to Walrus_b that is Walrus_b is point to the Walrus_a's memory(object).
		 * 3.They both means the same object, so modify one of them will change the value they point to.
		 * 4.Walrus_b change value so as Walrus_a will change as well, since they point to the same object.
		 * 
		 * Walrus_a(64 bits)--->口口口...口=(int(32 bits) + double(64 bits)) = 96 bits
		 * Walrus_b(64 bits)----^ 
		 * 
		 * Walrus_a ---> |-----------------|
		 * 	(64 bits)	 |	height = 1000  |
		 * 				 |-----------------| (Walrus_a instance)
		 * 				 |	weight = 8.3   | Totally will store 
		 * 				 |-----------------|	
		 * 					  (96 bits)
		 * Walrus_b |null   
		 *(64 bits) -----   (if not use new to allocate the memory)
		 * 
		 * When we declare a variable of "any reference type" (Walrus, Dog, Planet, array, etc.), 
		 * Java allocates a box of 64 bits, no matter what type of object. That is the address
		 * we stored is 64 bits (64 bits hold the box of address) and 96 bits of Walrus we need
		 * to know.
		 * */

		System.out.println(Walrus_a.height);

		int x = 10;
		doStuff(Walrus_a, x);
		/**
		 * 1.Walrus_a is a "reference type", so where it calls will change the value.
		 * 2. By contrast, the x is a parameter, so it cannot change outside the function.
		 * */

		System.out.println(Walrus_a.height);
		System.out.println(x);

	}
}