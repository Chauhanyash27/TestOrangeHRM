package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_038_Qualifications_ToVerifyLicenseRecordGettingDeleted extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyLicenseRecordGettingDeleted(){
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Licenses.getSectionName());
        Assert.assertTrue(obj_Qualifications.deleteUser());
    }
}
