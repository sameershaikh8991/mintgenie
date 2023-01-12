package com.mintgenie.model;

import org.springframework.stereotype.Component;

@Component
public class Count {

    public int count = 1;

    public int incremnet() {
        count++;
        return count;

    }

}
