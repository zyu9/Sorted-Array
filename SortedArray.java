import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
/**
 * Write a description of class SortedArray here.
 *
 * @author (Zhiyan Yu)
 * @version (9/24/2020)
 */
public class SortedArray 
{
    JButton button;
    JTextArea text;
    public static void main(String[] args){
        SortedArray sortedArray = new SortedArray();
        sortedArray.run(); 
    }
    
    public void run(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        text = new JTextArea(10,20);
        text.setLineWrap(true);
        JScrollPane acroller = new JScrollPane(text);
        acroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        acroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        text.setText("");
        button = new JButton("Sort");
        button.addActionListener(new ButtonListener());
        
        panel.add(acroller);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        
        frame.setSize(350,300);
        frame.setVisible(true);
    }
    
    class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        try{
           Sort sort = new Sort(); 
           text.append(sort.runAndResult(0) + "\n");
           button.setText("Sorted!");
        }catch(Exception e){
           e.printStackTrace(); 
        }
      }
    }
}
