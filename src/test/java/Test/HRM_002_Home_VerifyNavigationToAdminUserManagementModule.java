package Test;

import Pages.Home;
import Utility.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_002_Home_VerifyNavigationToAdminUserManagementModule extends Base {
    Home obj_Home;

    @Test
    public void VerifyNavigationToAdminModule() {
        obj_Home = new Home(page);
        Assert.assertTrue(obj_Home.navigateToAdminModule());
    }
}
