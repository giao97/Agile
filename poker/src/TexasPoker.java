import java.lang.reflect.Array;
import java.util.Arrays;

public class TexasPoker {
    public static String Straight = "23456789TJQKA";
    public static String CheckWinner(String Black, String White){
        //判断输赢
        int black = CheckPokerType(Black), white = CheckPokerType(White);
        if (black > white)
            return "Black wins";
        else if (black < white)
            return "White wins";
        else{
            if (black == 0 || black == 5){
                //散牌和同花
                return CompareBiggest0(Black, White);
            }
            else if (black == 1 || black == 2){
                //对子和两对
                return CompareBiggest1(black, Black, White);
            }
            else if (black == 3 || black == 6){
                //三条和葫芦
                return CompareBiggest2(3, Black, White);
            }
            else if (black == 7){
                //铁支
                return CompareBiggest2(4, Black, White);
            }
            else {
                //顺子和同花顺
                return CompareBiggest2(1, Black, White);
            }
        }
    }

    public static int CheckPokerType(String Pks){
        //判断牌的类型
        /*牌面类型：
         * 0：散牌
         * 1：对子
         * 2：两对
         * 3：三条
         * 4：顺子
         * 5：同花
         * 6：葫芦
         * 7：铁支
         * 8：同花顺 */
        int type = 0;
        if (CheckFlush(Pks) && CheckStraight(Pks))
            type = 8;
        else if (CheckKinds(Pks) == 4)
            type = 7;
        else if (CheckKinds(Pks) == 3 && CheckPairs(Pks) == 1)
            type = 6;
        else if (CheckFlush(Pks))
            type = 5;
        else if (CheckStraight(Pks))
            type = 4;
        else if (CheckKinds(Pks) == 3)
            type = 3;
        else if (CheckPairs(Pks) == 2)
            type = 2;
        else if (CheckPairs(Pks) == 1)
            type = 1;
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
        String values = new String(GetValues(Pks));
        if (Straight.contains(values))
            return true;
        return false;
    }

    public static int CheckKinds(String Pks){
        //判断相同点数个数
        int kind = 1;
        char[] values = GetValues(Pks);
        int i = 0;
        int num = 1;
        for (int j = i + 1; j < values.length; j++){
            if (values[j] == values[i]){
                num++;
                if (num > kind)
                    kind = num;
            }
            else {
                i = j;
                num = 1;
            }
        }
        return kind;
    }

    public static int CheckPairs(String Pks){
        //判断对子个数
        int pairs = 0;
        char[] values = GetValues(Pks);
        int i = 0;
        int num = 1;
        for (int j = i + 1; j < values.length; j++){
            if (values[j] == values[i]){
                num++;
                if (num == 2)
                    pairs++;
                else if (num == 3)
                    pairs--;
            }
            else {
                i = j;
                num = 1;
            }
        }
        return pairs;
    }

    public static char[] GetSuits(String Pks){
        //获取五张牌的花色
        char[] suit = new char[5];
        for (int i = 1, j = 0; i < 15; i += 3, j++)
            suit[j] = Pks.charAt(i);
        return suit;
    }

    public static char[] GetValues(String Pks){
        //获取五张牌的大小
        char[] values = new char[(Pks.length() + 1) / 3];
        for (int i = 0, j = 0; i < Pks.length(); i += 3, j++)
            values[j] = Pks.charAt(i);
        values = PokerSort(values);
        return values;
    }

    public static char[] PokerSort(char[] values){
        //按大小排序扑克牌
        for (int i = 1; i < values.length; i++){
            for(int j = 0; j < i; j++){
                if (Straight.indexOf(values[j]) > Straight.indexOf(values[i])){
                    char temp = values[i];
                    for(int k = i; k > j; k--)
                        values[k] = values[k - 1];
                    values[j] = temp;
                    break;
                }
            }
        }
        return values;
    }

    public static char FindBiggest(int kind, String Pks){
        //找到相应数量的最大的牌
        char biggest = ' ';
        char[] values = GetValues(Pks);
        int i = values.length - 1;
        if (i == 0)
            return values[0];
        int num = 1;
        for (int j = i - 1; j >= 0; j--){
            if (values[j] == values[i]){
                num++;
            }
            if (num == kind) {
                biggest = values[i];
                break;
            }
            else
                i = j;
        }
        return biggest;
    }

    public static String DropBiggest(char Pk, String Pks){
        //删除相指定的牌
        String drop = "";
        for (int i = 0; i < Pks.length(); i++){
            if (Pks.charAt(i) != Pk)
                drop += Pks.charAt(i);
            else
                i += 2;
        }
        return drop;
    }

    public static String CompareBiggest0(String Black, String White){
        //比较单牌大小
        int winner;
        char black, white;//最大牌面
        while(Black != "" && White != ""){
            black = FindBiggest(1, Black);
            white = FindBiggest(1, White);
            winner = ComparePokers(black, white);
            if (winner == 1)
                return "Black wins";
            else if (winner == 2)
                return "White wins";
            Black = DropBiggest(black, Black);
            White = DropBiggest(white, White);
        }
        return "Tie";
    }

    public static String CompareBiggest1(int type, String Black, String White){
        //比较对子大小
        int winner;
        char black = FindBiggest(2, Black), white = FindBiggest(2, White);
        winner = ComparePokers(black, white);
        if (winner == 1)
            return "Black wins";
        else if (winner == 2)
            return "White wins";
        else {
            Black = DropBiggest(black, Black);
            White = DropBiggest(white, White);
            if (type == 2){
                black = FindBiggest(2, Black);
                white = FindBiggest(2, White);
                winner = ComparePokers(black, white);
                if (winner == 1)
                    return "Black wins";
                else if (winner == 2)
                    return "White wins";
                Black = DropBiggest(black, Black);
                White = DropBiggest(white, White);
            }
            return CompareBiggest0(Black, White);
        }
    }

    public static String CompareBiggest2(int kind, String Black, String White){
        //比较大于2张重复牌及顺子的大小
        int winner = ComparePokers(FindBiggest(kind, Black), FindBiggest(kind, White));
        if (winner == 1)
            return "Black wins";
        else if (winner == 2)
            return "White wins";
        else
            return "Tie";
    }

    public static int ComparePokers(char black, char white){
        //0:平 1:黑胜 2:白胜
        int B = Straight.indexOf(black), W = Straight.indexOf(white);
        if (B > W)
            return 1;
        else if (B < W)
            return 2;
        else
            return 0;
    }
}
