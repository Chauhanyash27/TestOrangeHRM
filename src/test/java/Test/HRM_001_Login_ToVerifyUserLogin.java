package Test;

import Pages.Login;
import Utility.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_001_Login_ToVerifyUserLogin extends Base {

    Login obj_login;

    @Test
    public void ToVerifyUserLogin() throws InterruptedException {
        obj_login = new Login(page);
        obj_login.userLogin();
        Assert.assertTrue(obj_login.verifySuccessfullLogin());
    }

}
