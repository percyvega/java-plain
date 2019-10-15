package com.percyvega.experiments.lazy_initialization;

import lombok.extern.log4j.Log4j2;

@Log4j2
/**
 * Copyright 2015 Percy Vega
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AppThatIsLazy {


    public static void main(String[] args) throws InterruptedException {
        log.debug("Starting main()");

        log.debug("About to sleep for 3 seconds.");
        Thread.sleep(3000);
        log.debug("Finished sleeping for 3 seconds.");

        log.debug("About to make reference to enum.");
        JustAnotherEnum justAnotherEnum = JustAnotherEnum.INSTANCE;

        log.debug("About to call JustAnotherClass' constructor.");
        JustAnotherClass justAnotherClass = new JustAnotherClass();

        log.debug("About to call JustAnotherClassWithStaticFinalProp's constructor.");
        JustAnotherClassWithStaticFinalProp justAnotherClassWithStaticFinalProp = new JustAnotherClassWithStaticFinalProp();

        log.debug("About to call JustAnotherSingleton.getAll().");
        JustAnotherSingleton justAnotherSingleton = JustAnotherSingleton.getInstance();

    }

}

