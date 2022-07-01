package utils;

import models.Posting;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WritingPanel extends JPanel {

  private JFrame writingFrame;
  private JTextField titleTextField;
  private JTextArea contentTextArea;
  private List<Posting> postings;




  public WritingPanel(List<Posting> postings) {
    this.postings = postings;

    JButton writingButton = createWriteButton();
    this.add(writingButton);
  }


  private JButton createWriteButton() {
    JButton button = new JButton("글 작성");

    button.addActionListener(event -> {
      writingFrame = new JFrame("오늘의 회고");
      writingFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      writingFrame.setSize(500,600);

      JPanel panel = new JPanel();
      writingFrame.add(panel);

      String frameTitle = "제목을 입력하세요.";

      titleTextField = new JTextField(frameTitle,25);
      panel.add(titleTextField,BorderLayout.PAGE_START);


      contentTextArea = new JTextArea("내용을 입력하세요.",30,40);
      panel.add(contentTextArea,BorderLayout.CENTER);

      createRegisterButton();
      panel.add(createRegisterButton(),BorderLayout.PAGE_END);



      writingFrame.setVisible(true);


    });
    return button;
  }


  public JButton createRegisterButton() {
    JButton button =new JButton("작성한 글 등록하기");
    button.addActionListener(event -> {
     // createPostingButton();
      //(PostingPanel.add
      //창이 꺼진다
      //글쓰기 에서 쓴글을 -> 게시판 글로 옮겨온다
      //버튼 1 게시물2 게시물3
      Posting posting = new Posting(getTitle(),getContent());
      postings.add(posting);


      writingFrame.setVisible(false);

    });
    return button;
  }

  public String getContent() {
    return contentTextArea.getText();
  }

  public String getTitle() {
    return titleTextField.getText();
  }


}
