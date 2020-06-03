package org.inori.game.bns.goods_manager.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class GoodItemKeyGenerator {

    private static final char[] toBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    /**
     * 计算物品的Key
     * @param id
     * @return
     */
    public static String generatorKey(int id) {
        StringBuffer sb = new StringBuffer ( "AA" );

        List<Character> list = new LinkedList<> (  );
        int temp = id * 16;
        while (temp >= 64) {
            list.add ( toBase64[Math.floorMod ( temp, 64 )] );
            temp = Math.floorDiv ( temp, 64 );
        }
        list.add ( toBase64[temp] );

        Collections.reverse (list);
        list.forEach ( character -> sb.append ( character ) );
        return sb.append ( "==" ).toString ();
    }

    public static void main(String[] args) {
        String code = GoodItemKeyGenerator.generatorKey ( 80516);
        System.out.println (code);
    }
}
