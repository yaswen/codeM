package codeM;

import java.util.Scanner;

//可乐题
//第一行三个整数n，m，k分别表示要买的可乐数、小美喝的可乐数以及可供选择的可乐种数。
//接下来k行，每行两个整数a，b分别表示某种可乐分别给予小美和小团的快乐程度。
//对于所有数据，1 <= n <= 10,000, 0 <= m <= n, 1 <= k <= 10,000, -10,000 <= a, b <= 10,000
public class Main180002 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//        }
        int n = in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        
        int [] a=new int[k];
        int [] b=new int[k];
        
        
        for(int i=0;i<k;i++) {
        	a[i]=in.nextInt();
        	b[i]=in.nextInt();
        	
        }
        in.close();
       // Main180002 main=new Main180002();
        ss=new int[k][k];

        //测试调用函数
        float test=getMaxHappy(a, b, n, m, 0, n);
       // System.out.println(test);
        //System.out.print("ss:");
        for(int i=0;i<k;i++) {
        	System.out.print(ss[0][i]);
        	if(i!=k-1) {
        		System.out.println(" ");
        	}
        }
        System.out.println();
	}
//思路：、
	//因为总共必须买那么多可乐(k瓶),由于字典序最小优先,因此最好都把可乐往后排,尽量多买后面的可乐为好.
	//因此从第一种可乐开始计算,计算一下假如这种可乐只买i瓶,剩下的可乐可以产生的最大快乐期望值是多少.
	//然后再给这种可乐加一瓶,算一下剩下的可乐可以产生的最大快乐期望值是多少(注意这里不一定剩下的可乐可以产生的最大快乐期望值会减少,因为剩下的可乐可能俩人都不爱喝)
	//递归到中间时候,还剩下s瓶可乐必须要买,for循环从0到s,每一步递归调用该函数计算剩余可乐可以产生的最大快乐期望值.加到这一步循环值上,保留最大的一个值.返回.
	//递归到最后的时候,还剩下s瓶可乐必须要买了,而这已经是最后一种了,于是这种可乐产生的期望值是固定的了.
	//每种可乐产生的最大快乐期望值为:(m/n)*s*a[kk]+((n-m)/n)*s*b[kk]
	public static int[][] ss;//在每层循环时目前最大快乐值时每种可乐买的瓶数。第一维度为1就是最后的标准答案
	public static float getMaxHappy(int[] a,int[] b,int n,int m,int kk,int s) {
		//kk为目前循环到第几种可乐了,s为还剩多少瓶可乐必须买了
		if(s==0) {//假如前面已经把可乐分配完了，本种可乐不会带来快乐期望值哈。(小美和小团还不会因为喝不到某一种可乐而开心或失落)
			
			return 0;
			
			
			
		}
		if(kk==a.length-1) {
			ss[kk][kk]=s;
			return ((float)m/n)*s*a[kk]+((float)(n-m)/n)*s*b[kk];
		}
		
		float maxHappy=Integer.MIN_VALUE;//第kk种可乐可以带来的最大快乐期望值。
		for(int i=0;i<=s;i++) {
			float happy=0;
			
			//这一种可乐买i瓶的话，可以带来的快乐期望值
			happy+=((float)m/n)*i*a[kk]+((float)(n-m)/n)*i*b[kk];
			//递归调用计算kk种可乐买i瓶的时候,后面的最佳方案.返回最大快乐期望值
			happy+=getMaxHappy(a,b, n, m, kk+1, s-i);
			if (happy>maxHappy) {
				//确定了目前是到第kk瓶为止的最优策略。
				maxHappy=happy;
				//确定了目前是到第kk瓶为止的最优策略，即把方案保存进第kk层ss
				ss[kk][kk]=i;
				for(int ki=kk+1;ki<=a.length-1;ki++) {
					ss[kk][ki]=ss[kk+1][ki];
					ss[kk+1][ki]=0;
				}
			}
		}
		return maxHappy;
		
	}
}
