package codeM;


import java.util.Scanner;
//小胖参加了人生中最重要的比赛——MedoC资格赛。MedoC的资格赛由m轮构成，使用常见的“加权标准分”的规则。每位选手需要参加所有的m轮的比赛。在一轮中，能取得的分数为自己的成绩除掉最高分的成绩。每个选手的总分为每一轮获得的分数乘上这一轮比赛占得比重。如果在某一轮比赛中所有人获得了零分，那么所有选手在这一轮获得的分数都为0分。
//比如说，资格赛一共3轮，三轮的权重分别为30%, 30%, 40%。在第一轮中，小胖获得了300分，最高分也为300分。在第二轮中，小胖获得了0分，最高分也为0分。在第三轮中，小胖获得了150分，最高分为300分，那么小胖的总分为(300/300)*30%+0*30%+(150/300)*40%=0.5。
//一共有n位选手参加了比赛，其中成绩最高的k位选手能够晋级到初赛。如果有多人在分数线上同分，那么系统会随机在这些同分的人中选取，选满k个晋级为止。
//小胖现在知道了每个选手每场比赛的成绩，但是由于他的疏忽，其中的某个人某场比赛的成绩消失了。所以更多人出线的情况变得未知起来。现在只知道成绩一定是0到C之间的一个整数（包含0和C）。
//小胖想知道对于每个人的出线情况是怎么样的，也就是一定能出线，一定不能出线还是有可能出线。
//输入描述:
//第一行四个正整数n,m,k,C (m <= 6, k <= n <= 500, C <= 500)。
//接下来一行m个整数w1, w2, ..., wm，表示每场比赛的权重，第i场比赛的权重为wi/(w1+w2+...+wm)，保证wi >= 0且1 <= w1 + w2 + ... + wm <= 1000。
//接下来n行每行m个整数，第i个整数表示这个选手在第i场比赛中获得的成绩。如果这个数字为-1表示这个数据丢失，保证恰好有一个-1。
//输出描述:
//n行每行输出一个1到3之间的整数。1表示一定出线，2表示一定不出线，3表示可能出线。


import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//九宫格题
//1		ABC		DEF
//GHI	JKL		MNO
//PQRS	TUV		WXYZ

public class Main180102 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n=in.nextInt();
        long [] a=new long[n];
        long [] b=new long[n];
        long sa=0;
        long shengb=0;
        long shenga=0;
        long zoul=0;
        long zour=0;
        long sb1=0;
        long sb2=0;
        long sb3=0;
        for(int i=0;i<n;i++) {
        	a[i]=in.nextInt();
        	sa+=a[i]*i;
        }
        for(int i=0;i<n;i++) {
        	b[i]=in.nextInt();
        	
        }
        in.close();
        for(int i=n-1;i>=0;i--) {
        	shenga+=a[i];
        	if(shenga<b[i]) {
        		sb1+=shenga*i;
        		sb2+=(b[i]-shenga)*i;
        		shenga=0;
        	}else {
        		sb1+=b[i]*i;
        		shenga-=b[i];
        	}
        }
        System.out.println(sa+sb2-sb1);
        /*for(int i=0;i<n;i++) {
        	//shenga+=a[i];
        	shengb+=b[i];
        	if(shengb>a[i]) {
        		
        		shengb-=a[i];
        		sb3+=b[i]*i;
        	}else {
        		shengb=0;
        		sb3+=(b[i]-shengb)*i;
        		sb2+=
        	}
        	
        }*/
        
//        System.out.println(sa+sb);
        
        
        		
	}
	
}
