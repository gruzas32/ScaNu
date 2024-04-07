package entity;

import jakarta.persistence.*;

@Entity
public class Rating {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ratingId")
    private int ratingId;
    @Basic
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "recipeId")
    private int recipeId;
    @Basic
    @Column(name = "rating")
    private int rating;
    @Basic
    @Column(name = "comment")
    private String comment;

    public Rating(int ratingId, int userId, int recipeId, int rating, String comment){
        this.ratingId = ratingId;
        this.userId = userId;
        this.recipeId = recipeId;
        this.rating = rating;
        this.comment = comment;
    }

    public Rating() {
    }

    public int getRatingId() {
        return ratingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRecipeId(int productId) {
        this.recipeId = productId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
