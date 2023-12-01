import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class firstb {
        public static void main(String[] args) throws FileNotFoundException {
            try {
                String filePath = "C:/Users/bajka/OneDrive/Pulpit/kody.txt";
                HashMap<String,Integer> mapOfDigits = new HashMap<String,Integer>();
                mapOfDigits.put("one",1);
                mapOfDigits.put("two",2);
                mapOfDigits.put("three",3);
                mapOfDigits.put("four",4);
                mapOfDigits.put("five",5);
                mapOfDigits.put("six",6);
                mapOfDigits.put("seven",7);
                mapOfDigits.put("eight",8);
                mapOfDigits.put("nine",9);

                final String[] digitsNames = {"one","two","three","four","five","six","seven","eight","nine"};
                String pom = new String();
                final int[] position = new int[9];
                File file = new File(filePath);
                Scanner read = new Scanner(file);
                int suma = 0;
                while(read.hasNextLine())
                {
                    pom = read.nextLine();
                    int firstint = 0;
                    int lastint = 0;
                    firstint = findFirstIntegerpos(pom);
                    lastint = findLastIntegerpos(pom);
                    for(int i=0; i<9; i++)
                    {
                        position[i]=pom.indexOf(digitsNames[i]);
                    }
                    int maxim = 0;
                    int minim = 0;
                    int maxx = 0;
                    int minn = 0;
                    maxim = Arrays.stream(position).max().getAsInt();
                    minim = FindMinim(position);

                    if(lastint < maxim)
                    {
                    for(int i=0; i<9; i++) {
                        if (pom.indexOf(digitsNames[i]) == maxim) {
                            maxx = mapOfDigits.get(digitsNames[i]);
                        }
                    }
                    }
                    else {
                        maxx = findLastInteger(pom);
                    }
                    if(firstint > minim) {
                        for (int i = 0; i < 9; i++) {
                            if (pom.indexOf(digitsNames[i]) == minim ) {
                                minn = mapOfDigits.get(digitsNames[i]);
                            }
                        }
                    }
                    else{
                        minn = findFirstInteger(pom);
                    }
                    suma += minn*10+maxx ;
                }
                System.out.println(suma);

            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        }

    static Integer findFirstInteger(String s) {
        int i = 0;
        while (i < s.length() && !Character.isDigit(s.charAt(i))) {
            i++;
        }

        return Integer.parseInt(String.valueOf(s.charAt(i)));
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

        return null;
    }
    static Integer findFirstIntegerpos(String s) {
        int i = 0;
        while (i < s.length() && !Character.isDigit(s.charAt(i))) {
            i++;
        }
        if(Character.isDigit(s.charAt(i))){
            return i;
        }
        return Integer.MAX_VALUE;

    }

    static Integer findLastIntegerpos(String s) {
        int x = s.length()-1;
        while (x >= 0 && !Character.isDigit(s.charAt(x))) {
            x--;

        }

        if(x>=0 && Character.isDigit(s.charAt(x)))
        {
            return x;
        }
        return -1;
    }
        public static int FindMinim(int[] arr)
        {
            int najmniejszaDodatnia = Integer.MAX_VALUE;
            for (int liczba : arr) {
                if (liczba >= 0 && liczba < najmniejszaDodatnia) {
                    najmniejszaDodatnia = liczba;
                }
            }
            return najmniejszaDodatnia;
        }
    }

