package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_043_Qualifications_ToVerifyLanguageRecordGettingEdited extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyLanguageRecordGettingEdited() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Languages.getSectionName());
        Assert.assertTrue(obj_Qualifications.editRecord());
    }
}
