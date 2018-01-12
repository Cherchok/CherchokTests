package Subsequence;


import java.util.List;

class SubsequenceImpl implements Subsequence {

    SubsequenceImpl(){}


    public boolean find(List x, List y) {
        boolean result = true;

        int k = 0;
        for (Object aX : x) {
            if (!result) {
                break;
            }
            result = false;
            for (int j = k; j < y.size(); j++) {
                if (y.get(j).equals(aX)) {
                    k = j + 1;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


 }
