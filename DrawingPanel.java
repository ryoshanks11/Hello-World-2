package guitest;

import java.awt.* ;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel
{
    ArrayList GraphingAmounts;
    
    //constructor
    public DrawingPanel(ArrayList Amounts)
    {
        this.GraphingAmounts = Amounts;
    }
   
    private int oldX = 50, oldY = 325, newX = 0, newY = 0;
            
    private int segmentSize = 25;
    private int segmentLength = 15;
    private int xBorder = 50;
    private int yBorder = 25;
    private int xLength = 600;
    private int yLength = 800;

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
            g2.drawLine(xBorder,yBorder,xBorder,yLength);
            
            //xaxis
            g2.drawLine(xBorder,yLength/2+yBorder, xBorder+xLength, yLength/2+yBorder); 
            
            //y lines
            for(int i = xBorder; i<xBorder+xLength; i+=segmentSize)
            {
                g2.setStroke(penMed);
                g2.drawLine(i,yLength/2+segmentLength+yBorder,i,yLength/2-segmentLength+yBorder);
                //Changes pen so that grid is soft lines
                g2.setStroke(penSoft); 
                g2.drawLine(i,yLength, i, yBorder);
            }
            
            //x lines
            for(int i = yBorder; i<yLength; i+=segmentSize)
            {
                g2.setStroke(penMed);
                g2.drawLine(xBorder,i,xBorder+segmentLength,i);
                g2.setStroke(penSoft);
                g2.drawLine(xBorder+segmentLength,i,xBorder+xLength,i);
            }
            
            //drawing a line. Must only run once or else a line will be created between the last and first point
            //CHANGE TO MAKE IT SO THAT IT IS A CUMULATIVE TOTAL IN THE ACCOUNT
            for (int i=0; i<GraphingAmounts.size(); i++)
            {
                Integer cuurentAmount = (Integer) GraphingAmounts.get(i);
                g2.drawLine(oldX,oldY,(segmentSize*i)+xBorder,((cuurentAmount*-1)-425)/8);
                oldX = (segmentSize*i)+xBorder;
                oldY = ((cuurentAmount*-1)-425)/8;
            }
            
            //Adding a point
            g2.setStroke(pen);
            g2.setColor(Color.BLACK);
            //g2.drawOval(x-12,y-12,25,25);
        }
}