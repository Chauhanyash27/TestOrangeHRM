package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_034_Qualifications_ToVerifyEducationRecordGettingDeleted extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyEducationRecordGettingDeleted() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Education.getSectionName());
        Assert.assertTrue(obj_Qualifications.deleteUser());
    }
}
