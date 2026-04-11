package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

   public static Logger getLogger(Class<?>Clazz){
       return LogManager.getLogger(Clazz);
   }

}

