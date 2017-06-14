/**
 * Created by chaoge on 2017/6/12.
 */
import animal.*;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
   用四位二进制表示岸边的状态，从最高位起，每一位分别表示老人，狗，猫，鱼
   以目的岸边为基准，即从0000开始，找到一个安全序列，使得能够达到1111
   算法设计：采用广度优先算法，借助队列存储状态实现
 */
public class RiverCross {
    //定义一个静态常量表示状态的个数
    private static final int statusLen = 16;
    //用来表示各个状态是否已经出现过
    private int[] visted = new int[statusLen];//默认0为未曾出现过
    //每次过河都有4种选择，安不安全合不合适交给isSafe函数去判断
    private int choice[] = {8,9,10,12};
    //用队列来存储路径，因为一共就16中状态，所以队列容量为16足以
    private ArrayQueue<Integer> queue = new ArrayQueue<Integer>(statusLen);
    //存储路径
    private int route[] = new int[statusLen];
    private animal[] animals = {new man(),new dog(),new cat(),new fish()};

    public void print(){
        int []result = RiverCross();
        int j = 0;
        int count = 0;
        while (j < 16 ){
            System.out.print("第"+ ++count + "步,");
            System.out.print(j + " -> " + result[j]+", ");
            for (animal a:animals) {
                if(a instanceof  man)
                    a.getDescribe(result[j]);
                else
                a.getDescribe((result[j]^j));
            }
            System.out.println();
            j = result[j];
            if(j == 15)
                break;
        }
    }
    //初始化相关数组队列等
    public void Init(){
        for(int i = 0; i < statusLen; i++){
            route[i] = -1;
            visted[i] = 0;
        }
        queue.add(0);//初始化队列，表示目的岸边的状态为0
        visted[0] = 1;
    }
    //过河
    public int[] RiverCross(){
        Init();
        int choiceLen = choice.length;
        int nextStatus;
        int result[] = new int[statusLen];
        while (!queue.isEmpty()){//当队列非空
           //取出对头元素，这里的remove中的参数只能为0
           int status = queue.remove(0);
           for(int i = 0; i < choiceLen; i++){
               //用异或就能保证过河的次序是来还是去
               nextStatus = status ^ choice[i];
               if(visted[nextStatus]==0 && isSafe(nextStatus)){
                   visted[nextStatus] = 1;
                   route[nextStatus] = status;
                   if(nextStatus == 15)
                       break;
                   queue.add(nextStatus);
               }
           }
       }
       if(visted[statusLen-1] == 0)
           return null;
        //逆序遍历，找出路径存入result中
        int j = 15;
        while (j != -1 && route[j]!=-1){
//           System.out.print("j == "+j+" temp[j]== "+temp[j]+", ");
            result[route[j]] = j;
            j = route[j];
        }
       return result;

    }

    //判断下一个状态是否安全
    public boolean isSafe(int status){
        /*
          经过归纳总结可以发现，狗和猫如果状态一样的话，那么跟老人的状态也必须一样，
          否则两岸肯定会有一边处于不安全的状态。同理可知猫和鱼。
         */
        if(animals[1].isExists(status)==animals[2].isExists(status) &&
                animals[1].isExists(status) != animals[0].isExists(status))
            return false;
        if(animals[2].isExists(status)==animals[3].isExists(status) &&
                animals[2].isExists(status) != animals[0].isExists(status))
            return false;
        return true;
    }

}

















