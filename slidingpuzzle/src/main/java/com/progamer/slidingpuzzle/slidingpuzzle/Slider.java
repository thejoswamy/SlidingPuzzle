package com.progamer.slidingpuzzle.slidingpuzzle;


public class Slider {

    private int[] slate;
    private int N;

    public Slider(int n) {

        N = n;

        slate = new int[N*N];
        for (int i = 0; i < N*N; i++)
            slate[i] = i;

    }

    //Method to provide a valid shuffled slate.
    public void shuffleSlider() {

        do {
            shuffle();
        } while (!isSolvable(slate));

    }

    //Normal shuffling of an array.
    public void shuffle() {

        int r, temp;
        int len = N*N;

        for (int i = 0; i < len; i++) {
            r =  i + (int) (Math.random() * (len-i));

            temp = slate[i];
            slate[i] = slate[r];
            slate[r] = temp;
        }

    }

    // This method takes an array that represents
    // a sliding puzzle and determines if it is solvable.
    public static boolean isSolvable(int[] p) {

        int inversions = 0;
        int size = (int) Math.sqrt(p.length);

        for (int i = 0; i < p.length - 1; i++) {
            // Check if a larger number exists after the current
            // place in the array, if so increment inversions.
            for (int j = i + 1; j < p.length; j++)
                if (p[i] > p[j])
                    inversions++;

            // Determine if the distance of the blank space from the bottom
            // right is even or odd, and increment inversions if it is odd.
            if (p[i] == 0 && i % 2 == 1)
                inversions++;

            //In case of even size, add row of blank space
            if (p[i] == 0 && size % 2 == 0) {
                int row = (i / size) + 1;
                inversions += row;
            }
        }

        // If inversions is even, the puzzle is solvable.
        return (inversions % 2 == 0);
    }

    //To determine whether the puzzle is completed or not
    public boolean isCompleted() {

        int len = N*N;
        for (int i = 0; i < len - 1; i++) {
            if (slate[i] != i+1)
                return false;
        }

        return true;
    }

    //Returns a neighbouring empty space position,
    //returns -1 if not present.
    public int isNeighbourEmpty(int position) {
        int top    = position - N;
        int bottom = position + N;
        int left   = position - 1;
        int right  = position + 1;
        int len    = N * N;

        if (top > 0 && top <= len && slate[top-1] == 0)
            return top;

        if (bottom > 0 && bottom <= len && slate[bottom-1] == 0)
            return bottom;

        if (left > 0 && left <= len  && (left%N) != 0 && slate[left-1] == 0)
            return left;

        if (right > 0 && right <= len && (right%N) != 1 && slate[right-1] == 0)
            return right;

        return -1;
    }

    public void swaps(int i, int j) {

        int temp;
        temp = slate[i-1];
        slate[i-1] = slate[j-1];
        slate[j-1] = temp;

    }

    public String valueAt(int position) {
        return Integer.toString(slate[position-1]);
    }

    //Returns the position of the blank space.
    public int zeroAt() {

        int result = 0;
        for (int i = 0; i < N*N; i++)
            if (slate[i] == 0)
                result = i+1;

        return result;
    }


}
