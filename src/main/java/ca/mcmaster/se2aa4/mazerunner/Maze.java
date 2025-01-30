package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private List<List<Integer>> grid;
    private Pos start;
    private Pos end;

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

        setEnds();
    }

    public void printMaze() {
        Logger logger = LogManager.getLogger();
        String line;
        int count = 0;
        logger.info("****** Printing maze read in");
        for (List<Integer> row : grid) {
            line = (count == start.y()) ? "start -> " : "         ";
            line += row.toString();
            line += (count == end.y()) ? " <- end" : "";
            logger.info(line);
            count++;
        }
        logger.info("****** End of maze");
    }

    private void setEnds() {
        int count = 0;
        for (List<Integer> row : grid) {
            if (row.get(0) == 0) {
                start = new Pos(0, count);
            }
            if (row.get(row.size()-1) == 0) {
                end = new Pos(row.size()-1, count);
            }
            count++;
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

    public int getCell(Pos p) {
        return grid.get(p.y()).get(p.x());
    }

    public void setCell(int x, int y, int val) {
        grid.get(y).set(x, val);
    }

    public Pos getStart() {
        return start;
    }
    
    public Pos getEnd() {
        return end;
    }

    public void switchDirection() {
        Pos temp = start;
        start = end;
        end = temp;
    }

    public int getDirection() {
        return (start.x() > end.x()) ? -1 : 1;
    }
}
