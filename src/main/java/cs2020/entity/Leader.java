package cs2020.entity;

public class Leader {
    private String leadername;
    private String password;

    public String getLeadername() {
        return leadername;
    }

    public void setLeadername(String leadername) {
        this.leadername = leadername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Leader() {
    }

    public Leader(String leadername, String password) {
        this.leadername = leadername;
        this.password = password;
    }
}
