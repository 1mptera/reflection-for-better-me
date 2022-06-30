import utils.PostingPanel;
import utils.WritingPanel;

import javax.swing.*;
import java.awt.*;

public class ReflectionForBetterMe {
  private JFrame mainFrame;
  private JPanel contentPanel;

  public static void main(String[] args) {


    ReflectionForBetterMe application = new ReflectionForBetterMe();
    application.run();
  }

  public void run() {
    mainFrame = new JFrame("Reflect yourself!");
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainFrame.setSize(700,800);

    initMenu();
    initContentPanel();

    mainFrame.setVisible(true);
  }

  public void initMenu() {
    JPanel panel = new JPanel();

    createPostingPanelButton();
    panel.add(createPostingPanelButton());

    createWritingPanelButton();
    panel.add(createWritingPanelButton());

    mainFrame.add(panel, BorderLayout.PAGE_START);

  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    mainFrame.add(contentPanel);
  }

  public JButton createPostingPanelButton() {
    JButton button = new JButton("회고 게시판");
    button.addActionListener(event -> {
      JPanel postingPanel = new PostingPanel();

      contentPanel.removeAll();
      contentPanel.add(postingPanel);
      mainFrame.setVisible(true);

    });
    return button;
  }

  public JButton createWritingPanelButton() {
    JButton button = new JButton("회고 쓰러가기");
    button.addActionListener(event -> {
      JPanel writingPanel = new WritingPanel();
      contentPanel.removeAll();
      contentPanel.add(writingPanel);
      mainFrame.setVisible(true);

    });
    return button;
  }
}
