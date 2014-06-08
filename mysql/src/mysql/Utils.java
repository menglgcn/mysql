package mysql;

import java.util.Random;

public class Utils {
	
	private static Random rand=new Random();
	public static String generateStr(){
		String temp="";
		char[] alpha ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//		char[] charArray=new char[5];
		for(int i=0;i<5;i++){
//			charArray[i]=alpha[rand.nextInt(alpha.length)];
			temp=temp+alpha[rand.nextInt(alpha.length)];
		}
		return temp;
	}

	public static int generateAge(){
		return rand.nextInt(100);
	}
	
	public static void main(String[] args){
		System.out.println(generateStr());
	}
}
