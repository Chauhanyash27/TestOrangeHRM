package Utility;

public enum QualificationSections {

    Skills("Skills"),
    Education("Education"),
    Licenses("Licenses"),
    Languages("Languages"),
    Memberships("Memberships");

    public String Sections;

    QualificationSections(String Sections) {
        this.Sections = Sections;
    }

    public String getSectionName() {
        return Sections;
    }
}
