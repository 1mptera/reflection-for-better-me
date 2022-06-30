package utils;

import javax.swing.*;
import java.awt.*;

public class WritingPanel extends JPanel {
  public WritingPanel() {

    JButton writingButton = createWriteButton();
    this.add(writingButton);
  }

  private JButton createWriteButton() {
    JButton button = new JButton("글 작성");

    button.addActionListener(event -> {
      JFrame writingFrame = new JFrame("오늘의 회고");
      writingFrame.setSize(500,600);

      JPanel panel = new JPanel();
      writingFrame.add(panel);


      JTextField textField = new JTextField("제목을 입력하세요.",25);
      panel.add(textField,BorderLayout.PAGE_START);

      JTextArea textArea = new JTextArea("내용을 입력하세요.",30,40);
      panel.add(textArea,BorderLayout.CENTER);

      createRegisterButton();
      panel.add(createRegisterButton(),BorderLayout.PAGE_END);


      writingFrame.setVisible(true);


    });
    return button;
  }

  private JButton createRegisterButton() {
    JButton button =new JButton("작성한 글 등록하기");
    button.addActionListener(event -> {

    });
    return button;
  }

}
