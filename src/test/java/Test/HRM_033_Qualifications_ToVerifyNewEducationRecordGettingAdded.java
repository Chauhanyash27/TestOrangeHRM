package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_033_Qualifications_ToVerifyNewEducationRecordGettingAdded extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyNewEducationRecordGettingAdded(){
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Education.getSectionName());
        Assert.assertTrue(obj_Qualifications.addEducationRecord("Testing Level"));
    }
}
