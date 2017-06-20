package gov.cbp.air.model;

/**
 * Created by ramchalasani on 3/27/17.
 */
public class Amendment  {

    private String amendmentCode;
    private String description;


    public String getAmendmentCode() {
        return amendmentCode;
    }

    public void setAmendmentCode(String amendmentCode) {
        this.amendmentCode = amendmentCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Amendment{" +
                "amendmentCode='" + amendmentCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
