public class fib {
	//original fib that is the function is conclude more than five lines
	public static int fib(int n) {
		if(n > 1)
			return fib(n-1) + fib(n-2);
		else
			return n;
	}

	public static int fib_2(int n, int k, int f0, int f1) {
		if(n > k)
			return fib_2(n-1, k, f1, f0+f1);
		else
			return f0;
	}

	public static void main(String[] args) {
		System.out.println(fib(10));
		System.out.println(fib_2(10, 1, 0, 1));
	}
}