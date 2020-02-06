package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    Set<String> characterSet = new HashSet<String>(Arrays.asList("a","á", "e","é","ě", "i","í", "o","ó", "u","ú","ů"));

    public String demo(String input) {
        String trimmedInput = input.trim().replaceAll(" +", " ");
        List<Integer> upperCaseIndexes = getUpperCaseIndexes(trimmedInput);
        String lowerCaseReversedResult = new StringBuilder(trimmedInput).reverse().toString().toLowerCase();
        String finalResult = applyUpperCaseIndex(lowerCaseReversedResult, upperCaseIndexes);
        return finalResult;
    }

    private String applyUpperCaseIndex(String lowerCaseResult, List<Integer> upperCaseIndexes) {
        char[] arr = lowerCaseResult.toCharArray();
        for (Integer i :
                upperCaseIndexes) {
            arr[i] = Character.toUpperCase(arr[i]);

        }
        return new String(arr);
    }

    private List<Integer> getUpperCaseIndexes(String trimmedInput) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < trimmedInput.length(); i++) {
            char c = trimmedInput.charAt(i);
            if (characterSet.contains(Character.toString(c))) {
                indexes.add(i);
            }
        }
        return indexes;
    }

}
