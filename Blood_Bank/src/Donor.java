
public class Donor{
    private String donarID;
    private String DonarName;
    private String phone;
    private String bloodGroup;

    public Donor(String donarID, String donarName, String phone, String bloodGroup) {
        this.donarID = donarID;
        this.DonarName = donarName;
        this.phone = phone;
        this.bloodGroup = bloodGroup;
    }

    public String getDonarID() {
        return donarID;
    }

    public void setDonarID(String donarID) {
        this.donarID = donarID;
    }

    public String getDonarName() {
        return DonarName;
    }

    public void setDonarName(String donarName) {
        DonarName = donarName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "Dono";
    }
}