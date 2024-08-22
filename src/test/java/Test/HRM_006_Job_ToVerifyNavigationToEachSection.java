package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

class HRM_006_Job_ToVerifyNavigationToEachSection extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyNavigationToEachSection() {
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.JobTitles.getSectionName());
        Assert.assertTrue(obj_Job.sectionNavigationVerification(JobSections.JobTitles.getSectionName()));

        obj_Job.navigateToSection(JobSections.PayGrades.getSectionName());
        Assert.assertTrue(obj_Job.sectionNavigationVerification(JobSections.PayGrades.getSectionName()));

        obj_Job.navigateToSection(JobSections.EmploymentStatus.getSectionName());
        Assert.assertTrue(obj_Job.sectionNavigationVerification(JobSections.EmploymentStatus.getSectionName()));

        obj_Job.navigateToSection(JobSections.JobCategories.getSectionName());
        Assert.assertTrue(obj_Job.sectionNavigationVerification(JobSections.JobCategories.getSectionName()));
    }
}
