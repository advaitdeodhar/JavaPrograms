package org.example;

class Main {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = (m+n) - 1;

        while (i >= 0 && j >= 0 ) {
            if ( nums1[i] > nums2[j] ) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        if ( i == -1 && j >= 0) {
            for ( ;j >= 0; j--, k--) {
                nums1[k] = nums2[j];
            }
        }

        if ( i >= 0 && j == -1 ) {
            for ( ; i >= 0 ; i--, k--) {
                nums1[k] = nums1[i];
            }
        }

    }
}