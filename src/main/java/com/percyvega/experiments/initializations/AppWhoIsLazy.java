package com.percyvega.experiments.initializations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright 2015 Percy Vega
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AppWhoIsLazy {

    private static final Logger logger = LoggerFactory.getLogger(AppWhoIsLazy.class);

    public static void main(String[] args) throws InterruptedException {
        logger.debug("Starting main()");

        logger.debug("About to sleep for 3 seconds.");
        Thread.sleep(3000);
        logger.debug("Finished sleeping for 3 seconds.");

        logger.debug("About to make reference to enum.");
        JustAnotherEnum justAnotherEnum = JustAnotherEnum.INSTANCE;

        logger.debug("About to make reference to class.");
        JustAnotherClass justAnotherClass = new JustAnotherClass();

        logger.debug("About to make reference to class with static final property.");
        JustAnotherClassWithStaticFinalProp justAnotherClassWithStaticFinalProp  = new JustAnotherClassWithStaticFinalProp();

        logger.debug("About to make reference to a singleton.");
        JustAnotherSingleton justAnotherSingleton = JustAnotherSingleton.getInstance();

    }

}

