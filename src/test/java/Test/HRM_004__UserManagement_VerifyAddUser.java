package Test;

import Pages.Admin.UserManagement;
import Utility.Base;
import org.testng.annotations.Test;

public class HRM_004__UserManagement_VerifyAddUser extends Base {
    UserManagement obj_AdminUserManagement;

    @Test
    public void VerifyUsersRecord() {
        obj_AdminUserManagement = new UserManagement(page);
        obj_AdminUserManagement.addUser();
    }
}
