package nl.stefandv.level_3_assignment;

public class Portal {

    String portalUrl;
    String portalTitle;

    public Portal(String portalUrl, String portalTitle) {
        this.portalUrl = portalUrl;
        this.portalTitle = portalTitle;

    }

    public String getPortalTitle() {
        return portalTitle;
    }

    public String getPortalUrl() {
        return portalUrl;
    }

}
