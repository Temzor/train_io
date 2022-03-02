package ru.job4j.it;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import ru.job4j.it.ArrayIt;

import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;

class ArrayItTest {
    @Test
    public void whenMultiCallHasNextThenTrue() {
        ArrayIt it = new ArrayIt(new int[] {1, 2, 3});
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIt it = new ArrayIt(
                new int[] {1, 2, 3}
        );
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        ArrayIt it = new ArrayIt(
                new int[] {}
        );
        it.next();
    }
}