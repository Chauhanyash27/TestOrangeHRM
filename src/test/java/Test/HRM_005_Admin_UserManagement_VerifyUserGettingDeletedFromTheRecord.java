package Test;

import Pages.Admin_UserManagement;
import Utility.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_005_Admin_UserManagement_VerifyUserGettingDeletedFromTheRecord extends Base {
    Admin_UserManagement obj_AdminUserManagement;

    @Test
    public void VerifyUsersRecord() {
        obj_AdminUserManagement = new Admin_UserManagement(page);
        Assert.assertTrue(obj_AdminUserManagement.deleteUser("Admin"));
    }
}
