import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RitaSaker extends Canvas {
    Graphics dbg;
    Image image;

    private final int height = 600;
    private final int width = 800;
    int treeX = 200;
    int treeY = 200;
    int sunX = 700;
    int sunY = 100;
    int cloudX = 100;
    int cloudY = 50;

    public RitaSaker() {
        JFrame frame = new JFrame("Del 1");
        this.setSize(width, height);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        if (image == null) {
            // skapa en andra skärm i minnet som vi kan rita till
            image = createImage(width, height);
            if (image == null) {
                System.out.println("image is still null!");
                return;
            } else {
                dbg = image.getGraphics();
            }
        }
        update();
        draw(dbg);
        g.drawImage(image, 0, 0, null);
        try {
            Thread.sleep(35);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    private void update() {
        cloudX += 5;
        if (cloudX > 800)
            cloudX = 0;

        treeX += 150;
        if (treeX > 150)
            treeX = 0;
    }


    private void draw(Graphics g) {
        drawHeaven(g);
        drawMountains(g, 200);
        drawGrass(g);
        drawHouse(g, 300,200);
        drawSun(g, sunX, sunY);
        drawCloud(g, cloudX,cloudY);
        drawTree(g, treeX,treeY);
        drawTree(g, treeX+155,treeY);
    }

    private void drawCloud(Graphics g, int cloudX, int cloudY) {
        g.setColor(Color.white);
        g.fillOval(cloudX,cloudY,30,30);
        g.fillOval(cloudX+20,cloudY-10,30,30+10);
        g.fillOval(cloudX+40,cloudY,30,30);
    }

    private void drawSun(Graphics g, int sunX, int sunY) {
        g.setColor(Color.lightGray);
        g.fillOval(sunX,sunY,40,40);
    }

    private void drawGrass(Graphics g) {
        g.setColor(new Color(0x436236));
        g.fillRect(0,250,width,height);
    }

    private void drawMountains(Graphics g, int y) {
        g.setColor(Color.darkGray);
        int[] xs = {0,200,240,470,550,650,800};
        int[] ys = {250,150,200,150,200,150,250};
        Polygon shape = new Polygon(xs,ys,7);
        g.fillPolygon(shape);
    }

    private void drawHeaven(Graphics g) {
        g.setColor(new Color(0x000000));
        g.fillRect(0,0,width,height);
    }

    private void drawTree(Graphics g, int x, int y) {
        g.setColor(new Color(0x3AA13A));
        g.fillRect(x+62,y,20,40);
        g.setColor(Color.white);
        g.fillRect(x+70,y+40,4,20);
    }

    private void drawHouse(Graphics g, int x, int y) {
        g.setColor(new Color(0x976F45));
        g.fillRect(x,y,100,50);

        g.setColor(new Color(0x000000));
        g.drawRect(x+40,y+24,15,25);

        g.setColor(new Color(0x816F45));
        g.fillRect(x+41,y+25,14,24);

        g.setColor(new Color(0x594329));
        g.fillRect(x-10,y-10,120,20);

        g.setColor(new Color(0x000000));
        g.drawRect(x+10,y+20,15,15);

        g.setColor(new Color(0xFF92EFF6, true));
        g.fillRect(x+11,y+21,14,14);

        g.setColor(new Color(0x000000));
        g.drawRect(x+70,y+20,15,15);

        g.setColor(new Color(0xFF92EFF6, true));
        g.fillRect(x+71,y+21,14,14);

        g.setColor(new Color(0xFF000000, true));
        g.fillOval(x+50,y+38,2,2);
    }
    public static void main(String[] args) {
        RitaSaker exempel = new RitaSaker();
    }
}