package animal;

import animal.animal;

/**
 * Created by chaoge on 2017/6/12.
 */
public class cat implements animal {
    public void getDescribe(int status){
        if(isExists(status))
        System.out.print(",携带着猫");
        else
            System.out.print("");
    }

    public boolean isExists(int status) {
        if((status & 2) == 2)
            return true;
        return false;
    }
}
