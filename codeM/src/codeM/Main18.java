package codeM;

import java.util.Scanner;

public class Main18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//        }
        int n = in.nextInt();
        int [] musicp=new int[n];
        for(int i=0;i<n;i++){
        	musicp[i]=in.nextInt();
        }
        int m = in.nextInt();
        int [] music=new int[m];
        for(int i=0;i<m;i++){
        	music[i]=in.nextInt();
        }
        in.close();
        int difference = Integer.MAX_VALUE;
        for(int i=0;i<m-n+1;i++){
        	int d=0;
        	for(int j=0;j<n;j++){
        		d+=Math.pow(music[i+j]-musicp[j],2);
        	}
        	
        	difference=Math.min(difference, d);
        	//取最小值保存
        	
        }
        System.out.println(difference);
    }
}
