package cs2020.entity;

public class Team {
    private Integer id;
    private String tname;
    private double tfee;
    private Integer needs;
    private Integer been;
    private String leader;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public double getTfee() {
        return tfee;
    }

    public void setTfee(double tfee) {
        this.tfee = tfee;
    }

    public Integer getNeeds() {
        return needs;
    }

    public void setNeeds(Integer needs) {
        this.needs = needs;
    }

    public Integer getBeen() {
        return been;
    }

    public void setBeen(Integer been) {
        this.been = been;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
}
