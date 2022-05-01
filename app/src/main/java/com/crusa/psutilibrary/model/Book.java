package com.crusa.psutilibrary.model;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("id")
    private Long id;

    @SerializedName("title")
    private String title;

    @SerializedName("author")
    private Author author;

    @SerializedName("faculty")
    private Faculty faculty;

    @SerializedName("semester")
    private Integer semester;

    @SerializedName("downloadLink")
    private String downloadLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
