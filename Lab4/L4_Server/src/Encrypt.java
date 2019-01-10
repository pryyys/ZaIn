import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрюха on 17.11.2018.
 */
public class Encrypt {

    List<Long> textList = new ArrayList<>();
    String encrText = "";
    public Encrypt(String text, long e, long n)
    {
        char [] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++)
        {
            textList.add(Translator.swInt(textArr[i]));
        }

        System.out.println("Message: " + textList);


        for(int i = 0; i < textList.size(); i++)
        {
            long a = textList.get(i);
            a = modular_pow(a, e, n);
            textList.set(i, a);
        }


        System.out.println("Encrypted: " + textList);

        for (Long digit: textList)
        {
            encrText += digit + " ";
        }
    }

    private long modular_pow(long digit, long power, long modul)
    {
        long c = 1;

        for (int i = 1; i <= power; i++)
        {
            c = (c * digit) % modul;
        }

        return c;
    }

    public List<Long> getTextList()
    {
        return textList;
    }

}
