package ru.job4j;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

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
}