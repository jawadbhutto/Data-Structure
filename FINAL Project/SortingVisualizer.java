import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingVisualizer extends JFrame {
    private int[] array;  // Array to be sorted
    private JPanel arrayPanel;  // Panel to draw the array
    private JComboBox<String> algorithmDropdown;  // Dropdown for selecting algorithms
    private JButton generateButton, playButton, resetButton;  // Control buttons
    private boolean isSorting = false;  // Sorting state flag
    private Thread sortingThread;  // Thread for sorting

    public SortingVisualizer() {
        setTitle("Sorting Algorithm Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Initialize array with random numbers
        array = generateRandomArray(50, 1, 50);

        // Top panel for controls
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Algorithm dropdown
        algorithmDropdown = new JComboBox<>(new String[]{"Bubble Sort", "Selection Sort", "Insertion Sort"});
        controlPanel.add(algorithmDropdown);

        // Generate button
        generateButton = new JButton("Generate Array");
        controlPanel.add(generateButton);
        generateButton.addActionListener(e -> {
            array = generateRandomArray(50, 1, 50);
            repaint();
        });

        // Play button
        playButton = new JButton("Play");
        controlPanel.add(playButton);
        playButton.addActionListener(e -> startSorting());

        // Reset button
        resetButton = new JButton("Reset");
        controlPanel.add(resetButton);
        resetButton.addActionListener(e -> {
            isSorting = false;
            if (sortingThread != null && sortingThread.isAlive()) {
                sortingThread.interrupt();
            }
            array = generateRandomArray(50, 1, 50);
            repaint();
        });

        // Add control panel to frame
        add(controlPanel, BorderLayout.NORTH);

        // Panel for visualizing the array
        arrayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawArray(g);
            }
        };
        add(arrayPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Method to draw the array as bars
   private void drawArray(Graphics g) {
    int width = arrayPanel.getWidth();
    int height = arrayPanel.getHeight();
    int barWidth = width / array.length;

    for (int i = 0; i < array.length; i++) {
        int barHeight = (int) ((double) array[i] / 50 * height);
        int x = i * barWidth;
        int y = height - barHeight;

        // Draw the bar
        g.setColor(Color.BLUE);
        g.fillRect(x, y, barWidth - 2, barHeight);

        // Draw the value of the bar above it
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        String value = String.valueOf(array[i]);
        int strWidth = g.getFontMetrics().stringWidth(value);
        g.drawString(value, x + (barWidth - strWidth) / 2, y - 5); // Center the text above the bar
    }
}


    // Generate a random array
    private int[] generateRandomArray(int size, int min, int max) {
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return newArray;
    }

    // Start the sorting process
    private void startSorting() {
        if (isSorting) return; // Prevent multiple sorting threads
        isSorting = true;

        String selectedAlgorithm = (String) algorithmDropdown.getSelectedItem();

        sortingThread = new Thread(() -> {
            switch (selectedAlgorithm) {
                case "Bubble Sort":
                    bubbleSort();
                    break;
                case "Selection Sort":
                    selectionSort();
                    break;
                case "Insertion Sort":
                    insertionSort();
                    break;
            }
            isSorting = false;
        });
        sortingThread.start();
    }

    // Bubble Sort implementation
    private void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    repaint();
                    sleep(50); // Delay for visualization
                }
            }
        }
    }

    // Selection Sort implementation
    private void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            repaint();
            sleep(50); // Delay for visualization
        }
    }

    // Insertion Sort implementation
    private void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                repaint();
                sleep(50); // Delay for visualization
            }
            array[j + 1] = key;
        }
    }

    // Sleep method for delay
    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortingVisualizer::new);
    }
}
