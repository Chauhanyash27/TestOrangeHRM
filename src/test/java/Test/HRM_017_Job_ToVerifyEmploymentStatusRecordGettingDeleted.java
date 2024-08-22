package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_017_Job_ToVerifyEmploymentStatusRecordGettingDeleted extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyEmploymentStatusRecordGettingDeleted() {
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.EmploymentStatus.getSectionName());
        Assert.assertTrue(obj_Job.deleteUser());
    }
}
