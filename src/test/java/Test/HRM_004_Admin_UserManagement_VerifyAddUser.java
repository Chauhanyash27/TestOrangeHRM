package Test;

import Pages.Admin_UserManagement;
import Utility.Base;
import org.testng.annotations.Test;

public class HRM_004_Admin_UserManagement_VerifyAddUser extends Base {
    Admin_UserManagement obj_AdminUserManagement;

    @Test
    public void VerifyUsersRecord(){
        obj_AdminUserManagement = new Admin_UserManagement(page);
        obj_AdminUserManagement.addUser();
    }
}
