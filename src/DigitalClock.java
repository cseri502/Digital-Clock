import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private final ClockConfig config;

    public DigitalClock() {
        this(new ClockConfig("Digital Clock", "https://github.com/cseri502", 500, 200, 1000));
    }

    public DigitalClock(ClockConfig config) {
        this.config = config;
        initComponents();
        initTimer();
    }

    private void initComponents() {
        setTitle(config.getTitle());
        setSize(config.getWidth(), config.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(getImage("digital-clock.png"));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (int) ((screenSize.getWidth() - config.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - config.getHeight()) / 2);

        setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(new Color(82, 186, 230));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setVerticalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(new Color(191, 211, 216));

        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);

        panel.setBackground(new Color(32, 43, 63));

        add(panel);
    }

    private void initTimer() {
        Timer timer = new Timer(config.getInterval(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }
        });
        updateTimeAndDate();
        timer.start();
    }

    private void updateTimeAndDate() {
        Calendar c = Calendar.getInstance();

        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormatter.format(c.getTime());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMMM dd, yyyy");
        String date = dateFormatter.format(c.getTime());

        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    private Image getImage(String path) {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource(path))).getImage();
    }
}