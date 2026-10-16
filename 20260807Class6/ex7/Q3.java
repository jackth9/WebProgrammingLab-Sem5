import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Q3 extends JPanel {
//RaindropSimulation
    private static class Raindrop {
        int x, y, speed, length;

        public Raindrop(int x, int y, int speed, int length) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.length = length;
        }
    }

    private final List<Raindrop> raindrops = new ArrayList<>();
    private final Random random = new Random();

    public Q3() {
        setBackground(Color.BLACK);
        
        Timer timer = new Timer(20, e -> {
            for (int i = 0; i < 5; i++) {
                int x = random.nextInt(Math.max(1, getWidth()));
                int speed = random.nextInt(8) + 4;
                int length = random.nextInt(10) + 10;
                raindrops.add(new Raindrop(x, 0, speed, length));
            }

            Iterator<Raindrop> iterator = raindrops.iterator();
            while (iterator.hasNext()) {
                Raindrop drop = iterator.next();
                drop.y += drop.speed;
                if (drop.y > getHeight()) {
                    iterator.remove();
                }
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        for (Raindrop drop : raindrops) {
            g.drawLine(drop.x, drop.y, drop.x, drop.y + drop.length);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Raindrop Simulation");
        Q3 panel = new Q3();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}