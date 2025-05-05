package techgatha.model;

//
public class Plan {
    private String name;
    private double callRate, smsRate, dataRate;

    public Plan(String name, double callRate, double smsRate, double dataRate) {
        this.name = name;
        this.callRate = callRate;
        this.smsRate = smsRate;
        this.dataRate = dataRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCallRate() {
        return callRate;
    }

    public void setCallRate(double callRate) {
        this.callRate = callRate;
    }

    public double getSmsRate() {
        return smsRate;
    }

    public void setSmsRate(double smsRate) {
        this.smsRate = smsRate;
    }

    public double getDataRate() {
        return dataRate;
    }

    public void setDataRate(double dataRate) {
        this.dataRate = dataRate;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", callRate=" + callRate +
                ", smsRate=" + smsRate +
                ", dataRate=" + dataRate +
                '}';
    }
}
