package com.rwt.logtest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

   private static final Logger logger=LoggerFactory.getLogger(LogTest.class);

   @Test
    public void logtest(){
       logger.info("CurrentTime:{}",System.currentTimeMillis());
       logger.info("CurrentTime:"+System.currentTimeMillis());
       logger.info("CurrentTime:{}",System.currentTimeMillis());
       logger.trace("trace log");
       logger.warn("warn log");
       logger.debug("debug log");
       logger.info("info log");
       logger.error("error log");
   }
}
