package entity.demo;

public class User {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public User() {
    }

    public User(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
