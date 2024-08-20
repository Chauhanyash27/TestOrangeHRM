package Test;

import Pages.Admin.Organization;
import Utility.Base;
import Utility.OrganizationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_049_Organization_ToVerifyThatUserIsNotAbleToEditDetailsWithoutSelectingEditCheckbox extends Base {

    Organization obj_Organization;

    @Test
    public void ToVerifyThatUserIsNotAbleToEditDetailsWithoutSelectionEditCheckbox() {
        obj_Organization = new Organization(page);
        obj_Organization.navigateToSection(OrganizationSections.GeneralInformation.getSectionName());
        Assert.assertTrue(obj_Organization.fieldEnabledCheck());
    }
}
