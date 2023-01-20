import java.util.Arrays;

class Test extends SortingAlgorithms {

    //Tester alle algoritmene for et tilfeldig, sortert og reversert array
    public void test10 () {
        int[] array = new int[10];    //array for testing av korrekthet 

        
        //Selection-sort/Utplukksortering 
        System.out.println("-----Selection-sort-----");
        System.out.println("Random");
        generateArray(array, "random", true);
        selectionSort(array, true);
        System.out.println("Ascending");
        generateArray(array, "ascending", true);
        selectionSort(array, true);
        System.out.println("Descending");
        generateArray(array, "descending", true);
        selectionSort(array, true);
        
        
        //Insertion-sort/Innstikksortering 
        System.out.println("-----Insertion-sort-----");
        System.out.println("Random");
        generateArray(array, "random", true);
        insertionSort(array, true);
        System.out.println("Ascending");
        generateArray(array, "ascending", true);
        insertionSort(array, true);
        System.out.println("Descending");
        generateArray(array, "descending", true);
        insertionSort(array, true); 
        

        //Heap-sort
        System.out.println("-----Heap-sort-----");
        System.out.println("Random");       
        generateArray(array, "random", true);
        heapSort(array, true);
        System.out.println("Ascending");
        generateArray(array, "ascending", true);
        heapSort(array, true);
        System.out.println("Descending");
        generateArray(array, "descending", true);
        heapSort(array, true); 

        
        //Quick-sort
        System.out.println("\n-----Quick-sort-----");
        int start = 0;
        int slutt = array.length-1;
        System.out.println("Random");
        generateArray(array, "random", true);
        //quickSort(array, start, slutt, true);
        quickSort2(array, start, slutt, true);
        System.out.println("\nAscending");
        generateArray(array, "ascending", true);
        //quickSort(array, start, slutt, true);
        quickSort2(array, start, slutt, true);        
        System.out.println("\nDescending");
        generateArray(array, "descending", true);
        //quickSort(array, start, slutt, true);
        quickSort2(array, start, slutt, true);        
        System.out.println("");
        
        
        //Merge-sort
        System.out.println("\n-----Merge-sort-----");
        System.out.println("Random");
        generateArray(array, "random", true);
        mergeSort(array, true);
        System.out.println("\nAscending");
        generateArray(array, "ascending", true);
        mergeSort(array, true);
        System.out.println("\nDescending");
        generateArray(array, "descending", true);
        mergeSort(array, true);
        System.out.println(""); 
        
        
        //Bucket-sort
        System.out.println("\n-----Bucket-sort-----");
        System.out.println("Random");
        generateArray(array, "random", true);
        bucketSort(array, true);
        System.out.println("\nAscending");
        generateArray(array, "ascending", true);
        bucketSort(array, true);
        System.out.println("\nDescending");
        generateArray(array, "descending", true);
        bucketSort(array, true);
        System.out.println(""); 
        
        
        //Radix-sort
        System.out.println("-----Radix-sort-----");
        System.out.println("Random");
        generateArray(array, "random", true);
        radixSort(array, true);
        System.out.println("Ascending");
        generateArray(array, "ascending", true);
        radixSort(array, true);
        System.out.println("Descending");
        generateArray(array, "descending", true);
        radixSort(array, true);
        
    }



    public void speedtest () {
    int[] elements = {1000, 5000, 10000, 50000, 100000, 1000000, 10000000, 100000000, 1000000000};    //array for ulike hastigheter 


        //insertion, selection, heap og merge fungerer på samme måte
        //System.out.println("\n-----Selection-sort-----");
        //System.out.println("\n-----Insertion-sort-----");      
        //System.out.println("\n-----Heap-sort-----");
        //System.out.println("\n-----Quick-sort-----");
        //System.out.println("\n-----Merge-sort-----");
        //System.out.println("\n-----Bucket-sort-----");
        //System.out.println("\n-----Radix-sort-----");

        
        //tester hvor antall elementer lik elements[i]
        for (int i = 0; i < elements.length; i++) {
            int[] array = new int[elements[i]];
            long startTime, endTime;
            float sec;

            int start = 0;
            int slutt = array.length-1;

            
            //Valuelimit random
            generateArray(array, "random", true);
            startTime = System.currentTimeMillis();
            //selectionSort(array, false);
            //heapSort(array, false);
            //quickSort(array, start, slutt, false);
            //quickSort2(array, start, slutt, false);
            //mergeSort(array, false);
            bucketSort(array, false);
            //radixSort(array, false);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Random, " + elements[i] + " elementer,  med value-limit 100: " + sec + " seconds");
            
            //Uten Valuelimit random
            generateArray(array, "random", false);
            startTime = System.currentTimeMillis();
            //selectionSort(array, false);
            //heapSort(array, false);
            //quickSort(array, start, slutt, false);
            //quickSort2(array, start, slutt, false);
            //mergeSort(array, false);
            //bucketSort(array, false); //ikke mulig, outOfMemoryError
            //radixSort(array, false);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Random, " + elements[i] + " elementer,  uten value-limit 100: " + sec + " seconds");
            
            //Valuelimit ascending
            generateArray(array, "ascending", true);
            startTime = System.currentTimeMillis();
            //selectionSort(array, false);
            //heapSort(array, false);
            //quickSort(array, start, slutt, false);
            //quickSort2(array, start, slutt, false);
            //mergeSort(array, false); 
            bucketSort(array, false);      
            //radixSort(array, false);     
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Ascending, " + elements[i] + " elementer,  med value-limit 100: " + sec + " seconds");
       
            //Uten Valuelimit ascending
            generateArray(array, "ascending", false);
            startTime = System.currentTimeMillis();
            //selectionSort(array, false);
            //heapSort(array, false);  
            //quickSort(array, start, slutt, false);          
            //quickSort2(array, start, slutt, false);
            //mergeSort(array, false);
            //bucketSort(array, false); 
            //radixSort(array, false);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Ascending, " + elements[i] + " elementer,  uten value-limit 100: " + sec + " seconds");

            //Valuelimit descending
            generateArray(array, "descending", true);
            startTime = System.currentTimeMillis();
            //selectionSort(array, false);
            //heapSort(array, false);
            //quickSort(array, start, slutt, false);
            //quickSort2(array, start, slutt, false);
            //mergeSort(array, false);
            bucketSort(array, false);
            //radixSort(array, false);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Descending, " + elements[i] + " elementer,  med value-limit 100: " + sec + " seconds");
       
            //Uten Valuelimit descending
            generateArray(array, "descending", false);
            startTime = System.currentTimeMillis();
            //selectionSort(array, false);
            //heapSort(array, false);
            //quickSort(array, start, slutt, false);
            //quickSort2(array, start, slutt, false);
            //mergeSort(array, false);            
            //bucketSort(array, false);
            //radixSort(array, false);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Descending, " + elements[i] + " elementer,  uten value-limit 100: " + sec + " seconds");

            System.out.println("");
            
        } 
        

        /*
        System.out.println("\n-----Arrays.sort()-----");

        //tester hvor antall elementer lik elements[i]
        for (int i = 0; i < elements.length; i++) {
            int[] array = new int[elements[i]];
            long startTime, endTime;
            float sec;


            //Valuelimit random
            generateArray(array, "random", true);
            startTime = System.currentTimeMillis();
            Arrays.sort(array);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Random, " + elements[i] + " elementer,  med value-limit: " + sec + " seconds");
       
            //Uten Valuelimit random
            generateArray(array, "random", false);
            startTime = System.currentTimeMillis();
            Arrays.sort(array);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Random, " + elements[i] + " elementer,  uten value-limit: " + sec + " seconds");
        
            //Valuelimit ascending
            generateArray(array, "ascending", true);
            startTime = System.currentTimeMillis();
            Arrays.sort(array);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Ascending, " + elements[i] + " elementer,  med value-limit: " + sec + " seconds");
       
            //Uten Valuelimit ascending
            generateArray(array, "ascending", false);
            startTime = System.currentTimeMillis();
            Arrays.sort(array);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Ascending, " + elements[i] + " elementer,  uten value-limit: " + sec + " seconds");

            //Valuelimit descending
            generateArray(array, "descending", true);
            startTime = System.currentTimeMillis();
            Arrays.sort(array);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Descending, " + elements[i] + " elementer,  med value-limit: " + sec + " seconds");
       
            //Uten Valuelimit descending
            generateArray(array, "descending", false);
            startTime = System.currentTimeMillis();
            Arrays.sort(array);
            endTime = System.currentTimeMillis();
            sec = (endTime - startTime) / 1000F; 
            System.out.println("Descending, " + elements[i] + " elementer,  uten value-limit: " + sec + " seconds");
        
            System.out.println("");
        }
        */
    }



    public static void main(String[] args) {
        Test speedtest = new Test();
        //oblig.test10();
        speedtest.speedtest();
    }
}