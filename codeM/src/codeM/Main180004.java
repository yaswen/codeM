package codeM;

import java.util.Scanner;

//世界杯题
//数据共有16行，每行16个浮点数，第i行第j列的数Fi,j表示i和j进行比赛时i获胜（包括常规时间获胜、加时赛获胜以及点球大战获胜）的概率。
//对于1 <= i, j <= 16 且 i != j, 满足0 <= Fi,j <= 1, Fi,j + Fj,i = 1；
//对于1 <= i <= 16, 满足 Fi,i = 0。

//输出一行16个浮点数，用空格隔开，分别表示每只球队获得世界杯的概率，结尾无空格。
//绝对误差或相对误差在1e-5之内的解会被判为正确。
public class Main180004 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float [][] pa=new float[16][16];
        for(int i=0;i<16;i++) {
        	for(int j=0;j<16;j++) {
        		pa[i][j]=in.nextFloat();
        	}
        }
        in.close();
        //思路：经检验，所有顺序已排好，无需考虑题目中其他内容，只要直接0和1打，2和3打，然后相邻胜者打。
        //思路：
        float [][] pp=new float[16][5];
        for(int i=0;i<16;i++) {
        	int ag;//对手
        	if(i%2==0) {
        		ag=i+1;
        	}else {
        		ag=i-1;
        	}
        	pp[i][1]=pa[i][ag];//每个队晋级下一轮的概率
        }
        for(int i=0;i<16;i++) {
        	int ag;//第一个对手（共两个）
        	if((i/2)%2==0) {
        		ag=((i/2)+1)*2;
        	}else {
        		ag=((i/2)-1)*2;
        	}
        	
        	pp[i][2]=pp[i][1]*(pa[i][ag]*pp[ag][1]+pa[i][ag+1]*pp[ag+1][1]);//每个队晋级下两轮的概率
        }
        for(int i=0;i<16;i++) {
        	int ag;//第一个对手（共四个）
        	if((i/4)%2==0) {
        		ag=((i/4)+1)*4;
        	}else {
        		ag=((i/4)-1)*4;
        	}
        	
        	pp[i][3]=pp[i][2]*(pa[i][ag]*pp[ag][2]+pa[i][ag+1]*pp[ag+1][2]+pa[i][ag+2]*pp[ag+2][2]+pa[i][ag+3]*pp[ag+3][2]);//每个队晋级下三轮的概率
        }
        
        for(int i=0;i<16;i++) {
        	int ag=i<8?8:0;//第一个对手（共八个）
        	pp[i][4]=0;
        	for(int j=0;j<8;j++) {
        		pp[i][4]+=pp[i][3]*(pa[i][ag+j]*pp[ag+j][3]);
        	}
        	System.out.print(pp[i][4]);
        	if(i!=15) {
        		System.out.print(" ");
        	}
        }
        
	}
	
}
