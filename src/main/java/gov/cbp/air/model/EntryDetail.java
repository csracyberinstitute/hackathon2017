package gov.cbp.air.model;

/**
 * Created by ramchalasani on 3/27/17.
 */
public class EntryDetail  {

    private String entryTypeCode;
    private String entryNumber;

    public String getEntryTypeCode() {
        return entryTypeCode;
    }

    public void setEntryTypeCode(String entryTypeCode) {
        this.entryTypeCode = entryTypeCode;
    }

    public String getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(String entryNumber) {
        this.entryNumber = entryNumber;
    }

    @Override
    public String toString() {
        return "EntryDetail{" +
                "entryTypeCode='" + entryTypeCode + '\'' +
                ", entryNumber='" + entryNumber + '\'' +
                '}';
    }
}
