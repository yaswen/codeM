package codeM;

import java.util.Scanner;
public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
    }
}

/*
 * 围棋是起源于中国有悠久历史的策略性棋类游戏。它的规则如下：
1. 棋盘19*19。
2. 棋子分黑白两色，双方各执一色。
3. 下法：每次黑或白着一子于棋盘的空点上。棋子下定后，不再向其他点移动。
4. 棋子的气：一个棋子在棋盘上，与它相邻的空点是这个棋子的“气”（这里相邻是指两个点有公共边）。 相邻的点上如果有同色棋子存在，这些棋子就相互连接成一个不可分割的整体，气合并计算。
相邻的点上如果有异色棋子存在，此处的气便不存在。
如果棋子所在的连通块失去所有的气，即为无气之子，不能在棋盘上存在。
5. 提子：把无气之子清理出棋盘的手段叫“提子”。提子有二种：
1) 着子后，对方棋子无气，应立即提取对方无气之子。
2) 着子后，双方棋子都呈无气状态，应立即提取对方无气之子。
6. 禁着点：棋盘上的任何一空点，如果某方在此下子，会使该子立即呈无气状态，同时又不能提取对方的棋子，这个点叫做“禁着点”，该方不能在此下子。
7. 禁止全局同形：无论哪一方，在成功进行了着子、提子操作后，棋盘局面不能和任何之前的局面相同。

你要做的是：输入一些操作，从空棋盘开始模拟这些操作。
对于每一步，若结果不正确，则输出对应的miss并且忽略这个操作，并在最后输出棋盘的局面。
输入描述:
第一行，测试数据组数≤100

第二行，每组测试数据，执行的步数 n ≤ 2000 

然后 n 行 

B x y 

W x y 

(1 ≤ x ≤ 19,1 ≤ y ≤ 19)
其中，二元组 x,y 表示围棋棋盘上第 x 行第 y 列对应的点。
输入数据保证是黑白轮流下的。


输出描述:
多行
对于miss的情况，输出是哪一种错误格式，其中：
miss 1 表示下的位置已经有棋了
miss 2 表示违反规则6
miss 3 表示违反规则7
对于正常的操作，不用输出。
最后输出最终盘面。“B表示黑子，W表示白子，如果是空点的话，就输出'.'字符。”
*/