package Utility;

public enum OrganizationSections {

    GeneralInformation("General Information"),
    Locations("Locations"),
    Structure("Structure");

    public String Sections;

    OrganizationSections(String Sections) {
        this.Sections = Sections;
    }

    public String getSectionName() {
        return Sections;
    }
}
