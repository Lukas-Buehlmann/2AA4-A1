package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private List<List<Integer>> grid;
    Pos start;
    Pos end;

    public Maze(String filepath) {
        loadMaze(filepath);
    }

    public void loadMaze(String filepath) {
        Logger logger = LogManager.getLogger();
        grid = new ArrayList<List<Integer>>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            ArrayList<Integer> row;
            int idx;

            while ((line = reader.readLine()) != null) {
                row = new ArrayList<>();
                for (idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        row.add(1);
                    } else if (line.charAt(idx) == ' ') {
                        row.add(0);
                    }
                }
                grid.add(row);
            }
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    public void printMaze() {
        for (List<Integer> row : grid) {
            System.out.println(row.toString());
        }
    }

    public int getWidth() {
        return grid.get(0).size();
    }

    public int getHeight() {
        return grid.size();
    }

    public int getCell(int x, int y) {
        return grid.get(y).get(x);
    }

    public void setCell(int x, int y, int val) {
        grid.get(y).set(x, val);
    }
}
