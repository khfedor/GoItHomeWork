package hw13tasks.hw13task2;

public class ComentsPOJO {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;

    public ComentsPOJO(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    @Override
    public String toString() {
        return "ComentsPOJO{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
