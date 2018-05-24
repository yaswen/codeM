package codeM;

import java.util.Scanner;
//小美锦标赛题

public class Main1802 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//        }
        long n = in.nextInt();
        long mei=in.nextInt();
        long lun=1;
        for(int i=1;i<n;i++){
        	
        	long score=in.nextInt();
        	if (score<=mei){
        		lun++;
        	}
        	
        }
        
//        System.out.println((int)Math.floor(log(lun,2))+1);
//        System.out.println("lun:"+lun);
	in.close();
		int lunn=0;
		for(int i=1;i<=20;i++){
			if(lun>=Math.pow(2, i)){
				lunn++;
			}
		}
		System.out.println(lunn);
	}
//	static public double log(double value, double base) {
//		return Math.log(value) / Math.log(base);
//	}
	
}
