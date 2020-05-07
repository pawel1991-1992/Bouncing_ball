package bouncing_ball;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;

/**
 * Write a description of class Menu here.
 * 
 * @author pawel1991-1992 
 * @version V1.0.1
 */
@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener
{
    
    
    JFrame f1 = new JFrame();
    JFrame f2 = new JFrame();
    Game s = new Game();
    int odp;

    JMenuBar menuBar;
    JMenu menuMenu, menuPomoc;
    JMenuItem mNowaGra, mPauza, mResume, mExit, mInstrukcja;
    
    
    
    
    public Menu()
    {
        
        f1.setVisible(true);
        f1.setSize(800,600);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setTitle("Moving Ball");
        
        
        menuBar = new JMenuBar();
        menuMenu = new JMenu("Menu");
        menuPomoc = new JMenu("Pomoc");
        
        mNowaGra = new JMenuItem("Nowa gra");
        mNowaGra.addActionListener(this);
        mPauza = new JMenuItem("Pauza");
        mPauza.addActionListener(this);
        mResume = new JMenuItem("Wznów");
        mResume.addActionListener(this);
        mExit = new JMenuItem("Wyjście");
        mExit.addActionListener(this);
        mInstrukcja = new JMenuItem("Instrukcja");
        mInstrukcja.addActionListener(this);
        
        menuMenu.add(mNowaGra);
        menuMenu.add(mPauza);
        menuMenu.add(mResume);
        menuMenu.add(mExit);
        menuPomoc.add(mInstrukcja);
        
        f1.setJMenuBar(menuBar);
        menuBar.add(menuMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menuPomoc);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object z = e.getSource(); 

        if(z==mNowaGra)
        {
            odp = JOptionPane.showConfirmDialog(null, "Level 1", "Gra", JOptionPane.DEFAULT_OPTION);
            if(odp==JOptionPane.OK_OPTION)
            {
            NowaGra();
            s.pauza=false;
            }
        else if (odp==JOptionPane.CLOSED_OPTION)
        {
            f2.dispose();
            f1.setVisible(true);
        }
        }
        
        if(z==mPauza)
        {
            s.pauza=true;
        }
        if(z==mResume)
        {
            s.pauza=false;
        }
        if(z==mExit)
        {
           CloseMenu();
        }
        if(z==mInstrukcja)
        {
            JOptionPane.showMessageDialog(null,"Gra polega na odbijaniu piłki belką znajdującą się u dołu ekranu. Możemy nią sterować \n lewym przyciskiem myszy - przeciągamy nim  w w płaszczyźnie poziomiej belkę w kierunku jakim chcemy.\nNową Grę zaczynamy opcją w Menu, do przebycia jest 10 poziomów :-)","Instrukcja",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String args[])
    {
        Menu appMenu = new Menu();
        appMenu.setVisible(false);
        
        
    }
    public void NowaGra() 
    {
            f1.dispose();
            f2.add(s);
            f2.setSize(800,600);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f2.setTitle("Moving Ball");
            f2.setVisible(true);
            f2.setJMenuBar(menuBar);
            s.x=0;
            s.y=0;
    }
    public void CloseMenu()
    {
        f1.dispose();
        f2.dispose();
    }
    public void CloseGame()
    {
        f2.dispose();
    }
    
}
