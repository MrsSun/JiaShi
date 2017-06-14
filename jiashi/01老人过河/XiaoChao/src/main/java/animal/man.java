package animal;

import animal.animal;

/**
 * Created by chaoge on 2017/6/12.
 */
public class man implements animal {
    public void getDescribe(int status){
        if (isExists(status))
            System.out.print("老人从河对岸到目的岸来");
        else
            System.out.print("老人从目的岸去河对岸");
    }
    public boolean isExists(int status) {
        if((status & 8) == 8)
            return true;
        return false;
    }
}
