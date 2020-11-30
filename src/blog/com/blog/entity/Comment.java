package blog.com.blog.entity;

/**
 * 评论实体
 */
public class Comment {
    private String id ;
    //评论用户Id
    private String userId;
    private String commentText;

    public Comment() {
    }

    public Comment(String id, String userId, String commentText) {
        this.id = id;
        this.userId = userId;
        this.commentText = commentText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
