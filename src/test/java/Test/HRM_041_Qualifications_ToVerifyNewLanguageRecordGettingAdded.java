package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_041_Qualifications_ToVerifyNewLanguageRecordGettingAdded extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyNewLanguageRecordGettingAdded(){
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Languages.getSectionName());
        Assert.assertTrue(obj_Qualifications.addRecord("Testing Name"));
    }
}
