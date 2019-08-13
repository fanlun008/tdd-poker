package com.wek.holdem.cardComparator;

import com.wek.holdem.entity.CardGroup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoPairComparator implements CardComparator {
    @Override
    public int compare(CardGroup group1, CardGroup group2) {
        Map<Integer, Integer> cardCountMap1 = group1.getCardCountMap();
        Map<Integer, Integer> cardCountMap2 = group2.getCardCountMap();

        List<Integer> pairNumOnMap1 = new ArrayList<>(), pairNumOnMap2 = new ArrayList<>();
        List<Integer> onlyOneOnMap1 = new ArrayList<>(), onlyNumOnMap2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : cardCountMap1.entrySet()) {
            if (entry.getValue() == 1) {
                onlyOneOnMap1.add(entry.getKey());
            }
            if (entry.getValue() == 2) {
                pairNumOnMap1.add(entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> entry : cardCountMap2.entrySet()) {
            if (entry.getValue() == 1) {
                onlyNumOnMap2.add(entry.getKey());
            }
            if (entry.getValue() == 2) {
                pairNumOnMap2.add(entry.getKey());
            }
        }
        pairNumOnMap1 = pairNumOnMap1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        pairNumOnMap2 = pairNumOnMap2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        onlyOneOnMap1 = onlyOneOnMap1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        onlyNumOnMap2 = onlyNumOnMap2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i< pairNumOnMap1.size(); i++) {
            if (pairNumOnMap1.get(i) < pairNumOnMap2.get(i)) {
                return 1;
            }
            if (pairNumOnMap1.get(i) > pairNumOnMap2.get(i)) {
                return -1;
            }
        }
        if (onlyOneOnMap1.size() != 0) {
            for (int i = 0; i< onlyOneOnMap1.size(); i++) {
                if (onlyOneOnMap1.get(i) < onlyNumOnMap2.get(i)) {
                    return 1;
                }
                if (onlyOneOnMap1.get(i) > onlyNumOnMap2.get(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
