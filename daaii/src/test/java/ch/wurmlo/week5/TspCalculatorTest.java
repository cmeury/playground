package ch.wurmlo.week5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TspCalculatorTest {

    @Test
    public void shouldPowersetBitCount() throws Exception {
        // given
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);

        // when
        List<BitSet> bitsets = TspCalculator.powersetBitCount(list);

        // then
        assertEquals(8, bitsets.size());

        BitSet bs = new BitSet();
        assertTrue(bitsets.contains(bs));

        bs = new BitSet(); bs.set(4);
        assertTrue(bitsets.contains(bs));

        bs = new BitSet(); bs.set(3);
        assertTrue(bitsets.contains(bs));

        bs = new BitSet(); bs.set(4); bs.set(3,4);
        assertTrue(bitsets.contains(bs));

        bs = new BitSet(); bs.set(2);
        assertTrue(bitsets.contains(bs));

        bs = new BitSet(); bs.set(2); bs.set(4);
        assertTrue(bitsets.contains(bs));

        bs = new BitSet(); bs.set(2,3);
        assertTrue(bitsets.contains(bs));

        bs = new BitSet(); bs.set(2,4);
        assertTrue(bitsets.contains(bs));

    }
}
