package com.apocalypsecoder0.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameGUI {

    private JFrame frame;
    private UniverseGenerator universeGenerator;

    public GameGUI() {
        universeGenerator = new UniverseGenerator(System.currentTimeMillis());
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Galaxy Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton generateButton = new JButton("Generate Universe");
        JButton displayButton = new JButton("Display Galaxies");

        controlPanel.add(generateButton);
        controlPanel.add(displayButton);

        frame.add(controlPanel, BorderLayout.NORTH);

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                universeGenerator.generateUniverse(5, 10);
                displayArea.setText("Universe generated with 5 galaxies, each containing 10 planets.");
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<UniverseGenerator.Galaxy> galaxies = universeGenerator.getGalaxies();
                StringBuilder sb = new StringBuilder();
                for (UniverseGenerator.Galaxy galaxy : galaxies) {
                    sb.append("Galaxy: ").append(galaxy.getName()).append("\\n");
                    for (UniverseGenerator.Planet planet : galaxy.getPlanets()) {
                        sb.append("  Planet: ").append(planet.getName())
                          .append(", Size: ").append(planet.getSize())
                          .append(", Type: ").append(planet.getType()).append("\\n");
                    }
                }
                displayArea.setText(sb.toString());
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameGUI();
            }
        });
    }
}
