package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_019_Job_ToVerifyJobCategoriesRecords extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyJobCategoriesRecord(){
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.JobCategories.getSectionName());
        Assert.assertTrue(obj_Job.validateRecords());
    }
}
