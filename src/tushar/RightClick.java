package tushar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
public class RightClick extends JFrame {
  JPopupMenu menu = new JPopupMenu("Popup");

  class MyLabel extends JLabel {
    public MyLabel(String text) {
      super(text);
      addMouseListener(new PopupTriggerListener());
    }

    class PopupTriggerListener extends MouseAdapter {
      public void mousePressed(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseReleased(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseClicked(MouseEvent ev) {
      }
    }
  }

  JLabel label = new MyLabel("right-click");

  public RightClick() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton Open = new JButton("     Open     ");
    Open.setSize(50,10);
    Open.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Menu item Test1");
      }
    });
    menu.add(Open);

    JButton Cut = new JButton("       Cut       ");
    Cut.setSize(50,10);
    Cut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Menu item Test1");
      }
    });
    menu.add(Cut);
    
    JButton Copy = new JButton("      Copy     ");
    Copy.setSize(50,10);
    Copy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Menu item Test1");
      }
    });
    menu.add(Copy);
    JButton Paste = new JButton("    Paste     ");
    Paste.setSize(50,10);
    Paste.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Menu item Test1");
      }
    });
    menu.add(Paste);
    JButton Delete = new JButton("    Delete    ");
    Delete.setSize(50,10);
    Delete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Menu item Test1");
      }
    });
    menu.add(Delete);
    JButton Rename = new JButton("   Rename ");
    Rename.setSize(50,10);
    Rename.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Menu item Test1");
      }
    });
    menu.add(Rename);
    JButton Properties = new JButton("properties");
    Properties.setSize(50,10);
    Properties.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Menu item Test1");
      }
    });
    menu.add(Properties);

    getContentPane().add(label);
    pack();
    setSize(300, 100);
  }

  public static void main(String[] args) {
    new RightClick().setVisible(true);
  }
}