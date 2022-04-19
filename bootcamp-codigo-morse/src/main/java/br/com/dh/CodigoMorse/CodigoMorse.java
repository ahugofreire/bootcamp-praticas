package br.com.dh.CodigoMorse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/morse")
public class CodigoMorse {

    private static  Map<String, String> map;
    static {
        map = new LinkedHashMap<>();
        map.put(" ", " ");
        map.put("--..--", ",");
        map.put(".-.-.-", ".");
        map.put("..--..", "?");
        map.put("-----", "0");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "0");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");

    }

    @GetMapping(value = "/{code}")
    @ResponseBody
    public String morseCodeConverter(@PathVariable(value = "code") String code) {

        String[] morseCode = code.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String ch: morseCode) {
            result.append(map.get(ch));
        }
        return "Português:\n" + result;
    }
}

