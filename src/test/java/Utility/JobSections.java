package Utility;

public enum JobSections {

    JobTitles("Job Titles"),
    PayGrades("Pay Grades"),
    EmploymentStatus("Employment Status"),
    JobCategories("Job Categories"),
    WorkShifts("Work Shifts");

    public String Sections;

    JobSections(String Sections) {
        this.Sections = Sections;
    }

    public String getSectionName() {
        return Sections;
    }
}
