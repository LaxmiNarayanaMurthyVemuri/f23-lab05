package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList  {
        // Write your implementation below with API documentation
    private InheritanceSortedIntList list;

    public DelegationSortedIntList() {
        list =  new InheritanceSortedIntList();
    }


    public boolean add(int num) {
        return this.list.add(num);   
    }

    public boolean addAll(IntegerList all) {
        return this.list.addAll(all);
    }

    

    public int getTotalAdded() {
        return this.list.totalElementsAdded;
    }

    public int get(int index) {
        return -1;
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
        for (int i = 0; i < this.list.totalElementsAdded; i++) {
            System.out.print(list.get(i));
            System.out.print(",");
        }
        return "";

    }

}