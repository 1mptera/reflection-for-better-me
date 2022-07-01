package utils;

import models.Posting;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PostingPanel extends JPanel {


  private JTextField titleTextField;

  public PostingPanel(List<Posting> postings) {
    this.setSize(500, 600);
    this.setLocation(250, 300);

    JLabel mainLabel = new JLabel("회고를 위한 게시판입니다.");
    mainLabel.setBounds(300, 200, 100, 30);

    this.add(mainLabel);

    JPanel contentPanel2 = new JPanel();
    postings.stream().
        forEach(posting -> {
          JButton buttonOriginal = new JButton(posting.getTitle());
          buttonOriginal.addActionListener(event -> {
            JFrame frame = new JFrame(posting.getTitle());
            frame.setSize(500, 600);
            JPanel panel = new JPanel();
            frame.add(panel);

            JTextField titleTextField = new JTextField(posting.getTitle(), 25);
            titleTextField.setEditable(false);
            panel.add(titleTextField, BorderLayout.PAGE_START);


            JTextArea contentTextArea = new JTextArea(posting.getContent(), 30, 40);
            contentTextArea.setEditable(false);
            panel.add(contentTextArea, BorderLayout.CENTER);

            //수정하기 버튼 액션
            JButton editButton = new JButton("수정하기");
            panel.add(editButton, BorderLayout.PAGE_END);
            editButton.addActionListener(event2 -> {
              titleTextField.setEditable(true);
              contentTextArea.setEditable(true);
              //수정부분




              //수정완료 버튼 액션
              JButton editCompleteButton = new JButton("수정완료");
              panel.add(editCompleteButton, BorderLayout.PAGE_END);
              editCompleteButton.addActionListener(event3 -> {
                titleTextField.setEditable(false);
                contentTextArea.setEditable(false);
                editCompleteButton.setVisible(false);
              });
            });


            frame.setVisible(true);
          });


          this.add(buttonOriginal, BorderLayout.CENTER);


        });
  }

  private String getText(JTextField titleTextField) {
    return titleTextField.getText();
  }
}



