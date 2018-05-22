package codeM;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        for(int ra=0;ra<n;ra++){
        	a[ra]=sc.nextInt();
        }//读所有人积分
        int ans = 0;
        int t=0;
        //int[] m=new int[20];//轮数分割线
        for(int x=1;x<n;x++){
        	//求出有多少个人积分不比a0大
        	if(a[x]<=a[0]){
        		t+=1;
        	}
        }
        int v=0;
        for(int k=0;k<=20;k++){
        	v+=(int) Math.pow(2,k);
        	if(t>=v){
        		ans=k+1;
        	}
        }
        
        System.out.println(ans);
	}
}