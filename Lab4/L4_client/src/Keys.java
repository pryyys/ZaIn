import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Андрюха on 17.11.2018.
 */
public class Keys {
    List<Long> simpleDigits = new ArrayList<>();
    List<Long> elementsOfE = new ArrayList<>();
    List<Long> elementsOfD = new ArrayList<>();
    String open = "";
    String close = "";
    long p;
    long q;
    long n;
    long fi;
    long e;
    long d;
    long i = 2;

    public Keys()
    {
        Random random = new Random(System.currentTimeMillis());

        try
        {
            FileInputStream fstream = new FileInputStream("e.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            List<String> strList = new ArrayList<>();
            String strLine;

            while((strLine = reader.readLine()) != null)
            {
                strList.add(strLine);
                simpleDigits.add(Long.parseLong(strLine));
            }

            p = Integer.parseInt(strList.get(random.nextInt(strList.size())));
         //   System.out.println("Выбираю p. \n p = " + p);
            do
            {
                q = Integer.parseInt(strList.get(random.nextInt(strList.size())));
            } while (q == p);
         //   System.out.println("Выбираю q. \n q = " + q);


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        n = p * q;
        System.out.println("n = " + n);

        fi = (p - 1) * (q - 1);
      //  System.out.println("Вычисляю fi. \n fi = " + fi);

        for (Long digit : simpleDigits)
        {
            if (digit < fi)
            {
                if (fi % digit != 0)
                {
                    elementsOfE.add(digit);
                }
            }
        }
        e = elementsOfE.get(random.nextInt(elementsOfE.size()));
        System.out.println("e = " + e);


        while (elementsOfD.isEmpty())
        {
            long a = (i * e) % fi;
            if (a == 1)
            {
                elementsOfD.add(i);
            }
            i++;
        }
        System.out.println(elementsOfD);
        d = elementsOfD.get(random.nextInt(elementsOfD.size()));
        System.out.println("d = " + d);

        open = e + " " + n + " ";
        close = d + " " + n + " ";

        System.out.println("Выбрана пара открытых ключей: [" + open +"]");
        System.out.println("Выбрана пара закрытых ключей: [" + close +"]");
    }
}
