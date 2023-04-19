// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;

// class GameOfLifeGUI extends JFrame {

//     private static final long serialVersionUID = 1L;
//     private JPanel boardPanel;
//     private JPanel controlPanel;
//     private JButton startButton;
//     private JTextField rowsTextField;
//     private JTextField columnsTextField;
//     private JTextField speedTextField;
//     private JLabel generationLabel;
//     private JLabel aliveLabel;
//     private int rows;
//     private int columns;
//     private int speed;
//     private boolean[][] board;
//     private boolean[][] nextBoard;
//     private int generationCount;
//     private int aliveCount;
//     private boolean running;

//     public GameOfLifeGUI() {
//         setTitle("Conway's Game of Life");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(800, 600);
//         setLayout(new BorderLayout());

//         boardPanel = new JPanel();
//         boardPanel.setLayout(new GridLayout(0, 0));
//         add(boardPanel, BorderLayout.CENTER);

//         controlPanel = new JPanel();
//         controlPanel.setLayout(new GridLayout(0, 2));
//         add(controlPanel, BorderLayout.SOUTH);

//         startButton = new JButton("Start");
//         startButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 start();
//             }
//         });
//         controlPanel.add(startButton);

//         JButton stopButton = new JButton("Stop");
//         stopButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 stop();
//             }
//         });
//         controlPanel.add(stopButton);

//         JButton resetButton = new JButton("Reset");
//         resetButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 reset();
//             }
//         });
//         controlPanel.add(resetButton);

//         controlPanel.add(new JLabel("Rows:"));
//         rowsTextField = new JTextField("30", 5);
//         controlPanel.add(rowsTextField);

//         controlPanel.add(new JLabel("Columns:"));
//         columnsTextField = new JTextField("50", 5);
//         controlPanel.add(columnsTextField);

//         controlPanel.add(new JLabel("Speed (ms):"));
//         speedTextField = new JTextField("100", 5);
//         controlPanel.add(speedTextField);

//         generationLabel = new JLabel("Generation: 0");
//         controlPanel.add(generationLabel);

//         aliveLabel = new JLabel("Alive: 0");
//         controlPanel.add(aliveLabel);
//     }

//     private void start() {
//         if (!running) {
//             running = true;
//             rows = Integer.parseInt(rowsTextField.getText());
//             columns = Integer.parseInt(columnsTextField.getText());
//             speed = Integer.parseInt(speedTextField.getText());
//             board = new boolean[rows][columns];
//             nextBoard = new boolean[rows][columns];
//             generationCount = 0;
//             aliveCount = 0;
//             boardPanel.removeAll();
//             boardPanel.setLayout(new GridLayout(rows, columns));
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < columns; j++) {
//                     board[i][j] = Math.random() < 0.5;
//                     if (board[i][j]) {
//                         aliveCount++;
//                     }
//                     boardPanel.add(new CellPanel(i, j, board[i][j]));
//                 }
//             }
//             generationLabel.setText("Generation: " + generationCount);
//             aliveLabel.setText("Alive: " + aliveCount);
//             setVisible(true);
//             Thread thread = new Thread(new Runnable() {
//                 public void run() {
//                     while (running) {
//                         try {
//                             Thread.sleep(speed);
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
//                         update();
//                     }
//                 }
//             });
//             thread.start();
//         }
//     }

//     private void stop() {
//         running = false;
//     }

//     private void reset() {
//         running = false;
//         for (Component component : boardPanel.getComponents()) {
//             ((CellPanel) component).setAlive(false);
//         }
//         generationCount = 0;
//         aliveCount = 0;
//         generationLabel.setText("Alive: " + aliveCount);
//     }

//     private void update() {
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < columns; j++) {
//                 int count = countNeighbors(i, j);
//                 if (board[i][j]) {
//                     if (count < 2 || count > 3) {
//                         nextBoard[i][j] = false;
//                         aliveCount--;
//                     } else {
//                         nextBoard[i][j] = true;
//                     }
//                 } else {
//                     if (count == 3) {
//                         nextBoard[i][j] = true;
//                         aliveCount++;
//                     } else {
//                         nextBoard[i][j] = false;
//                     }
//                 }
//             }
//         }
//         generationCount++;
//         generationLabel.setText("Generation: " + generationCount);
//         aliveLabel.setText("Alive: " + aliveCount);
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < columns; j++) {
//                 board[i][j] = nextBoard[i][j];
//                 ((CellPanel) boardPanel.getComponent(i * columns + j)).setAlive(board[i][j]);
//             }
//         }
//     }

//     private int countNeighbors(int row, int col) {
//         int count = 0;
//         for (int i = -1; i <= 1; i++) {
//             for (int j = -1; j <= 1; j++) {
//                 int r = row + i;
//                 int c = col + j;
//                 if (r >= 0 && r < rows && c >= 0 && c < columns && !(i == 0 && j == 0) && board[r][c]) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     private class CellPanel extends JPanel {

//         private static final long serialVersionUID = 1L;
//         private int row;
//         private int col;
//         private boolean alive;

//         public CellPanel(int row, int col, boolean alive) {
//             this.row = row;
//             this.col = col;
//             this.alive = alive;
//             setPreferredSize(new Dimension(10, 10));
//             setAlive(alive);
//             addMouseListener(new MouseAdapter() {
//                 public void mousePressed(MouseEvent e) {
//                     setAlive(!alive);
//                 }
//             });
//         }

//         public void setAlive(boolean alive) {
//             this.alive = alive;
//             setBackground(alive ? Color.BLACK : Color.WHITE);
//         }
//     }

//     public static void main(String[] args) {
//         GameOfLifeGUI game = new GameOfLifeGUI();
//         game.setVisible(true);
//     }
// }

