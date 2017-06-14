/**
 * Created by chaoge on 2017/6/14.
 */
public class Bit {
    //定义一个二维数组用来存储数的位置
    private int size = 2^32/32;
    private Bit position[32][size];

    //计算数的位置，然后存储在二维数组中
    public void stroPosition(int num){
        row = num >> 5; //相当于除以32
        col = num & 31; //相当于对32求余
        position[row][col] = 1;
    }
    public boolean isExists(int num){
        row = num >> 5; //相当于除以32
        col = num & 31; //相当于对32求余
        position[row][col] == 1 ? return true : return false;
    }
    //初始化
    public void init(){
        while(true){
            int num = input(); //依次输入是十亿个数
            stroPosition(num);//存储是否出现的信息
        }
    }
    public static void main(String [] args){
       Bit bit = new Bit();
       bit.init();
       int num = bit.input();
       if(bit.isExists(num))
           System.out.println("存在这个数");
       else
           System.out.println("不存在这个数");
    }
}
