package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.exeption.NoInformationFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceImplSymbols implements ServiceSymbols {

    public String numberOfCharacters(String text) {

        if (text.isBlank()) {
            throw new NoInformationFoundException("Empty string");
        }

        text = text.replaceAll("\\s", "");

        Map<String, Integer> symbols = new HashMap<>();

        String[] charArray = text.split("");

        for (String ch : charArray) {
            symbols.merge(ch, 1, Integer::sum);
        }

        return symbols.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .map(key -> '"' + key + '"' + ":" + symbols.get(key))
                .collect(Collectors.joining(", "));
    }
}