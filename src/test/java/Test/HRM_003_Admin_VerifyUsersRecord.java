package Test;

import Pages.Admin;
import Utility.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_003_Admin_VerifyUsersRecord extends Base {
    Admin obj_Admin;

    @Test
    public void VerifyUsersRecord(){
        obj_Admin = new Admin(page);
        Assert.assertTrue(obj_Admin.userCountVerification());
    }
}
