package com.example.booksapi;

/**
 * Book
 * A custom class to store Book information
 */
class Book {

    final String title;
    final String authors;
    final String smallThumbnailLink;
    final String rating;
    final String publishedDate;
    final String pages;


    public Book(
            String title,
            String authors,
            String smallThumbnailLink,
            String rating,
            String publishedDate,
            String pages
    ) {

        this.title = title;
        this.authors = authors;
        this.smallThumbnailLink = smallThumbnailLink;
        this.rating=rating;
        this.publishedDate=publishedDate;
        this.pages = pages;
    }

}
