package Test;

import Pages.Admin.Organization;
import Utility.Base;
import Utility.OrganizationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_051_Organization_ToVerifyThatLocationRecordsAreGettingSearchedBasedOnDataProvided extends Base {

    Organization obj_Organization;

    @Test
    public void ToVerifyThatLocationRecordsAreGettingSearchedBasedOnDataProvided() {
        obj_Organization = new Organization(page);
        obj_Organization.navigateToSection(OrganizationSections.Locations.getSectionName());
        Assert.assertTrue(obj_Organization.searchFunctionality());
    }
}
