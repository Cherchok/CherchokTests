package Subsequence;

import java.util.List;


interface Subsequence {
    /**
    * <p>Определяет возможность получения первой последовательности
    * из второй путем удаления некоторых элементов второй последовательности</p>
    * @param x первая последовательность
    * @param y вторая последовательность
    * @return true - если возможно / false - если нет
    */
    boolean find(List x, List y);
}
