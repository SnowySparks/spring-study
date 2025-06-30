public class Main
{
	private static long seed = 5;


	private static int rand()
	{
		seed = seed * 25214903917L + 11L;

		return (int)((seed >> 16) & 0x7fff);
	}
	

	public static void main(String args[])
	{
		int[] data = new int[100];

		for (int c = 0; c < 100; c++)
		{
			data[c] = rand();
		}

		Test.run(data);

		int SCORE = 0;

		for (int c = 0; c < 99; c++)
		{
			if (data[c] > data[c + 1])
			{
				SCORE++;
			}
		}

		System.out.printf("SCORE: %d\n", SCORE);
	}
}
