package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_020_Job_ToVerifyNewJobCategoriesRecordGettingAdded extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyNewJobCategoriesRecordGettingAdded() {
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.JobCategories.getSectionName());
        Assert.assertTrue(obj_Job.addRecord("Testing Record"));
    }
}
