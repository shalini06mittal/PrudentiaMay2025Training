package techgatha.model;

abstract public class User {
    private String mobileNumber;
    private String name;
    private Plan plan;

    public User(String mobileNumber, String name, Plan plan) {
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.plan = plan;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "User{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", name='" + name + '\'' +
                ", plan=" + plan +
                '}';
    }
}

