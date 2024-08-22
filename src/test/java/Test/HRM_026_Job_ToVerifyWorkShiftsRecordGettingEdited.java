package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_026_Job_ToVerifyWorkShiftsRecordGettingEdited extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyWorkShiftsRecordGettingEdited() {
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.WorkShifts.getSectionName());
        Assert.assertTrue(obj_Job.editRecord());
    }
}
