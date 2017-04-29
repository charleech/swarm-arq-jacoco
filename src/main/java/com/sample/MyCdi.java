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
package com.sample;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyCdi implements Serializable {

    private static final long serialVersionUID = 1L;

    public String say(final String name) {
        return "Hello " + name;
    }

}
