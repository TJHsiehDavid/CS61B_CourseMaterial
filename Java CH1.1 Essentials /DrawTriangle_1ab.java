

public class DrawTriangle_1a{
	public static void star(int x)
	{
		for(int i = 1; i <= x; i++)
		{
			for(int j = 0; j < i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		star(9);
	}
}
