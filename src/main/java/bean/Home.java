package bean;

public class Home {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Home{" +
                "name='" + name + '\'' +
                '}';
    }
}
