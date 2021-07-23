
public class GCD {
	public static void main(String[] args) {
		int[] arr = {2,3,6,5,4,3};
		int result = 0 ;
		for(int element: arr) {
			result = gcd1(result,element);
			if(result == 1)
				break;
		}
		System.out.println(result);
		
		//System.out.println(gcd1(15,35));
	}
	public static int gcd1(int a , int b)
	{ System.out.println(a+","+b);
		if(a == 0) {
			return b;
		}else {
			return gcd1(b % a, a);
		}
	}
	
}
