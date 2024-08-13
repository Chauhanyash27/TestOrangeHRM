package Test;

import Pages.Admin;
import Utility.Base;
import org.testng.annotations.Test;

public class HRM_004_Admin_VerifyAddUser extends Base {
    Admin obj_Admin;

    @Test
    public void VerifyUsersRecord(){
        obj_Admin = new Admin(page);
        obj_Admin.addUser();
    }
}
