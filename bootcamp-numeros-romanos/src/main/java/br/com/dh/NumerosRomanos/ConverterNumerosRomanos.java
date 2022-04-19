package br.com.dh.NumerosRomanos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/numero")
public class ConverterNumerosRomanos {
    private static int[] numerosDecimais = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping(value = "/{num}")
    @ResponseBody
    public  String ConverterParaRomano(@PathVariable(value = "num") int num){
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < numerosDecimais.length; i++) {
            int parteInteira = num/ numerosDecimais[i];
            num -= numerosDecimais[i] * parteInteira;
            resultado.append( String.join("", Collections.nCopies(parteInteira, numerosRomanos[i])));
        }

        return "Número Romano: \n" + resultado.toString();
    }

}
