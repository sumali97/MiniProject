package com.example.newandroidproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Details details;

    @Before
    public void setUp(){
        details = new Details();
    }

    @Test
    public void discount_isCorrect() {
        float discount = details.calculateDiscount(100);
        assertEquals(5.00,discount,0.001);
    }


    }