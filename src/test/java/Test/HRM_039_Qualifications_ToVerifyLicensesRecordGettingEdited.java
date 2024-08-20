package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_039_Qualifications_ToVerifyLicensesRecordGettingEdited extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyLicensesRecordGettingEdited(){
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Licenses.getSectionName());
        Assert.assertTrue(obj_Qualifications.editRecord());
    }
}
