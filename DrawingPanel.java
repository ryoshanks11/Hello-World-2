package guitest;

import java.awt.* ;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel
{
    public DrawingPanel(ArrayList Amounts)
    {
    }
    
    private int x = 50, y = 10;
    private int SegmentSize = 50;
    private int SegmentLength = 15;

    @Override
    public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g ;
            super.paintComponent(g2) ;
            BasicStroke pen = new BasicStroke(4F) ;
            BasicStroke penSoft = new BasicStroke(1F) ;
            BasicStroke penMed = new BasicStroke(2F) ;
            
            g2.setStroke(pen);            
            
            //Draws the Graph with no points
            
            g2.setColor(Color.BLACK);
            //yaxis
            g2.drawLine(50,50,50,600);
            
            //xaxis
            g2.drawLine(50, 600, 650, 600); 
            
            //y lines
            for(int i = 50; i<650; i+=SegmentSize)
            {
                g2.setStroke(penMed);
                g2.drawLine(i,600,i,600-SegmentLength);
                //Changes pen so that grid is soft lines
                g2.setStroke(penSoft); 
                g2.drawLine(i,600-SegmentLength, i, 50);
            }
            
            //x lines
            for(int i = 50; i<600; i+=SegmentSize)
            {
                g2.setStroke(penMed);
                g2.drawLine(50,i,50+SegmentLength,i);
                g2.setStroke(penSoft);
                g2.drawLine(50+SegmentLength,i,650,i);
            }
            
            //drawing a line
            for(i=0;, i>Amounts.size();)
            {
                
            }
            
            //Adding a point
            g2.setStroke(pen);
            g2.setColor(Color.BLACK);
            g2.drawOval(x-12,y-12,25,25);
        }
    
    public void amount(int newX,int newY)
    {
        // Establish new position at which
        // to plot shapes
        
        x = newX ;
        y = newY ;
        
        // Then call repaint, which will invoke
        // The paintComponent() method.
        
        repaint() ;
    }
}