package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_037_Qualifications_ToVerifyNewLicenseRecordGettingAdded extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyNewLicenseRecordGettingAdded() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Licenses.getSectionName());
        Assert.assertTrue(obj_Qualifications.addRecord("Testing Name"));
    }
}
