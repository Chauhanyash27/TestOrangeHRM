package Test;

import Pages.Admin.Qualifications;
import Utility.Base;
import Utility.QualificationSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_027_Qualifications_ToVerifyNavigationToEachSection extends Base {

    Qualifications obj_Qualifications;

    @Test
    public void ToVerifyNavigationToEachSection() {
        obj_Qualifications = new Qualifications(page);
        obj_Qualifications.navigateToSection(QualificationSections.Skills.getSectionName());
        Assert.assertTrue(obj_Qualifications.sectionNavigationVerification(QualificationSections.Skills.getSectionName()));

        obj_Qualifications.navigateToSection(QualificationSections.Education.getSectionName());
        Assert.assertTrue(obj_Qualifications.sectionNavigationVerification(QualificationSections.Education.getSectionName()));

        obj_Qualifications.navigateToSection(QualificationSections.Licenses.getSectionName());
        Assert.assertTrue(obj_Qualifications.sectionNavigationVerification(QualificationSections.Licenses.getSectionName()));

        obj_Qualifications.navigateToSection(QualificationSections.Languages.getSectionName());
        Assert.assertTrue(obj_Qualifications.sectionNavigationVerification(QualificationSections.Languages.getSectionName()));

        obj_Qualifications.navigateToSection(QualificationSections.Memberships.getSectionName());
        Assert.assertTrue(obj_Qualifications.sectionNavigationVerification(QualificationSections.Memberships.getSectionName()));
    }
}
