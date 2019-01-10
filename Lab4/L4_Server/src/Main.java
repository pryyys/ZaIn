import java.util.ArrayList;
import java.util.Arrays;
import java.net.*;
import java.io.*;
import java.util.List;

public class Main {
    static String text = "";
    static Keys keys;
    static Encrypt encrypt;
    static Decrypt decrypt;
    static List<Long> keysList = new ArrayList<>();

    static public Keys makeKeys()
    {
        keys = new Keys();
        return keys;
    }

    static String outServerMsg(String key)
    {
        switch (decrypt.word)
        {
            case "CLEAR":
                encrypt = new Encrypt("Deleted text: " + text, keysList.get(0), keysList.get(1));
                text = "";
                break;
            case "SEND":
                encrypt = new Encrypt("Text: " + text, keysList.get(0), keysList.get(1));
                break;
            default:
                text += decrypt.word + " ";
                encrypt = new Encrypt("OK", keysList.get(0), keysList.get(1));
                break;
        }
        return encrypt.encrText;
    }

    static List<Long> toLongList(String str)
    {
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
        System.out.println("Ожидается подключение");
        try (ServerSocket server = new ServerSocket(8030)) { // Вызов конструктора и присваивание порта.
            while (true) {
                Socket client = server.accept(); // Устанавливаем соединение с клиен-том.
                        System.out.println("Соединение установленно с " + client.getPort());
                try (DataOutputStream output = new
                        DataOutputStream(client.getOutputStream());
                     DataInputStream input = new
                             DataInputStream(client.getInputStream());)
                {
                    while(true)
                    {
                        makeKeys();
                        output.writeUTF(keys.open);
                        String str = input.readUTF();
                        String stringKeys = input.readUTF();
                        System.out.println("Сообщение от клиента получено: " + str);
                        decrypt = new Decrypt(toLongList(str), keys.d, keys.n);
                        keysList = toLongList(stringKeys);

                        output.writeUTF(outServerMsg(decrypt.word));
                       // output.writeUTF("Я прочитал: " + str);
                    }
                } catch (SocketException ex) {
                    System.out.println("Соединение с " + client.getInetAddress() +
                            ":" + client.getPort() + "разорвано");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
