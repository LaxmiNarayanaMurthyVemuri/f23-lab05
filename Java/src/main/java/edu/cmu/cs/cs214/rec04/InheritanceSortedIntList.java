package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    int totalElementsAdded;
    List<Integer> list;

    public InheritanceSortedIntList() {
        totalElementsAdded = 0;
        list =  new ArrayList<>();
    }

    private int findInsertionPoint(int num) {
        int start = 0;
        int end = totalElementsAdded;

        while (start < end) {
            int mid = (start + end) / 2;
            if (num <= list.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean add(int num) {
        // Find the insertion point using binary search
        int insertionPoint = findInsertionPoint(num);
        
        // Add the element at the found index
        list.add(insertionPoint, num);
        totalElementsAdded++;
        return true;
    }

    public boolean addAll(IntegerList all) {
        // System.out.println(all);
        for (int i = 0; i < all.size(); i++) {
            int num = all.get(i);
            int insertionPoint = findInsertionPoint(num);
        
            // Add the element at the found index
            System.out.println(list + " " + insertionPoint + " " + num);
            list.add(insertionPoint, num);
            totalElementsAdded++;
        }

        return true;
    }

    

    public int getTotalAdded() {
        return this.totalElementsAdded;
    }

    public int get(int index) {
        return list.indexOf(index);
    }

    public boolean remove(int num) {
        return false;
    }

    public boolean removeAll(IntegerList list) {
        return false;
    }


    public int size() {
        return list.size();
    }

    public String toString() {
        for (int i = 0; i < totalElementsAdded; i++) {
            System.out.print(list.get(i));
            System.out.print(",");
        }
        return "";

    }


}