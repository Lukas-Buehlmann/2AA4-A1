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
        CommandLineParser parser = new DefaultParser();
        String filepathString;

        PathGenerator pathgen;

        try {
            CommandLine cmd = parser.parse(options, args);
            filepathString = cmd.getOptionValue("i");
            logger.trace("**** Reading the maze from file " + filepathString);

            pathgen = new PathGenerator(filepathString);
            
        } catch (ParseException e) {
            logger.error("Error in parsing command line inputs");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
