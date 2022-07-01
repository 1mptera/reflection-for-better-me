import models.Posting;
import utils.PostingPanel;
import utils.WritingPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectionForBetterMe {
  private JFrame mainFrame;
  private JPanel contentPanel;
  private Posting posting;
  private PostingPanel postingPanel;

  private List<Posting> postings = new ArrayList<>();


  public static void main(String[] args) {
    ReflectionForBetterMe application = new ReflectionForBetterMe();
    application.run();
  }

  public void run() {

    //posting = new Posting("제목을 입력하세요.","블라블라블라");

    mainFrame = new JFrame("Reflect yourself!");
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainFrame.setSize(700,800);

    initMenu();
    initContentPanel();

    mainFrame.setVisible(true);
  }

  public void initMenu() {
    JPanel mainPanel = new JPanel();

    createPostingPanelButton();
    mainPanel.add(createPostingPanelButton());

    createWritingPanelButton();
    mainPanel.add(createWritingPanelButton());

    mainFrame.add(mainPanel, BorderLayout.PAGE_START);

  }

  public JButton createPostingPanelButton() {
    JButton button = new JButton("회고 게시판");
    button.addActionListener(event -> {
       JPanel postingPanel = new PostingPanel(postings);

      showContentPanel(postingPanel);

    });
    return button;
  }


  public JButton createWritingPanelButton() {
    JButton button = new JButton("회고 쓰러가기");
    button.addActionListener(event -> {
      JPanel writingPanel = new WritingPanel(postings);

      showContentPanel(writingPanel);

    });
    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    mainFrame.add(contentPanel);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    mainFrame.setVisible(true);
  }
}
