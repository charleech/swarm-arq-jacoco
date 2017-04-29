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
package it.test.com.sample;

import java.io.File;

import javax.inject.Inject;

import org.assertj.core.api.BDDAssertions;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.spi.api.ArtifactLookup;

import com.sample.MyCdi;

@RunWith(Arquillian.class)
public class SwarmArqJacocoIntgrtnTester {

    @Deployment(name = "swarm-arq-jacoco")
    public static WebArchive createDeployment() {
        WebArchive        web       = null;
        try {

            web       = ShrinkWrap.create(WebArchive.class,
                                          "myweb.war").
                                   addPackages(true, "com.sample").
                                   addPackages(true, "test.com.sample").
                                   addPackages(true, "it.test.com.sample").
                                   addAsWebInfResource(new File("src/test/resources/META-INF/beans.xml"),
                                                       "bean.xml");
            web.addAsLibraries(ArtifactLookup.get().
                                          artifact("org.assertj:assertj-core"));

            return web;
        } catch (final Exception e) {
            throw new IllegalStateException("Cannot create archive.",
                                            e);
        }
    }

    @Inject
    private MyCdi myCdi;

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
