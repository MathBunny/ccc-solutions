/* Large Array Sum in C# */

class VeryBigSum{
	static void Main(string[] args){
		int T = Convert.ToInt16(Console.ReadLine());
		Int64 total = 0;
		foreach (string str in Console.ReadLine().Split(‘ ‘)){
			total += Convert.ToInt64(str);
		}
		Console.WriteLine(total);
	}
}