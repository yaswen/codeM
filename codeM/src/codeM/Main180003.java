package codeM;

import java.util.Scanner;

//可乐题
//第一行三个整数n，m，k分别表示要买的可乐数、小美喝的可乐数以及可供选择的可乐种数。
//接下来k行，每行两个整数a，b分别表示某种可乐分别给予小美和小团的快乐程度。
//对于所有数据，1 <= n <= 10,000, 0 <= m <= n, 1 <= k <= 10,000, -10,000 <= a, b <= 10,000
public class Main180003 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//        }
        int n = in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        
        int [] a=new int[k];
        int [] b=new int[k];
        
        float[] happy=new float[k];
        float maxHappy=Integer.MIN_VALUE;
        int maxHappyCocaCola=-1;
        for(int i=0;i<k;i++) {
        	a[i]=in.nextInt();
        	b[i]=in.nextInt();
        	happy[i]=((float)m/n)*a[i]+((float)(n-m)/n)*b[i];
        	if(happy[i]>=maxHappy) {
        		maxHappy=happy[i];
        		maxHappyCocaCola=i;
        	}
        	
        	//一瓶该可乐带来的快乐期望值
        }
        in.close();
        //思路：两人每人喝多少可乐数量已定，总有一个可乐是最好的，让两人快乐期望值之和最大，所以全买这种饮料。
        for(int i=0;i<k;i++) {
        	if(i==maxHappyCocaCola) {
        		System.out.print(n);
        	}else {
        		System.out.print("0");
        	}
        	
        	if(i!=k-1) {
        		System.out.print(" ");
        	}
        }
        
        
        
	}
}
