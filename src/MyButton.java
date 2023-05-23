import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends Button implements ActionListener {
    public MyButton(int x, int y, int buttonNum) {
        super(Integer.toString(buttonNum));
        setLocation(x, y);
        setSize(Window.BUTTON_WIDTH, Window.BUTTON_HEIGHT);
        addActionListener(this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Point location = getLocation();
        int x = (int) location.getX();
        int y = (int) location.getY();
        if (x == Window.getEmptyPlace().x) {
            if (y < Window.getEmptyPlace().y) {
                if (y + Window.BUTTON_HEIGHT == Window.getEmptyPlace().y) {
                    setLocation(x, y + Window.BUTTON_HEIGHT);
                    Window.getEmptyPlace().setLocation(x, y);
                }
            } else {
                if (y - Window.BUTTON_HEIGHT == Window.getEmptyPlace().y) {
                    setLocation(x, y - Window.BUTTON_HEIGHT);
                    Window.getEmptyPlace().setLocation(x, y);
                }
            }
        } else if (y == Window.getEmptyPlace().y) {
            if (x < Window.getEmptyPlace().x) {
                if (x + Window.BUTTON_WIDTH == Window.getEmptyPlace().x) {
                    setLocation(x + Window.BUTTON_WIDTH, y);
                    Window.getEmptyPlace().setLocation(x, y);
                }
            } else {
                if (x - Window.BUTTON_WIDTH == Window.getEmptyPlace().x) {
                    setLocation(x - Window.BUTTON_WIDTH, y);
                    Window.getEmptyPlace().setLocation(x, y);
                }
            }
        }
        Window.setStartCheckButton();
    }
}
