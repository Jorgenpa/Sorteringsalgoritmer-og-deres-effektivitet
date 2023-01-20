class Ekstra {
    public int[] mergeSort (int[] a, int left, int right, boolean print) {
        //if (print) {print(a);}

        //dersom arrayet har mer enn 1 element igjen splittes den
        //while (a.length < 1) {
        if (left < right) {
            int separator = (left+right)/2;

            //kaller mergeSort() på første halvdel og andre halvdel av (sub)arrayet
            int[] a1 = new int[a.length/2];
            int[] a2 = new int[(a.length/2)-separator];
            for (int i = 0; i <= separator; i++) {
                System.out.println(a1[i] + " blir til " + a[i]);
                a1[i] = a[i];
            }
            System.out.println("");
            for (int i = 0; i <= separator; i++) {
                System.out.println(a2[i] + " blir til " + a[i+separator+1]);
                a2[i] = a[i+separator+1];
            }
            
            mergeSort(a1, left, separator, print);
            System.out.println("Print a1");
                for (int i : a1) {
                System.out.print(i + " ");
                }
                System.out.print("\n"); 
            
            mergeSort(a2, separator+1, right, print);
            System.out.println("Print a2");
                for (int i : a2) {
                System.out.print(i + " ");
                }
                System.out.print("\n"); 

            //setter sammen subarrays igjen
            int[] merge = new int[a1.length + a2.length];
            merge(a1, a2, merge);
        }   

        //if (print) {print(a);}
        return a;
    }



    public int[] merge (int[] a1, int[] a2, int[] merge) {
        //int n = (a1.length + a2.length)-1;
        int n = merge.length-1;
        int i = 0;  //første subarray
        int j = 0;  //andre subarray

        //om begge subarrays en mindre 
        while (i <= a1.length && j <= a2.length) {
            //elementet i merge settes til den minste verdien på posisjon i og j 
            if (a1[i] <= a2[j]) {
                System.out.println(merge[i+j] + " blir til " + a1[i]);
                merge[i+j] = a1[i];
                i++;
                System.out.println(merge[i+j] );
            } else {
                System.out.println(merge[i+j] + " blir til " + a2[j]);
                merge[i+j] = a2[j];
                System.out.println(merge[i+j]);
                j++;
            }
        }

        //om første subarray er mindre
        while (i <= a1.length) {
            merge[i+j] = a1[i];
            i++;
        }

        //om andre subarray er mindre
        while (j <= a2.length) {
            merge[i+j] = a2[j];
            j++;
        }

        return merge;
    }


    /*
    public int[] bSort(int[] a, boolean print) {
        int n = a.length;
        int indexA = 0;
        ArrayList<List<Integer>> buckets = new ArrayList<List<Integer>>(10);
        int maxValue = findMax(a);

        //oppretter en tom bucket for hvert siffer
        for (int i = 0; i <= maxValue; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        //alle tall i a plasseres i passende bucket og fjernes så fra a
        for (int i = 0; i < n; i++) {
            int key = a[i];
            buckets.get(key).add(key);
        }

        //fjerner alle tall fra buckets og plasseres på slutten av a
        for (int i = 0; i < 10; i++) {
            //for (int j = 0; j < n; j++) {
            while (!buckets.get(i).isEmpty()) {
                int x = buckets.get(i).remove(0);
                a[indexA++] = x;

                //if (print) {print(a);}
            }
        }

        return a;
    }
    */
}