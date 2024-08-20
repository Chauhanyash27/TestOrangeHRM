package Test;

import Pages.Admin.Organization;
import Utility.Base;
import Utility.OrganizationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_048_Organization_ToVerifyNavigationToEachSection extends Base {

    Organization obj_Organization;

    @Test
    public void ToVerifyNavigationToEachSection(){
        obj_Organization = new Organization(page);
        obj_Organization.navigateToSection(OrganizationSections.GeneralInformation.getSectionName());
        Assert.assertTrue(obj_Organization.sectionNavigationVerification(OrganizationSections.GeneralInformation.getSectionName()));

        obj_Organization.navigateToSection(OrganizationSections.Locations.getSectionName());
        Assert.assertTrue(obj_Organization.sectionNavigationVerification(OrganizationSections.Locations.getSectionName()));

        obj_Organization.navigateToSection(OrganizationSections.Structure.getSectionName());
        Assert.assertTrue(obj_Organization.sectionNavigationVerification(OrganizationSections.Structure.getSectionName()));
    }
}
