import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.CharacterCodingException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class third {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:/Users/bajka/OneDrive/Pulpit/adjacent.txt";
        File file = new File(filePath);
        Scanner read = new Scanner(file);
        String[] zm = new String[140];
        int licznik = 0;

        while (read.hasNextLine()) {
            zm[licznik] = read.nextLine();
            licznik++;
        }

        int sum = 0;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < zm.length; i++) {
            Matcher matcher = pattern.matcher(zm[i]);
            int st, end;
            boolean check = false;

            while (matcher.find()) {
                st = matcher.start();
                end = matcher.end(matcher.groupCount());
                if(st>0 && zm[i].charAt(st-1)!='.' &&!Character.isDigit(zm[i].charAt(st-1)))
                    check = true;
                else if(end<139 && zm[i].charAt(end)!='.' &&!Character.isDigit(zm[i].charAt(end)))
                    check = true;
                else if(st >= 1 && i>0 && zm[i-1].charAt(st-1)!='.' &&!Character.isDigit(zm[i-1].charAt(st-1)))
                    check = true;
                else if(end <140 && i>0 && zm[i-1].charAt(end)!='.' &&!Character.isDigit(zm[i-1].charAt(end)))
                    check = true;
                else if(st>=1 && i< zm.length-1 && zm[i+1].charAt(st-1)!='.' &&!Character.isDigit(zm[i+1].charAt(st-1)))
                    check = true;
                else if(end <140 && i< zm.length-1 && zm[i+1].charAt(end)!='.' &&!Character.isDigit(zm[i+1].charAt(end)))
                    check = true;
                for(int j = st;j<end;j++)
                {
                    if(i !=0 && zm[i-1].charAt(j)!='.' &&!Character.isDigit(zm[i-1].charAt(j)))
                        check = true;
                    else if(i < zm.length-1 &&  zm[i+1].charAt(j)!='.' &&!Character.isDigit(zm[i+1].charAt(j)))
                        check = true;
                }
                if (check) {
                    sum += Integer.parseInt(zm[i].substring(st,end));
                    System.out.println(sum);
                    //System.out.println(end);
                }
                check = false;
            }
            System.out.println("suma: "+sum);
        }
    }

}
