package com.daggerstudio.lunar.util;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.zip.DataFormatException;

import static org.testng.Assert.*;

public class LunarExecutorTest {
    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testMain() throws Exception {

    }



    @Test
    public void testSolarToInt() throws Exception {
        assertTrue(LunarExecutor.SolarFromInt(LunarExecutor.SolarToInt(2015, 2, 28)).equals(new Solar(2015, 2, 28)));
        assertTrue(LunarExecutor.SolarFromInt(LunarExecutor.SolarToInt(1900, 1, 1)).equals(new Solar(1900, 1, 1)));
        assertTrue(LunarExecutor.SolarFromInt(LunarExecutor.SolarToInt(2099, 12, 31)).equals(new Solar(2099, 12, 31)));
    }

    @Test
    public void testLunarYearToGanZhi() throws Exception {
        assertEquals(LunarExecutor.lunarYearToGanZhi(1900),"庚子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1901),"辛丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1902),"壬寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1903),"癸卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1904),"甲辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1905),"乙巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1906),"丙午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1907),"丁未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1908),"戊申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1909),"己酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1910),"庚戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1911),"辛亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1912),"壬子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1913),"癸丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1914),"甲寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1915),"乙卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1916),"丙辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1917),"丁巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1918),"戊午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1919),"己未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1920),"庚申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1921),"辛酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1922),"壬戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1923),"癸亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1924),"甲子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1925),"乙丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1926),"丙寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1927),"丁卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1928),"戊辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1929),"己巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1930),"庚午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1931),"辛未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1932),"壬申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1933),"癸酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1934),"甲戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1935),"乙亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1936),"丙子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1937),"丁丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1938),"戊寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1939),"己卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1940),"庚辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1941),"辛巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1942),"壬午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1943),"癸未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1944),"甲申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1945),"乙酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1946),"丙戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1947),"丁亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1948),"戊子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1949),"己丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1950),"庚寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1951),"辛卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1952),"壬辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1953),"癸巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1954),"甲午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1955),"乙未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1956),"丙申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1957),"丁酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1958),"戊戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1959),"己亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1960),"庚子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1961),"辛丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1962),"壬寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1963),"癸卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1964),"甲辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1965),"乙巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1966),"丙午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1967),"丁未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1968),"戊申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1969),"己酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1970),"庚戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1971),"辛亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1972),"壬子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1973),"癸丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1974),"甲寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1975),"乙卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1976),"丙辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1977),"丁巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1978),"戊午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1979),"己未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1980),"庚申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1981),"辛酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1982),"壬戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1983),"癸亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1984),"甲子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1985),"乙丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1986),"丙寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1987),"丁卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1988),"戊辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1989),"己巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1990),"庚午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1991),"辛未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1992),"壬申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1993),"癸酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1994),"甲戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1995),"乙亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1996),"丙子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1997),"丁丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1998),"戊寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(1999),"己卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2000),"庚辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2001),"辛巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2002),"壬午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2003),"癸未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2004),"甲申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2005),"乙酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2006),"丙戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2007),"丁亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2008),"戊子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2009),"己丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2010),"庚寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2011),"辛卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2012),"壬辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2013),"癸巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2014),"甲午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2015),"乙未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2016),"丙申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2017),"丁酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2018),"戊戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2019),"己亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2020),"庚子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2021),"辛丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2022),"壬寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2023),"癸卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2024),"甲辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2025),"乙巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2026),"丙午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2027),"丁未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2028),"戊申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2029),"己酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2030),"庚戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2031),"辛亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2032),"壬子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2033),"癸丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2034),"甲寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2035),"乙卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2036),"丙辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2037),"丁巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2038),"戊午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2039),"己未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2040),"庚申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2041),"辛酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2042),"壬戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2043),"癸亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2044),"甲子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2045),"乙丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2046),"丙寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2047),"丁卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2048),"戊辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2049),"己巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2050),"庚午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2051),"辛未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2052),"壬申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2053),"癸酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2054),"甲戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2055),"乙亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2056),"丙子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2057),"丁丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2058),"戊寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2059),"己卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2060),"庚辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2061),"辛巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2062),"壬午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2063),"癸未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2064),"甲申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2065),"乙酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2066),"丙戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2067),"丁亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2068),"戊子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2069),"己丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2070),"庚寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2071),"辛卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2072),"壬辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2073),"癸巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2074),"甲午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2075),"乙未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2076),"丙申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2077),"丁酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2078),"戊戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2079),"己亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2080),"庚子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2081),"辛丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2082),"壬寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2083),"癸卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2084),"甲辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2085),"乙巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2086),"丙午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2087),"丁未年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2088),"戊申年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2089),"己酉年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2090),"庚戌年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2091),"辛亥年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2092),"壬子年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2093),"癸丑年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2094),"甲寅年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2095),"乙卯年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2096),"丙辰年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2097),"丁巳年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2098),"戊午年");
        assertEquals(LunarExecutor.lunarYearToGanZhi(2099),"己未年");
    }

    @Test
    public void testSolarFromInt() throws Exception {
    }

    @Test
    public void testLunarToSolar() throws Exception {

    }

    @Test
    public void testSolarToLunar() throws Exception {

    }

    @Test(expectedExceptions = {DataFormatException.class})
    public void testException() throws Exception {
        throw new DataFormatException();
    }



}
