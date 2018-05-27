package codeM;

import java.text.DecimalFormat;
import java.util.Scanner;
//美团下单满减题
//第一行，两个整数n,m。
//接下来n行，每行一个正整数ai(价格)，以及一个0/1表示是否可以选择特价优惠（1表示可以）。
//接下来m行，每行两个正整数bi,ci，描述一款满减优惠。(满bi减ci)
//
//1 <= n,m <=10
//1 <= ai <= 100
//1 <= ci < bi <= 1000

public class Main180001 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//        }
        int n = in.nextInt();
        int m=in.nextInt();
        int [] a=new int[n];
        int [] aa=new int[n];
        int [] b=new int[m];
        int [] c=new int[m];
        
        float s8=0;//使用打八折策略总价
        int s=0;//不打折总价
        for(int i=0;i<n;i++){
        	
        	a[i]=in.nextInt();
        	aa[i]=in.nextInt();
        	s8+=aa[i]==1?(float)a[i]*0.8:a[i];
        	s+=a[i];
        	
        }
        
        int sm=Integer.MAX_VALUE;//满减策略最低价
        for(int j=0;j<m;j++) {
        	b[j]=in.nextInt();
        	c[j]=in.nextInt();
        	int smj=s>=b[j]?s-c[j]:s;
        	sm=smj<sm?smj:sm;
        }
        
        in.close();
        float price=Math.min(sm, s8);
        
	
	
		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String p=decimalFormat.format(price);//format 返回的是字符串
		System.out.println("s8::"+p);
	}
	
}
