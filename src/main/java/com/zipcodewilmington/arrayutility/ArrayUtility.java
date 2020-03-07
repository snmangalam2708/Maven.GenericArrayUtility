package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] newArray;

    public ArrayUtility(T[] newArray) {

        this.newArray = newArray;
    }

    public T[] mergeArrays(T[] arrayToMerge) {

        T[] ansArray = Arrays.copyOf(newArray, newArray.length + arrayToMerge.length);

        for (int i = 0; i < newArray.length; i++) {
            ansArray[i] = newArray[i];

        }
        for (int i = newArray.length, j = 0; j < arrayToMerge.length; i++, j++) {
            ansArray[i] = arrayToMerge[j];
        }
        return ansArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int counter = 0;
        for (T occ : newArray) {
            if (occ == valueToEvaluate) {
                counter++;

            }
        }
        return counter;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T value) {

        newArray = mergeArrays(arrayToMerge);
        return getNumberOfOccurrences(value);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        Integer counter = 0;
        T mostCommon = null;
        T[] appArray = mergeArrays(arrayToMerge);
        for (T thing : appArray) {
            if (getNumberOfOccurrences(thing) > counter) {
                counter = getNumberOfOccurrences(thing);
                mostCommon = thing;

            }
        }
        return mostCommon;
    }

    public T[] removeValue(T object) {

        Integer index = 0;
        T[] appArray = Arrays.copyOf(newArray, newArray.length - getNumberOfOccurrences(object));
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] != object) {
                appArray[index] = newArray[i];
                index++;
            }
        }
        return appArray;
    }
}
