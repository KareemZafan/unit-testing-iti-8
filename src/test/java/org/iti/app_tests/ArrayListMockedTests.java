package org.iti.app_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArrayListMockedTests {

    @Mock
    ArrayList<Object> record;

    @Test
    void testUsersNumber(){
       when(record.size()).thenReturn(50); //stub

        assertEquals(50, record.size());
       verify(record).size();  //spy
    }

    @Test
    void testGettingUserNumber10() {
        when(record.get(10)).thenReturn("Kareem Mohamed"); //stub

        assertTrue(record.get(10).toString().contains("Kar"));
        verify(record).get(10);  //spy
    }
}
