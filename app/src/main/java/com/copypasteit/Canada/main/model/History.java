package com.copypasteit.Canada.main.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class History {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("post_title")
    @Expose
    private String postTitle;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("post_slug")
    @Expose
    private String postSlug;
    @SerializedName("post_details")
    @Expose
    private String postDetails;
    @SerializedName("post_image_url")
    @Expose
    private String postImageUrl;
    @SerializedName("post_image")
    @Expose
    private String postImage;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public String getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(String postDetails) {
        this.postDetails = postDetails;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "History{" +
                "id='" + id + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", postSlug='" + postSlug + '\'' +
                ", postDetails='" + postDetails + '\'' +
                ", postImageUrl='" + postImageUrl + '\'' +
                ", postImage='" + postImage + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
