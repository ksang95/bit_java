package util;

public class MyMath {
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
	
}



