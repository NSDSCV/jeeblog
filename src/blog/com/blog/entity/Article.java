package blog.com.blog.entity;

/**
 * ��������ʵ��
 */
public class Article {

    private String artId;
    private String artName;
    private String artText;
    //����Id
    private String userId;

    public Article(){

    }

    public Article(String artId, String artName, String artText, String userId) {
        this.artId = artId;
        this.artName = artName;
        this.artText = artText;
        this.userId = userId;
    }

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getArtText() {
        return artText;
    }

    public void setArtText(String artText) {
        this.artText = artText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "artId='" + artId + '\'' +
                ", artName='" + artName + '\'' +
                ", artText='" + artText + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
