package com.iesnervion.agomez.a2048.Entities;

import java.util.ArrayList;

/**
 * Created by aleja on 05/03/2018.
 */

public class MyQuickSort
{
    private ArrayList<Usuario> array;
    private int length;

    public void sort(ArrayList<Usuario> inputArr) {

        if (inputArr == null || inputArr.size() == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.size();
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;

        Usuario pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2);
        while (i <= j) {
            while (array.get(i).compareTo(pivot) > 0) {
                i++;
            }
            while (array.get(j).compareTo(pivot) < 0) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        Usuario temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
