/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;
import javax.swing.JButton;

/**
 *
 * @author Ryan
 */

public class Button extends JButton
{
    private static final int BUTTON_WIDTH = 60000;
    private static final int BUTTON_HEIGHT = 30;
        
    public Button(String text)
    {
        super(text);
        this.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    }
    
    public Button()
    {
        this.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    }
}
