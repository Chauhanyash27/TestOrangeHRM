package Test;

import Pages.Leave.Apply;
import Utility.Base;
import org.testng.annotations.Test;

public class HRM_054_Apply_ToVerifyThatUserIsAbleToApplyLeave extends Base {

    Apply obj_Apply;

    @Test
    public void ToVerifyThatUserIsAbleToApplyLeave(){
        obj_Apply = new Apply(page);
        obj_Apply.applyLeave();
    }
}
