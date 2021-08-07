package me.whale.utils.lang;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseTest {

    @Test
    void test() {
        List<String> targetRelations = new ArrayList<>(Arrays.asList("1", "2", "3"));

        Set<String> existingRelations = new HashSet<>(Arrays.asList("1"));
        assertEquals("2", convertRelation(existingRelations, targetRelations));
        existingRelations = new HashSet<>(Arrays.asList("2"));
        assertEquals("3", convertRelation(existingRelations, targetRelations));
        existingRelations = new HashSet<>(Arrays.asList("3"));
        assertEquals("1", convertRelation(existingRelations, targetRelations));
        existingRelations = new HashSet<>(Arrays.asList("1", "2"));
        assertEquals("3", convertRelation(existingRelations, targetRelations));
        existingRelations = new HashSet<>(Arrays.asList("1", "3"));
        assertEquals("2", convertRelation(existingRelations, targetRelations));
        existingRelations = new HashSet<>(Arrays.asList("2", "3"));
        assertEquals("1", convertRelation(existingRelations, targetRelations));
        existingRelations = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertEquals("", convertRelation(existingRelations, targetRelations));
        existingRelations = new HashSet<>();
        assertEquals("1", convertRelation(existingRelations, targetRelations));
    }

    String convertRelation(Set<String> existingRelations, List<String> targetRelations) {
        String relation = "";
        int maxSize = 0;
        if (existingRelations.size() < targetRelations.size()) {
            int idx = -1;
            for (int i = 0; i < targetRelations.size(); i++) {
                if (!existingRelations.contains(targetRelations.get(i))) {
                    if (i == maxSize) {
                        idx = i;
                    }
                } else {
                    maxSize = i + 1;
                }
            }
            relation = targetRelations.get(idx);
        }
        return relation;
    }
}