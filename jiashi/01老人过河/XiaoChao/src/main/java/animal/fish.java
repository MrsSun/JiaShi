package animal;

import animal.animal;

/**
 * Created by chaoge on 2017/6/12.
 */
public class fish implements animal {
    public void getDescribe(int status){
        if(isExists(status))
        System.out.print(",携带者鱼");
        else
            System.out.print("");
    }
    public boolean isExists(int status) {
        if((status & 1) == 1)
            return true;
        return false;
    }
}
