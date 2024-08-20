package Test;

import Pages.Admin.Organization;
import Utility.Base;
import Utility.OrganizationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_050_Organization_ToVerifyThatGeneralInformationAreGettingEdited extends Base {

    Organization obj_Organization;

    @Test
    public void ToVerifyThatGeneralInformationAreGettingEdited() {
        obj_Organization = new Organization(page);
        obj_Organization.navigateToSection(OrganizationSections.GeneralInformation.getSectionName());
        obj_Organization.editGeneralInformation();
        Assert.assertTrue(obj_Organization.verifyGeneralInformation());
    }
}
