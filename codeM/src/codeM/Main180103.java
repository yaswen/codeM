package codeM;

//第一行一个整数n(1 ≤ n ≤ 100,000)表示点数。
//接下来n-1行，每行四个整数x, y, z, l(1 ≤ x, y ≤ n, 1 ≤ z, l ≤ 1,000,000,000)，表示从x到y之间有一条边权为z的边，并且这条边至少要经过l次。
//数据保证没有重边和自环。
//接下来一个整数m(1 ≤ m ≤ 100,000)表示询问组数。
//接下来m行，每行两个整数S, T(1 ≤ S, T ≤ n)表示一组询问。
import java.util.Scanner;
public class Main180103 {
	static int g=1000000007;
//	static int [] x;
//	static int [] y;
//	static int [] time1;
//	static int [] time2;
	static int [][] road;
	public static void main(String[] args) {
		
		
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int [] x=new int[n];
        int [] y=new int[n];
        int [] z=new int[n];
        int [] l=new int[n];
        int [] l1=new int[n];
        int [] l2=new int[n];
        road=new int[n][n];
        long [] time1=new long[n];
        long [] time2=new long[n];
        for(int i=0;i<n-1;i++) {
        	x[i]=in.nextInt();
        	y[i]=in.nextInt();
        	z[i]=in.nextInt();
        	l[i]=in.nextInt();
        	if(l[i]%2==0) {
        		l1[i]=l[i]+1;
        		l2[i]=l[i];
        	}else {
        		l1[i]=l[i];
        		l2[i]=l[i]+1;
        	}
        	time1[i]=(long)l1[i]*z[i];
        	time2[i]=(long)l2[i]*z[i];
        	road[x[i]-1][y[i]-1]=1;
        	road[y[i]-1][x[i]-1]=1;
        }
        int m=in.nextInt();
        int [] s=new int[m];
        int [] t=new int[m];
        for(int i=0;i<m;i++) {
        	s[i]=in.nextInt();
        	t[i]=in.nextInt();
        }
        in.close();
        
        
        System.out.println(time2[1]%g);
        System.out.println(road[0][2]);
        
	}
	public static void getline() {
		
		
	}
}
