package log4j_example2;

import org.apache.log4j.*;

public class Main {

    private  static  final Logger logger = LogManager.getLogger(Main.class);

    public static int add(int a, int b) {
    	/*RollingFileAppender rfa = new RollingFileAppender();
    	PropertyConfigurator.configure("log4j.properties");
    	
    	rfa.activateOptions();
    	LogManager.getRootLogger().addAppender(rfa);*/
    	
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d [%p|%c|%c{1}]"));
        consoleAppender.activateOptions();
        LogManager.getRootLogger().addAppender(consoleAppender);

        logger.debug("Hello this is a debug message");
        logger.info("Hello this is a info message");

        try{

        }catch (Exception e){
            logger.warn(e.getMessage(),e );
        }
        int c = a + b;
        return c;
    }


    public static void main(String[] args) {
        add(100, 200);
    }
}

