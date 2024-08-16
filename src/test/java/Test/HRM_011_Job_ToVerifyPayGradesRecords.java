package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_011_Job_ToVerifyPayGradesRecords extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyPayGradesRecords(){
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.PayGrades.getSectionName());
        Assert.assertTrue(obj_Job.validateRecords());
    }
}
