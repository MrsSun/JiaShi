package animal;

import animal.animal;

/**
 * Created by chaoge on 2017/6/12.
 */
public class dog implements animal {
    public void getDescribe(int status){
        if (isExists(status))
        System.out.print(",携带者狗");
    }
    public boolean isExists(int status) {
        if((status & 4) == 4)
            return true;
        return false;
    }
}
