import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperatures = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int cityIndexCold = 0;
        int cityIndexHot = 0;

        for (int i = 0; i < cities.length; i++) {
            if (temperatures[i][0] < temperatures[cityIndexCold][0]) {
                cityIndexCold = i;
            }
            if (temperatures[i][1] > temperatures[cityIndexHot][1]) {
                cityIndexHot = i;
            }

        }

        System.out.println("A temperatura mais baixa foi em " + cities[cityIndexCold] + " com " + temperatures[cityIndexCold][0] + " C.");
        System.out.println("A temperatura mais alta foi em " + cities[cityIndexHot] + " com " + temperatures[cityIndexHot][1] + " C.");
    }
}
