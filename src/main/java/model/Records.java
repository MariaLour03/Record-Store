package model;

public class Records {

    private int id;
    private int catalogueNum;
    private String recordName;

    // constructors
    public Records() {
        this.id = 0;
        this.catalogueNum = 0;
        this.recordName = "";
    }

    public Records(int catalogueNum, String recordName) {
        this.catalogueNum = catalogueNum;
        this.recordName = recordName;
    }

    public Records(int id, int catalogueNum, String recordName) {
        this.id = id;
        this.catalogueNum = catalogueNum;
        this.recordName = recordName;
    }
    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatalogueNum() {
        return catalogueNum;
    }

    public void setCatalogueNum(int catalogueNum) {
        this.catalogueNum = catalogueNum;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", catalogueNum='" + catalogueNum + '\'' +
                ", recordName='" + recordName + '\'' +
                '}';
    }
}
