package com.dojinyou.javajungsuk.operator;

import java.util.List;

public class LineJoin {
    private Long id;
    // ctrl + shift + j 를 통해서 문자열을 합칠 수 있다.
    public String joinString() {
        String profile = "안녕하세요 IntelliJ 강의에 오신 것을 환영합니다. ";
        return profile;
    }

    public String createQuery(String name) {
        String query = "SELECT * "+
                "FROM member " +
                "WHERE member.name = " +  name;
        return query;
    }
    private void extractMethod(List<Book> books) {
        for (Book book : books) {
            loopAuthors(book);
        }
    }

    private void loopAuthors(Book book) {
        for (String author : book.getAuthors()) {
            print(author);
        }
    }

    private void print(String author) {
        String format = "담당자가 맞습니다.";
        if ("dojinyou".equals(author)) {
            System.out.printf(format);
        }
    }


    public static class Book {
        private String title;
        private long price;
        private List<String> authors;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public List<String> getAuthors() {
            return authors;
        }
        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }


    }
}
