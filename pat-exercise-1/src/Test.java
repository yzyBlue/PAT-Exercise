import java.math.BigDecimal;


public class Test {
	public static void main(String[] args) {
		//System.out.println((3-2.6));
		//System.out.println((3-2.6)==0.4);
		double x = 3 - 2.6;
		float y = 3f - 2.6f;
		BigDecimal a = new BigDecimal("3");
		BigDecimal b = new BigDecimal("-2.6");
		BigDecimal z = a.add(b);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z.toString());
	}
}
