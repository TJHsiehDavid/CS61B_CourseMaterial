public class Foo { 
	public int x, y; 
	public Foo (int x, int y) { 
		this.x = x; 
		this.y = y; 
	} 

	/** a and b are point to foobar and baz by sequence, but not foorbar and baz themselves,
	  * so a and b are pointer point to them and not have any chance to chenge the foobar and baz.
	  * */
	public static void switcheroo (Foo a, Foo b) { 
		Foo temp = a; 
		a = b; 
		b = temp; 
	} 

	/** a and b are point to foobar and baz by sequence, but a.x which is the member in the foobar and 
	  * b.x is the member in the baz, so when modified those values, they will simutanouly change foobar and baz.
	  * */
	public static void fliperoo (Foo a, Foo b) { 
		Foo temp = new Foo(a.x, a.y); 
		a.x = b.x; 
		a.y = b.y; 
		b.x = temp.x; 
		b.y = temp.y; 
	} 
	public static void swaperoo (Foo a, Foo b) { 
		Foo temp = a; 
		a.x = b.x; 
		a.y = b.y; 
		b.x = temp.x; 
		b.y = temp.y; 
	} 
	public static void main (String[] args) { 
		Foo foobar = new Foo(10, 20); 
		Foo baz = new Foo(30, 40); 
		switcheroo(foobar, baz); 
		fliperoo(foobar, baz); 
		swaperoo(foobar, baz); 
	} 
}