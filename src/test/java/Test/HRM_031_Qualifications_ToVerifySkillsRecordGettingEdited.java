package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_031_Qualifications_ToVerifySkillsRecordGettingEdited extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyNewSkillsRecordGettingAdded() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Skills.getSectionName());
        Assert.assertTrue(obj_Qualifications.editRecord());
    }
}
