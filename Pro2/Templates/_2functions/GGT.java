package _2functions;

public class GGT {
	
	public int ggT(int i1, int i2) {
		if(i1 < i2) {
			int tmp = i1;
			i2 = i1;
			i2 = tmp;
		}
		
		int r = i1 % i2;
		while(r > 0) {
			i1 = i2;
			i2 = r;
			r = i1 % i2;
		}
		return i2;
		
	}
	
	public int bestimmeMax(int a, int b, int c) {
		if (a > b) {
			int tmp = a;
			b = a;
			a = tmp;
		}
		if (b > c) {
			int tmp = b;
			b = c;
			c = tmp;
		}
		return c;
	}

}
