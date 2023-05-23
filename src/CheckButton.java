import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckButton extends Button implements ActionListener {
    public CheckButton(int x, int y) {
        super("Check");
        setLocation(x, y);
        setSize(Window.RANDOMIZE_BUTTON_WIDTH, Window.RANDOMIZE_BUTTON_HEIGHT);
        addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Window.check()) {
            setBackground(Color.GREEN);
            setLabel("U GOT IT!");
        } else {
            setBackground(Color.RED);
            setLabel("Try again :(");
        }
    }
}
