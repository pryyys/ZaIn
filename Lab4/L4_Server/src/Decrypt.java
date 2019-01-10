import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрюха on 17.11.2018.
 */
public class Decrypt {
    List<Long> textList = new ArrayList<>();
    String word = "";
    public Decrypt(List<Long> digitList, long d, long n)
    {
        textList = digitList;

        System.out.println("Encrypred: " + textList);


        for(int i = 0; i < textList.size(); i++)
        {
            long a = textList.get(i);
            a = modular_pow(a, d, n);
            textList.set(i, a);
        }


        System.out.println("Decrypted: " + textList);

        for (Long digit : textList)
        {
            word += Translator.swChar(digit);
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
