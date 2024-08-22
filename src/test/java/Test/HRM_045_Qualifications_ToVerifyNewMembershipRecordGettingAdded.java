package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_045_Qualifications_ToVerifyNewMembershipRecordGettingAdded extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyNewMembershipRecordGettingAdded() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Memberships.getSectionName());
        Assert.assertTrue(obj_Qualifications.addRecord("Testing Name"));
    }
}
