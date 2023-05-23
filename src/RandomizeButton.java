import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomizeButton extends Button implements ActionListener {
    public RandomizeButton(int x, int y) {
        super("Randomize");
        setLocation(x, y);
        setSize(Window.RANDOMIZE_BUTTON_WIDTH, Window.RANDOMIZE_BUTTON_HEIGHT);
        addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.randomizeAllButtons();
        Window.setStartCheckButton();
    }
}
