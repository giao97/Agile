import java.lang.reflect.Array;
import java.util.Arrays;

public class TexasPoker {
    public static String Straight = "23456789TJQKA";
    public static String CheckWinner(String Black, String White){
        String result = "";

        return result;
    }

    public static int CheckPokerType(String Pks){
        //判断牌的类型
        int type = 0;

        return type;
    }

    public static boolean CheckFlush(String Pks){
        //判断是否同花
        char[] suits = GetSuits(Pks);
        for (int i = 0; i < suits.length; i++)
            if(suits[i] != suits[0])
                return false;
        return true;
    }

    public static boolean CheckStraight(String Pks){
        //判断顺子
        String values = GetValues(Pks).toString();
        if (Straight.contains(values))
            return true;
        return false;
    }

    public static int CheckKinds(String Pks){
        //判断相同点数个数
        int kind = 0;

        return kind;
    }

    public static int CheckPairs(String Pks){
        //判断对子个数
        int pairs = 0;

        return pairs;
    }

    public static char[] GetSuits(String Pks){
        char[] suit = new char[5];
        for (int i = 1, j = 0; i < 15; i += 3, j++)
            suit[j] = Pks.charAt(i);
        return suit;
    }

    public static int[] GetValues(String Pks){
        int[] values = new int[5];
        for (int i = 0, j = 0; i < 15; i += 3, j++)
            values[j] = (int) Pks.charAt(i);
        Arrays.sort(values);
        return values;
    }
}
