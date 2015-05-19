package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by aapollonin on 14.05.2015.
 */
public class CellUI extends JButton{
    private static Map<Cell.State, Color> COLOR_MAPPING = new HashMap<Cell.State, Color>();

    static {
        COLOR_MAPPING.put(Cell.State.SHIP, Color.GRAY);
        COLOR_MAPPING.put(Cell.State.FREE, Color.CYAN);
        COLOR_MAPPING.put(Cell.State.NEARSHIP, Color.YELLOW);
    }

    private Cell cell;

    public CellUI(Cell cell){
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    @Override
    protected void paintComponent(Graphics g) {
        setBackground(COLOR_MAPPING.getOrDefault(cell.getState(), Color.RED));

        super.paintComponent(g);
    }
}
