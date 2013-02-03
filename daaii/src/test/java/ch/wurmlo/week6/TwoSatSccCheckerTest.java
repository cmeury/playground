/**
 * Copyright 2013, netbreeze GmbH
 */
package ch.wurmlo.week6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TwoSatSccCheckerTest {

    @Test
    public void checkSatisfiablity1() throws Exception {
        // given
        List<Clause> clauses = new ArrayList<>();
        clauses.add(new Clause(2, 2));
        clauses.add(new Clause(-2, -2));

        // when
        boolean satisfiable = TwoSatSccChecker.isSatisfiable(clauses);

        // then
        assertFalse(satisfiable);
    }

    @Test
    public void checkSatisfiablity2() throws Exception {
        // given
        List<Clause> clauses = new ArrayList<>();
        clauses.add(new Clause(2, 2));
        clauses.add(new Clause(-2, -1));

        // when
        boolean satisfiable = TwoSatSccChecker.isSatisfiable(clauses);

        // then
        assertTrue(satisfiable);
    }

    @Test
    public void checkSatisfiablity3() throws Exception {
        // given
        List<Clause> clauses = new ArrayList<>();
        clauses.add(new Clause(1, 2));
        clauses.add(new Clause(-1, -2));
        clauses.add(new Clause(3, -2));
        clauses.add(new Clause(3, 2));

        // when
        boolean satisfiable = TwoSatSccChecker.isSatisfiable(clauses);

        // then
        assertTrue(satisfiable);
    }

    @Test
    public void checkSatisfiablity4() throws Exception {
        // given
        List<Clause> clauses = new ArrayList<>();
        clauses.add(new Clause(1, 2));
        clauses.add(new Clause(-1, 3));
        clauses.add(new Clause(3, 4));
        clauses.add(new Clause(-2, -4));

        // when
        boolean satisfiable = TwoSatSccChecker.isSatisfiable(clauses);

        // then
        assertTrue(satisfiable);
    }

    @Test
    public void checkSatisfiablity5() throws Exception {
        // given
        List<Clause> clauses = new ArrayList<>();
        clauses.add(new Clause(1, 1));
        clauses.add(new Clause(-1, 2));
        clauses.add(new Clause(-1, 3));
        clauses.add(new Clause(-2, -3));
        clauses.add(new Clause(4, 5));

        // when
        boolean satisfiable = TwoSatSccChecker.isSatisfiable(clauses);

        // then
        assertFalse(satisfiable);
    }

    @Test
    public void checkSatisfiablity6() throws Exception {
        // given
        List<Clause> clauses = new ArrayList<>();
        clauses.add(new Clause(-1, -4));
        clauses.add(new Clause(-2, -7));
        clauses.add(new Clause(2, -6));
        clauses.add(new Clause(2, 7));
        clauses.add(new Clause(-6, 7));
        clauses.add(new Clause(1, -5));
        clauses.add(new Clause(1, 7));
        clauses.add(new Clause(-5, 7));
        clauses.add(new Clause(-1, -7));
        clauses.add(new Clause(-3, 6));
        clauses.add(new Clause(3, -4));
        clauses.add(new Clause(3, -6));
        clauses.add(new Clause(-4, -6));
        clauses.add(new Clause(2, 5));
        clauses.add(new Clause(-2, 3));
        clauses.add(new Clause(-3, -5));

        // when
        boolean satisfiable = TwoSatSccChecker.isSatisfiable(clauses);

        // then
        assertFalse(satisfiable);
    }
}
