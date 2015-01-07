class Prob1 {
	public static void main(String[] args) {
		double a = 5.0000;
		double b = 4.0000;
		double c = 3.0000;


		double aa = a + b + c;
		double bb = a + b - c;
		double cc = a - b + c;
		double dd = b + c - a;

		double num = a * b * c;
		double denom = Math.sqrt(aa * bb * cc * dd);

		double radius = num / denom;;

		System.out.println(radius);

		double area = Math.PI * Math.pow(radius , 2);;

		return area;
	}
}