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

//是否出线题
//小胖参加了MedoC的资格赛
//比赛由m轮构成。每位选手需要参加所有的m轮的比赛。
//在一轮中，能取得的分数为自己的成绩除以最高分的成绩。
//每个选手的总分为每一轮获得的分数乘上这一轮比赛占得比重。
//如果在某一轮比赛中所有人获得了零分，那么所有选手在这一轮获得的分数都为0分。
//
//比如说，资格赛一共3轮，三轮的权重分别为30%, 30%, 40%。
//在第一轮中，小胖获得了300分，最高分也为300分。
//在第二轮中，小胖获得了0分，最高分也为0分。
//在第三轮中，小胖获得了150分，最高分为300分。
//那么小胖的总分为(300/300)*30%+0*30%+(150/300)*40%=0.5。
//
//一共有n位选手参加了比赛，其中成绩最高的k位选手能够晋级到初赛。
//如果有多人在分数线上同分，那么系统会随机在这些同分的人中选取，选满k个晋级为止。
//小胖现在知道了每个选手每场比赛的成绩，但是由于他的疏忽，其中的某个人某场比赛的成绩消失了。
//所以更多人出线的情况变得未知起来。现在只知道成绩一定是0到C之间的一个整数（包含0和C）。
//小胖想知道对于每个人的出线情况是怎么样的，也就是一定能出线，一定不能出线还是有可能出线。

//输入
//第一行四个正整数n,m,k,C (m <= 6, k <= n <= 500, C <= 500)。
//接下来一行m个整数w1, w2, ..., wm，表示每场比赛的权重，第i场比赛的权重为wi/(w1+w2+...+wm)，保证wi >= 0且1 <= w1 + w2 + ... + wm <= 1000。
//接下来n行每行m个整数，第i个整数表示这个选手在第i场比赛中获得的成绩。如果这个数字为-1表示这个数据丢失，保证恰好有一个-1。
//输出:
//n行每行输出一个1到3之间的整数。1表示一定出线，2表示一定不出线，3表示可能出线。
public class Main180006 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        int c=in.nextInt();
        int [] w=new int[m];
        for(int i=0;i<m;i++){
        	w[i]=in.nextInt();
        }
        int [][] score =new int[n][m];
        //int person1,game1;
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		score[i][j]=in.nextInt();
//        		if(score[i][j]==-1){
//        			person1=i;game1=j;
//        		}
        	}
        }
        in.close();
        int [][] isPass=new int[c+1][n];
        //从0到c枚举
        
        //System.out.println("读取完毕！");
        for(int i=0;i<=c;i++){
        	
        	//先计算每轮比赛的最高分
        	int [] gameMaxScore=new int[m];
        	for(int x=0;x<m;x++){
        		gameMaxScore[x]=Integer.MIN_VALUE;
        		for(int y=0;y<n;y++){
        			gameMaxScore[x]=Math.max(score[y][x]==-1?i:score[y][x], gameMaxScore[x]);
        		}
        	}
//        	System.out.println("第1轮最高分:"+gameMaxScore[0]);
//        	System.out.println("第2轮最高分:"+gameMaxScore[1]);
//        	System.out.println(Arrays.toString(gameMaxScore));  
        	//最大值求出
        	int [] personTotal=new int[n];//要求的当-1为i的时候每人总分
        	for(int p=0;p<n;p++){
        		//第p个人的总分
        		for (int lun=0;lun<m;lun++){
        			if(gameMaxScore[lun]!=0){
        				int scoreLun=score[p][lun]==-1?i:score[p][lun];
        				for(int ga=0;ga<m;ga++){
        					if(ga!=lun && gameMaxScore[ga]!=0){
        						scoreLun*=gameMaxScore[ga];
        					}
        				}
        				personTotal[p]+=scoreLun*w[lun];
        			}
        		}
        	}
        	//每个人总分求出
        	//排序
        	//寻找每个人的总分，比它大的有多少，和他登的有多少。据此判断谁是k。
        	int [] da=new int[n];
        	int [] deng=new int[n];
        	int [] xiao=new int[n];
        	//int fsx=0;
        	
        	for(int s=0;s<n;s++){
        		da[s]=0;
        		deng[s]=0;
        		xiao[s]=0;
        		for(int t=0;t<n;t++){
        			if(personTotal[t]>personTotal[s]){
        				da[s]++;
        			}else if(personTotal[t]==personTotal[s]){
        				deng[s]++;
        			}else{
        				xiao[s]++;
        			}
        		}
        		if(da[s]<k&&da[s]+deng[s]<=k){
        			isPass[i][s]=1;
        		}else if(da[s]>=k){
        			isPass[i][s]=2;
        		}else if(da[s]<k && da[s]+deng[s]>k){
        			isPass[i][s]=3;
        		}
        	}
        	
//        	if(fsx==0){
//        		System.out.println("分数线没取到");
//        	}else{
//        		System.out.println("分数线:"+fsx);
//        	}
//        	System.out.println(Arrays.toString(personTotal));
//        	System.out.println("通过情况"+Arrays.toString(isPass[i]));
        }
        
        int [] result=new int[n];
        for(int i=0;i<n;i++){
        	//每个人所有通过情况是否都一样，
        	result[i]=isPass[0][i];
        	
        
        	for(int j=1;j<=c;j++){
        		if(isPass[j][i]!=isPass[j-1][i]){
        			result[i]=3;
        			break;
        		}
        	}
        	
        }
        
        //System.out.println(Arrays.toString(result));
        
        for(int i=0;i<n;i++){
        	System.out.print(result[i]);
        	if(i!=n-1){
        		System.out.print(" ");
        	}
        }

	}
	
}
