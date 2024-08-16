package Test;

import Pages.Admin.UserManagement;
import Utility.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_003__UserManagement_VerifyUsersRecord extends Base {
    UserManagement obj_AdminUserManagement;

    @Test
    public void VerifyUsersRecord(){
        obj_AdminUserManagement = new UserManagement(page);
        Assert.assertTrue(obj_AdminUserManagement.userCountVerification());
    }
}
