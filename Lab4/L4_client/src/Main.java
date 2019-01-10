import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Long> keysList = new ArrayList<>();
    private static Keys keys;
    static Encrypt encrypt;
    static Decrypt decrypt;


    static Keys makeKeys()
    {
        keys = new Keys();
        return keys;
    }

    static List<Long> toLongList(String str)
    {
      //  System.out.println(str);
        List<Long> list = new ArrayList<>();
        String temp = "";
        char [] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++)
        {
            if (charArr[i] != ' ')
            {
                temp += "" + charArr[i];
            }
            else
            {

                    list.add(Long.parseLong(temp));

                    temp = "";

            }
        }
        return list;
    }

    public static void main(String[] args) {
        try (Socket client = new Socket(InetAddress.getLocalHost(), 8030); // Вызов конструктора, принимающий параметры
// LocalHost- текущий IP, и порт
                     DataOutputStream output = new
                     DataOutputStream(client.getOutputStream());
        DataInputStream input = new
                DataInputStream(client.getInputStream());
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(System.in))
) {
            while(true)
            {
                String stringKeys = input.readUTF();

                keysList = toLongList(stringKeys);
                System.out.println(keysList);
                String str = reader.readLine();
                encrypt = new Encrypt(str, keysList.get(0), keysList.get(1));

                output.writeUTF(encrypt.encrText);
                makeKeys();
                output.writeUTF(keys.open);

                String serverMsg = input.readUTF();
                List<Long> listMsg;
                listMsg = toLongList(serverMsg);
                decrypt = new Decrypt(listMsg, keys.d, keys.n);
                System.out.println("Сервер -> " + decrypt.word);

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}