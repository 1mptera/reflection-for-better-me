package models;

public class Posting {
  private String title;
  private String content;
  private String titleTextField;

  public Posting(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return this.title;
  }

  public String getContent() {
    return this.content;
  }


  }


