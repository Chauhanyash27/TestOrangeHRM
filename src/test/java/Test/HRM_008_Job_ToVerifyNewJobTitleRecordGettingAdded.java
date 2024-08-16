package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_008_Job_ToVerifyNewJobTitleRecordGettingAdded extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyNewJobTitleRecordGettingAdded(){
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.JobTitles.getSectionName());
        Assert.assertTrue(obj_Job.addJobTitle("SDET"));
    }
}
