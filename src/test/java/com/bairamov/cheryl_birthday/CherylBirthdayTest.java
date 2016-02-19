package com.bairamov.cheryl_birthday;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CherylBirthdayTest {

    @Test
    public void testGetDate() throws Exception {
        Date expectedDate = new Date(16, 7);
        Date actualDate = CherylBirthday.getDate();

        assertEquals(expectedDate, actualDate);
    }
}