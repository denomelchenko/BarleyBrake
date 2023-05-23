import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class Window extends Frame {
    public static final int X_LOCATION = 200;
    public static final int Y_LOCATION = 200;
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 500;
    public static final int RANDOMIZE_BUTTON_WIDTH = 200;
    public static final int RANDOMIZE_BUTTON_HEIGHT = 100;
    private static final int START_Y_BUTTON_POSITION = 30;
    public static final int BUTTON_WIDTH = WINDOW_WIDTH / 4;
    public static final int BUTTON_HEIGHT = (WINDOW_HEIGHT - START_Y_BUTTON_POSITION - RANDOMIZE_BUTTON_HEIGHT) / 4;
    private static Point emptyPlace;
    private static final CheckButton CHECK_BUTTON = new CheckButton(RANDOMIZE_BUTTON_WIDTH,
            BUTTON_HEIGHT * 3 + START_Y_BUTTON_POSITION / 2 + 5 + RANDOMIZE_BUTTON_HEIGHT);
    private static final Random RANDOM = new Random();
    private static List<MyButton> buttonsList;

    public Window() {
        super("BarleyBreak");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(X_LOCATION, Y_LOCATION);
        buttonsList = new LinkedList<>();
        addAllButtons();
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }


    public static void setStartCheckButton() {
        if (!CHECK_BUTTON.getBackground().equals(Color.WHITE)) {
            CHECK_BUTTON.setBackground(Color.WHITE);
            CHECK_BUTTON.setLabel("Check");
        }
    }

    private void addAllButtons() {
        List<Integer> list = new LinkedList<>();
        addButtonsRow(0, list);
        addButtonsRow(1, list);
        addButtonsRow(2, list);
        int y = BUTTON_HEIGHT * 3 + START_Y_BUTTON_POSITION;
        addButtonWithRandomNum(0, y, list);
        addButtonWithRandomNum(BUTTON_WIDTH, y, list);
        addButtonWithRandomNum(BUTTON_WIDTH * 2, y, list);
        add(new RandomizeButton(0,
                BUTTON_HEIGHT * 3 + START_Y_BUTTON_POSITION / 2 + 5 + RANDOMIZE_BUTTON_HEIGHT));
        add(CHECK_BUTTON);
        emptyPlace = startEmptyPlace();
    }

    public Point startEmptyPlace() {
        return new Point(BUTTON_WIDTH * 3, BUTTON_HEIGHT * 3 + START_Y_BUTTON_POSITION);
    }

    private void addButtonWithRandomNum(int x, int y, List<Integer> list) {
        int randomNum = generateNumWhichIsNotInList(list);
        list.add(randomNum);
        MyButton button = new MyButton(x, y, randomNum);
        buttonsList.add(button);
        add(button);
    }

    private void addButtonsRow(int counter, List<Integer> list) {
        int y = BUTTON_HEIGHT * counter + START_Y_BUTTON_POSITION;
        addButtonWithRandomNum(0, y, list);
        addButtonWithRandomNum(BUTTON_WIDTH, y, list);
        addButtonWithRandomNum(BUTTON_WIDTH * 2, y, list);
        addButtonWithRandomNum(BUTTON_WIDTH * 3, y, list);
    }

    private static int generateNumWhichIsNotInList(List<Integer> list) {
        int num;
        do {
            num = RANDOM.nextInt(1, 16);
        } while (list.contains(num));
        return num;
    }

    private static void doRandomizeAllButtons() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 15; ++i) {
            int num = generateNumWhichIsNotInList(list);
            list.add(num);
            buttonsList.get(i).setLabel(Integer.toString(num));
        }
    }

    public static void randomizeAllButtons() {
        doRandomizeAllButtons();
    }

    private static boolean doCheck() {
        if (emptyPlace.x != BUTTON_WIDTH * 3 || emptyPlace.y != BUTTON_HEIGHT * 3 + START_Y_BUTTON_POSITION) {
            return false;
        }
        for (int i = 0; i < buttonsList.size(); ++i) {
            if (Integer.parseInt(buttonsList.get(i).getLabel()) != i + 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean check() {
        return doCheck();
    }

    public static Point getEmptyPlace() {
        return emptyPlace;
    }
}
