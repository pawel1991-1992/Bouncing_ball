import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JOptionPane;

/**
 * Write a description of class second here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
@SuppressWarnings("serial")
public class second extends JPanel implements ActionListener, MouseListener,MouseMotionListener
{
    Timer t = new Timer(5, this);
    double x=0,y=0,velX=2,velY=2;
    double xx=1,yy=1;
    int zliczak=0, ans;
    boolean pauza=false;
    Rectangle2D rectangle = new Rectangle2D.Double(xx,500,120,30);
    
    
    
    public second()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x,y,40,40);
        g2.fill(circle);
        g2.fill(rectangle);
        t.start();
    }
    public void actionPerformed(ActionEvent e)
    {
        if (x < 0 || x > 760) 
        {
            velX = - velX;
            
        }
        if(y < 0)
        {
            velY = -velY;
            
        }
        if(x>xx && x<xx+160)
        {
            if(y>460)
            {
             velY = -velY;
             zliczak++;
             if(zliczak==4)
             {
                 x=0;
                 y=0;
                 velX=3;
                 velY=3;
                 JOptionPane.showConfirmDialog(null, "Level 2", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==10)
             {
                 x=0;
                 y=0;
                 velX=4;
                 velY=4;
                 JOptionPane.showConfirmDialog(null, "Level 3", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==18)
             {
                 x=0;
                 y=0;
                 velX=5;
                 velY=5;
                 JOptionPane.showConfirmDialog(null, "Level 4", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==28)
             {
                 x=0;
                 y=0;
                 velX=6;
                 velY=6;
                 JOptionPane.showConfirmDialog(null, "Level 5", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==40)
             {
                 x=0;
                 y=0;
                 velX=7;
                 velY=7;
                 JOptionPane.showConfirmDialog(null, "Level 6", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==54)
             {
                 x=0;
                 y=0;
                 velX=8;
                 velY=8;
                 JOptionPane.showConfirmDialog(null, "Level 7", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==70)
             {
                 x=0;
                 y=0;
                 velX=9;
                 velY=9;
                 JOptionPane.showConfirmDialog(null, "Level 8", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==98)
             {
                 x=0;
                 y=0;
                 velX=10;
                 velY=10;
                 JOptionPane.showConfirmDialog(null, "Level 9", "Gra", JOptionPane.DEFAULT_OPTION);
             }
             else if(zliczak==118)
             {
                 x=0;
                 y=0;
                 velX=11;
                 velY=11;
                 JOptionPane.showConfirmDialog(null, "Level 10", "Gra", JOptionPane.DEFAULT_OPTION);
             }
            }
        }
        if(y>480)
            {
               ans=JOptionPane.showConfirmDialog(null, "GAME OVER \n Chcesz rozpocząć grę od nowa?", "Gra", JOptionPane.YES_NO_OPTION);
               y=0;
               if(ans==JOptionPane.YES_OPTION)
               {
                   ans=0;
                   
                   pauza=false;
                   y=0;
                   x=0;
                   velX=2;
                   velY=2;
                   zliczak=0;
                   JOptionPane.showConfirmDialog(null, "Level 1", "Gra", JOptionPane.DEFAULT_OPTION);
               }
               else
               {
                  Menu k = new Menu();
                  k.CloseGame();
                  ans=0;
                  y=0;
                  x=0;
                  zliczak=0;
                  pauza=true;
               }
            }
        
        if(pauza==false){
        x += velX;
        y += velY;
        repaint();
        }
        
    }
    public void mouseDragged(MouseEvent e)
    {
        xx=e.getX()-80;
        yy=e.getY();
        rectangle.setFrame(xx,500,160,30);
        repaint();
    } 
    public void mouseMoved(MouseEvent e)
    {
       
    }
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
