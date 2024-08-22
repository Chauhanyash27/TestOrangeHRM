package Test;

import Pages.Leave.Apply;
import Utility.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_053_Apply_ToVerifyNavigationToApplyLeaveSection extends Base {

    Apply obj_Apply;

    @Test
    public void ToVerifyNavigationToApplyLeaveSection() {
        obj_Apply = new Apply(page);
        obj_Apply.clickApplySubmodule();
        Assert.assertTrue(obj_Apply.sectionNavigationVerification("Apply Leave"));
    }
}
