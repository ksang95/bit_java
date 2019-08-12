package util;

public class MyUtil {
	//method 오버로딩 
 	public static long add(int a,int b) {
		return a+b;
	}
 	
 	public static double add(double a,double b) {
		return a+b;
	}
	
 	//가변인자 , 제일 마지막 위치만 허용
	public static double add(double ... nums) {  // []로 처리 
		
		double sum=0;
		
		for(double data :nums) {
			sum += data;
		}
		return sum;
	}
//	public static double add(double[] a) {
//        double sum=0;
//		
//		for(double data :a) {
//			sum += data;
//		}
//		return sum;	
//	}
	public static String leftPad(String str, int size, char padChar) {
		if(str.length() > size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = padChar+str;
		}
		return str;
	}
	public static String rightPad(String str, int size, char padChar) {
		if(str.length() > size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = str+padChar;
		}
		return str;
	}
	public static int[] sort(int[] nums) {
		//배열 원본은 변경이 되지 않도록 하고 
		//오름차순으로  정렬된 int[] 을 리턴한다.
		
		int[] copy = new int[nums.length];
		System.arraycopy(nums, 0, copy, 0, nums.length);
		
		for(int i=0;i<copy.length-1 ;i++) {
			for(int j=i+1;j<copy.length ;j++) {
				if(copy[i] > copy[j]) {
					int temp = copy[i];
					copy[i] = copy[j];
					copy[j] = temp;
				}
			}
		}
		
		return copy;
	}
	// 숫자를 넘겨 받아  그중 가장 큰수를 리턴하는 함수  max
    	
	public static int max(int ... a){
		int max = Integer.MIN_VALUE;
		for(int data:a) {
			if(max < data) max = data;
		}
		return max;
	}
	//min
}












