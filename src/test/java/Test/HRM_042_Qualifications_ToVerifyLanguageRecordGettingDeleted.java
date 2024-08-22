package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_042_Qualifications_ToVerifyLanguageRecordGettingDeleted extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyLanguageRecordGettingDeleted() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Languages.getSectionName());
        Assert.assertTrue(obj_Qualifications.deleteUser());
    }
}
