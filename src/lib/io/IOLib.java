package lib.io;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IOLib {
    static public ValidationResult<String, List<String>> inputValidator(String inputRaw) {
        Set<String> allowedChar = new HashSet<String>();
        allowedChar.addAll(
                Arrays.asList(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" }));

        // Input splitted are input with extra whitespace ignored
        List<String> inputSplitted = Arrays.asList(inputRaw.toUpperCase().split(" ")).stream().filter(card -> {
            return card.compareTo("") != 0;
        }).collect(Collectors.toList());
        ValidationResult<String, List<String>> result = new ValidationResult<String, List<String>>("",
                Arrays.asList(new String[] {}));
        if (inputSplitted.size() > 4) {
            result.message = "Terlalu banyak kartu";
            return result;
        } else if (inputSplitted.size() < 4) {
            result.message = "Terlalu sedikit kartu";
            return result;
        }

        Boolean allAllowed = true;
        for (int i = 0; i < inputSplitted.size(); i++) {
            allAllowed = allAllowed && allowedChar.contains(inputSplitted.get(i));
        }
        inputSplitted.forEach((card) -> {
        });

        if (!allAllowed) {
            result.message = "Kartu yang anda masukkan tidak valid!";
            return result;
        }

        result.cards = inputSplitted;

        return result;
    }
}
