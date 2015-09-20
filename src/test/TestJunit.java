package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

public class TestJunit {

      @Test
      public void testAssertArrayEquals() {
        byte[] expected = "Finix".getBytes();
        byte[] actual = "Finix".getBytes();
        org.junit.Assert.assertArrayEquals("failure - byte arrays not same", expected, actual);
      }

      @Test
      public void testAssertEquals() {
        org.junit.Assert.assertEquals("failure - strings not same", 99, 99);
      }

      @Test
      public void testAssertFalse() {
        org.junit.Assert.assertFalse("failure - should be false", false);
      }

      @Test
      public void testAssertNotNull() {
        org.junit.Assert.assertNotNull("should not be null", new Object());
      }

      @Test
      public void testAssertNotSame() {
        org.junit.Assert.assertNotSame("should not be same Object", new Object(), new Object());
      }

      @Test
      public void testAssertNull() {
        org.junit.Assert.assertNull("should be null", null);
      }

      @Test
      public void testAssertSame() {
        Integer aNumber = Integer.valueOf(1000);
        org.junit.Assert.assertSame("should be same", aNumber, aNumber);
      }

      // JUnit Matchers assertThat
      @Test
      public void testAssertThatBothContainsString() {
        org.junit.Assert.assertThat("albumen", both(containsString("a")).and(containsString("b")));
      }

      @Test
      public void testAssertThathasItemsContainsString() {
        org.junit.Assert.assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
      }

      @Test
      public void testAssertThatEveryItemContainsString() {
        org.junit.Assert.assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
      }

      // Core Hamcrest Matchers with assertThat
      @Test
      public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
      }
}
