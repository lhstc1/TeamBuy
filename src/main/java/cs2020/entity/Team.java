package cs2020.entity;

public class Team {
    private Integer id;
    private String name;
    private String leader;
    private double fee;
    private Integer sum;
    private double pfee;
    private double tfee;
    private String elsefee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public double getPfee() {
        return pfee;
    }

    public void setPfee(double pfee) {
        this.pfee = pfee;
    }

    public double getTfee() {
        return tfee;
    }

    public void setTfee(double tfee) {
        this.tfee = tfee;
    }

    public String getElsefee() {
        return elsefee;
    }

    public void setElsefee(String elsefee) {
        this.elsefee = elsefee;
    }
}
