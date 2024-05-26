package arrays_strings;

class ArrayDemo {
	public static void main(String[] args) {
		System.out.println("String array default values:");
		String str[] = new String[5];
		for (String s : str)
			System.out.print(s + " ");

		System.out.println(
				"\n\nInteger array default values:");
		Integer num[] = new Integer[5];
		for (Integer val : num)
			System.out.print(val + " ");

		System.out.println(
				"\n\nint array default values:");
		int num2[] = new int[5];
		for (Integer val : num2)
			System.out.print(val + " ");

		System.out.println(
				"\n\ndouble array default values:");
		double dnum[] = new double[5];
		for (double val : dnum)
			System.out.print(val + ", ");

		System.out.println(
				"\n\nBoolean array default values:");
		boolean bnum[] = new boolean[5];
		for (boolean val : bnum)
			System.out.print(val + " ");

		System.out.println(
				"\n\nReference Array default values:");
		ArrayDemo ademo[] = new ArrayDemo[5];
		for (ArrayDemo val : ademo)
			System.out.print(val + " ");
	}
}
