package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    private CustomList list;

    /**
     * Create a mock list for testing the city list.
     *
     * @return a CustomList instance with no initial cities.
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * Test the addCity method to ensure the size increases correctly.
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * Test hasCity method to verify if the city exists in the list.
     */
    @Test
    public void testHasCity() {
        list = MockCityList();
        City city = new City("Toronto", "ON");
        list.addCity(city);

        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(new City("Vancouver", "BC")));
    }

    /**
     * Test deleteCity method to ensure it removes a city correctly.
     */
    @Test
    public void testDeleteCity() {
        list = MockCityList();
        City city = new City("Regina", "SK");
        list.addCity(city);

        assertEquals(1, list.getCount());
        list.deleteCity(city);
        assertEquals(0, list.getCount());
        assertFalse(list.hasCity(city));
    }

    /**
     * Test that deleting a non-existent city throws an exception.
     */
    @Test
    public void testDeleteNonExistentCityThrowsException() {
        list = MockCityList();
        City city = new City("Calgary", "AB");

        assertThrows(IllegalArgumentException.class, () -> list.deleteCity(city));
    }

    /**
     * Test countCities method to ensure it returns the correct count.
     */
    @Test
    public void testCountCities() {
        list = MockCityList();
        assertEquals(0, list.countCities());

        list.addCity(new City("Vancouver", "BC"));
        assertEquals(1, list.countCities());

        list.addCity(new City("Edmonton", "AB"));
        assertEquals(2, list.countCities());
    }
}

