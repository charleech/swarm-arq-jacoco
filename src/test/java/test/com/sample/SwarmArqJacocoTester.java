/**
 * Copyright (c) 2017-2017
 *
 * This work is licensed under a Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 *
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 * https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode
 * https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode.txt
 */
package test.com.sample;

import org.assertj.core.api.BDDAssertions;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;

import com.sample.MyCdi;

public class SwarmArqJacocoTester {


    private final MyCdi myCdi = new MyCdi();

    @Test
    @InSequence(1)
    public void whenEnsureCdi() {
        BDDAssertions.then(this.myCdi).
                      as("The CDI injected bean must not be null.").
                      isNotNull();

        BDDAssertions.then(this.myCdi.say("Charlee")).
                      as("The said message must be valid.").
                      isEqualTo("Hello Charlee");
    }
}
