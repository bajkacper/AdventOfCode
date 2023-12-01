import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class first {
    static Integer findFirstInteger(String s) {
        int i = 0;
        while (i < s.length() && !Character.isDigit(s.charAt(i))) {
            i++;
        }

        return Integer.parseInt(s.substring(i, i+1));
    }

    static Integer findLastInteger(String s) {
        int x = s.length()-1;
        while (x >= 0 && !Character.isDigit(s.charAt(x))) {
            x--;
        }
        if(x>=0)
        {
            char lastChar = s.charAt(x);
            return Integer.parseInt(String.valueOf(lastChar));
        }

        // Return null or another default value if no integer is found
        return null;
    }
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String filePath = "C:/Users/bajka/OneDrive/Pulpit/kody.txt";
            String zmienna = new String();
            File plik = new File(filePath);
            Scanner odczyt = new Scanner(plik);
            int suma = 0;
            while (odczyt.hasNextLine()) {
                zmienna = odczyt.nextLine();
//                Matcher matcher = Pattern.compile("\\d").matcher(zmienna);
//                int i = Integer.valueOf(matcher.group());
                Integer i = findFirstInteger(zmienna);
               Integer z = findLastInteger(zmienna);

               suma +=  i*10+z;
            }
            System.out.println(suma);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }



    }
}