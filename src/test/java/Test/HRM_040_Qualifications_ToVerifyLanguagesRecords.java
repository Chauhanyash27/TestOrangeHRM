package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_040_Qualifications_ToVerifyLanguagesRecords extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyLanguagesRecords() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Languages.getSectionName());
        Assert.assertTrue(obj_Qualifications.validateRecords());
    }
}
