package swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class Swing {

    public static void main(String[] args) {
        Runnable thread = new Runnable() {
            public void run() {
                criarGUI();
            }
        };
        SwingUtilities.invokeLater(thread);
    }

    public static void criarGUI() {
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(400, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Swing App 03");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        JCheckBox checkBox01 = new JCheckBox("Item 0l");
        panel.add(checkBox01);
        JCheckBox checkBox02 = new JCheckBox("Item 02");
        panel.add(checkBox02);
        JButton button2 = new JButton("Botão 02");
        panel.add(button2);
        JRadioButton radio01 = new JRadioButton("Opção 01");
        panel.add(radio01);
        JRadioButton radio02 = new JRadioButton("Opção 02");
        panel.add(radio02);
        ButtonGroup group = new ButtonGroup();
        group.add(radio01);
        group.add(radio02);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Item 01 Selecionado: " + checkBox01.isSelected()
                        + "\nItem 02 Selecionado: " + checkBox02.isSelected());
            }
        });
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Selecionado");
                } else {
                    System.out.println("Não Seleconado");
                }
            }
        };
        JButton button3 = new JButton("Button 03");
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Item 0; Selecionado: "
                        + checkBox01.isSelected() + "\nItem 02 Selecionado: "
                        + checkBox02.isSelected() + "\n Opgéo 0;: " + radio01.isSelected()
                        + "\nCódigo 02: " + radio02.isSelected());
            }
        });
        checkBox01.addItemListener(itemListener);
        checkBox02.addItemListener(itemListener);
        frame.pack();
        frame.setVisible(true);
    }
}
