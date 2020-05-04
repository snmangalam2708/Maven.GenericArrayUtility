package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] newArray;

    public ArrayUtility(T[] newArray) {

        this.newArray = newArray;
    }

    public T[] mergeArrays(T[] arrayToMerge) {

       T[] mergeArray = Arrays.copyOf(newArray, newArray.length + arrayToMerge.length);
        for (int i=0; i<newArray.length;i++){
            mergeArray[i] = newArray[i];
        }

        for(int i = newArray.length, j=0; j<arrayToMerge.length; i++, j++){
            mergeArray[i] = arrayToMerge[j];
        }

        return mergeArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        int occ =0;
        for (T c : newArray) {
            if (c==valueToEvaluate){
                occ++;
            }
        }

        return occ;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T value) {

        newArray = mergeArrays(arrayToMerge);
        return getNumberOfOccurrences(value);

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        newArray = mergeArrays(arrayToMerge);
        int count = 0;
        T common = null;
        for(T c : newArray){
            if ( getNumberOfOccurrences(c) > count){
                count = getNumberOfOccurrences(c);
                common = c;
            }
        }
        return common;
    }

    public T[] removeValue(T object) {

        int j=0;
        T[] appArray = Arrays.copyOf(newArray, newArray.length - getNumberOfOccurrences(object));
        for( int i=0; i<newArray.length; i++){
            if (newArray[i] !=object)
            {
                appArray[j] = newArray[i];
                j++;
            }
        }
        return appArray;
    }
}
