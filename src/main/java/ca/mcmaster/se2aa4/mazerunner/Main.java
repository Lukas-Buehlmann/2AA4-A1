package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", true, "Path to maze information file");
        options.addOption("p", true, "Option to verify a path. Given path should be of same form as output");
        CommandLineParser parser = new DefaultParser();
        String filepathString = "";
        String verifyPath = null;

        PathGenerator pathgen;

        try {
            CommandLine cmd = parser.parse(options, args);
            filepathString = cmd.getOptionValue("i");
            logger.trace("**** Reading the maze from file " + filepathString);

            verifyPath = cmd.getOptionValue("p");
            if (verifyPath != null) logger.trace("**** Verifying the path " + verifyPath);
            
        } catch (ParseException e) {
            logger.error("Error in parsing command line inputs");
        }

        logger.info("**** Computing path");

        pathgen = new RightHandPathGen(filepathString);
        Path path;

        if (verifyPath == null) {
            path = pathgen.findPath();
            System.out.println(path.getFactorized());
        } else {
            if (pathgen.verifyBothPaths(Path.factorizedToRaw(verifyPath))) System.out.println("correct path");
            else System.out.println("incorrect path");
        }

        logger.info("** End of MazeRunner");
    }
}
