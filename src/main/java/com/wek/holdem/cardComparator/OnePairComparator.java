package com.wek.holdem.cardComparator;

import com.wek.holdem.entity.CardGroup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OnePairComparator implements CardComparator {
    @Override
    public int compare(CardGroup group1, CardGroup group2) {
        Map<Integer, Integer> cardCountMap1 = group1.getCardCountMap();
        Map<Integer, Integer> cardCountMap2 = group2.getCardCountMap();

        Integer pairNumonMap1 = 0;
        Integer pairNumonMap2 = 0;

        List<Integer> sanonMap1 = new ArrayList<>();
        List<Integer> sanonMap2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : cardCountMap1.entrySet()) {
            if (entry.getValue() == 1) {
                sanonMap1.add(entry.getKey());
            }
            if (entry.getValue() == 2){
                pairNumonMap1 = entry.getKey();
            }
        }

        for (Map.Entry<Integer, Integer> entry : cardCountMap2.entrySet()) {
            if (entry.getValue() == 1) {
                sanonMap2.add(entry.getKey());
            }
            if (entry.getValue() == 2){
                pairNumonMap2 = entry.getKey();
            }
        }

        if (pairNumonMap1 < pairNumonMap2) {
            return 1;
        }
        if (pairNumonMap1 > pairNumonMap2) {
            return -1;
        }
        if (pairNumonMap1 == pairNumonMap2) {
            sanonMap1 = sanonMap1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            sanonMap2 = sanonMap2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            for (int i = 0; i< sanonMap1.size(); i++) {
                if (sanonMap1.get(i) < sanonMap2.get(i)){
                    return 1;
                }
                if (sanonMap1.get(i) > sanonMap2.get(i)) {
                    return -1;
                }
                if (sanonMap1.get(i) == sanonMap2.get(i)) {
                    continue;
                }
            }
        }
        return 0;
    }
}
