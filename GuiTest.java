/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ryan
 */
public class GuiTest {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        
        SmallGUIFrame test = new SmallGUIFrame();
        test.setVisible(true);
        //test.drawGraph(test.getTimerRef());
        test.getPlay();
        
        //The graph only needs to be plotted at the end
        //Collect the points on the graph and store them in a big array
        //When finished pull these points out and create the graph and adjust its size as you
        //now know the time frame and the amounts added
    }
}
