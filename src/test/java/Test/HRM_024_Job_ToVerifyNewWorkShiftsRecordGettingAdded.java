package Test;

import Pages.Admin.Job;
import Utility.Base;
import Utility.JobSections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRM_024_Job_ToVerifyNewWorkShiftsRecordGettingAdded extends Base {
    Job obj_Job;

    @Test
    public void ToVerifyNewWorkShiftsRecordGettingAdded(){
        obj_Job = new Job(page);
        obj_Job.navigateToSection(JobSections.WorkShifts.getSectionName());
        Assert.assertTrue(obj_Job.addWorkShifts("Day"));
    }
}
