package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_047_Qualifications_ToVerifyMembershipRecordGettingEdited extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyMembershipRecordGettingEdited() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Memberships.getSectionName());
        Assert.assertTrue(obj_Qualifications.editRecord());
    }
}
