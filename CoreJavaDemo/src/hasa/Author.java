package hasa;

public class Author {
    private String name;
    private String email;
    private String linkenid;

    public Author(String name, String email, String linkenid) {
        this.name = name;
        this.email = email;
        this.linkenid = linkenid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkenid() {
        return linkenid;
    }

    public void setLinkenid(String linkenid) {
        this.linkenid = linkenid;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", linkenid='" + linkenid + '\'' +
                '}';
    }
}
