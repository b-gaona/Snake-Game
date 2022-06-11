
package paquete1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.Timer;

public class panelDeJuego extends javax.swing.JPanel implements ActionListener{

    static final int SCREEN_WIDHT = 600; //Ancho de la pantalla
    static final int SCREEN_HEIGHT = 600; //Altura de la pantalla
    static final int UNIT_SIZE = 25; //Es la medida que tendran los objetos de 25*25
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDHT) / UNIT_SIZE; //Veremos cuantos cuadrantes podemos crear
    int delay = 80; //Delay para el thread
    int x[] = new int[GAME_UNITS];
    int y[] = new int[GAME_UNITS];
    int bodyParts = 6; //Con cuantas partes comienza la serpiente
    int applesEaten = 0;
    int appleX; //Posicion x donde esta la manzana
    int appleY; //Posicion y donde esta la manzana
    char direction = 'R'; //Empieza a la derecha R de Right.
    boolean running = false;
    Timer timer;
    Random random;
    
    Color headsColor, bodyColor1, bodyColor2;
    int speed;
    boolean gridlines;
    
    public panelDeJuego(Color headsColor, Color bodyColor1, Color bodyColor2, int speed, boolean gridlines) {
        initComponents();
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDHT, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.requestFocusInWindow(true);
        this.addKeyListener(new myKeyAdapter());
        this.headsColor= headsColor;
        this.bodyColor1= bodyColor1;
        this.bodyColor2= bodyColor2;
        this.speed= speed;
        this.gridlines= gridlines;
        this.delay= speed;
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            if (gridlines) {
                for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) { //Sirve para dibujar las lineas verticales a traves de la pantalla
                    g.setColor(new Color(0, 255, 0, 40));
                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                }
                for (int i = 0; i < SCREEN_WIDHT / UNIT_SIZE; i++) { //Sirve para dibujar las lineas horizontales a traves de la pantalla
                    g.setColor(new Color(0, 255, 0, 40));
                    g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDHT, i * UNIT_SIZE);
                }
            }
            //Pintamos la manzana de rojo
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            //Pintamos a la serpiente
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(headsColor);
                    //g.setColor(Color.YELLOW);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    if (i % 2 == 0) {
                        g.setColor(bodyColor1);
                    } else {
                        g.setColor(bodyColor2);
                    }
                    //g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            //Pintamos el score en el panel
            g.setColor(new Color(255, 195, 00, 150));
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDHT - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());

        } else {
            removeAll();
            gameOver(g);
        }
    }
    
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
        }
    }

    public void newApple() {
        /*Aqui lo que se hace es crear un espacio random de los n espacios posibles, si por ejemplo tenemos solo
        25 espacios posibles, al final ese numero random de 0-25 lo multiplicaria por el valor de longitud de la 
        unidad, para que apareciese en el espacio adecuado. Ejemplo: 0*25=0; 1*25=25, etc.*/
        appleX = random.nextInt((int) SCREEN_WIDHT / UNIT_SIZE) * UNIT_SIZE; //el x puede aparecer en cualquier unidad en el eje x
        appleY = random.nextInt((int) SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        //Colision: Choco con su mismo cuerpo
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }
        //Colision: Choco con los bordes del panel
        if (x[0] < 0 || x[0] > SCREEN_WIDHT-25 || y[0] < 0 || y[0] > SCREEN_HEIGHT-25) {
            running = false;
        }
        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        //Pintamos el score en el panel
        g.setColor(new Color(0xFFC300));
        g.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDHT - metrics1.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        //Pintamos el game over
        g.setColor(new Color(0xFFC300));
        g.setFont(new Font("Arial", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game over", (SCREEN_WIDHT - metrics2.stringWidth("Game over")) / 2, SCREEN_HEIGHT / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class myKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (direction != 'D') {
                    direction = 'U';
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (direction != 'U') {
                    direction = 'D';
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (direction != 'R') { //Siempre y no cuando sea R, debido a que si es R chocaria consigo mismo
                    direction = 'L';
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (direction != 'L') {
                    direction = 'R';
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
