package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_018_Job_ToVerifyEmploymentStatusRecordGettingEdited extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyEmploymentStatusRecordGettingEdited (){
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.EmploymentStatus.getSectionName());
        Assert.assertTrue(obj_Job.editRecord());
    }
}
