package hw13tasks.hw13task2;

public class PostPOJO {

    public int userId;
    public int id;
    public String title;
    public String body;

    public PostPOJO(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "PostPOJO{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}


