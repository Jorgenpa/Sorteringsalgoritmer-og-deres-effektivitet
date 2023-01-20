import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class SortingAlgorithms {

    public int[] selectionSort(int[] a, boolean print) {

        //finner minste verdi ved å gå gjennom hvert element i arrayet 
        for (int index = 0; index < a.length; index++) {
            //print for hver iterasjon
            if (print) {print(a);}

            int min = index;
            for (int j = index+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            //bytter plass mellom min og første element
            int temp = a[min];
            a[min] = a[index];
            a[index] = temp;
        }

        if (print) {System.out.println("");}
        return a;
    }



    public int[] insertionSort(int[] a, boolean print) {

        //sorterer hele listen før man finner minste element
        for (int index = 1; index < a.length; index++) {
            //print for hver iterasjon
            if (print) {print(a);}

            //x settes til elementet på plass index, j gir posisjonen i arrayet
            int x = a[index];
            int j = index;

            //om elementet er mindre enn elementet på plassen foran i arrayet (og ikke første element)
            while (j > 0 && x < a[j-1]) {
                a[j] = a[j-1]; //flytter cellen opp
                j--; //endrer telleren
            }

            a[j] = x; //elementet på plass j settes til x
        }

        if (print) {print(a); System.out.println("");}
        return a;
    } 



    public int[] heapSort(int[] a, boolean print) { 
        int stopIndex = a.length;
        if (print) {System.out.println("Bygger maxheap: ");}

        //oppretter et max-heap. Begynner midt i arrayet fordi nodene etter dette er løvnoder
        for (int i = a.length/2; i >= 0; i--) {
            downHeap(a, i, stopIndex, print);
        }

        if (print) {System.out.println("\nSorterter maxheap: ");}
        if (print) {print(a);}


        //bytter plass på siste og første(max-noden) element i arrayet, og downheaper
        for (int i = a.length-1; i >= 0; i--) {
            //arbeidsområdet må minske med 1 hver iterasjon så ikke man havner i evig loop
            stopIndex--;

            int siste = a[i];
            a[i] = a[0];
            a[0] = siste;

            downHeap(a, 0, stopIndex, print);

            //if (print) {print(a);}
        }

        if (print) {System.out.println("\n");}
        return a;
    }

     

    public void downHeap(int[] a, int i, int stopIndex, boolean print) {
        if (print) {print(a);}

        int leftChildIndex = (i*2) + 1;
        int rightChildIndex = (i*2) + 2;
        int biggestChildIndex = 0;

        //sjekker om noden er en løvnode
        if (i >= (stopIndex / 2) && i <= stopIndex) {
            return;
        }

        //sjekker om ingen av barna er større enn noden selv
        if (rightChildIndex >= stopIndex) {
            if (a[leftChildIndex] < a[i]) {
                //System.out.println(a[i] + " er storre enn sitt barn");
                return;
            }
        }
        else if (a[leftChildIndex] < a[i] && a[rightChildIndex] < a[i]) {
            //System.out.println(a[i] + " er storre enn begge sine barn");
            return;
        }

        //finner største barn
        if (rightChildIndex >= stopIndex) {
            biggestChildIndex = leftChildIndex;
        }
        else if (a[leftChildIndex] > a[rightChildIndex]) {
            biggestChildIndex = leftChildIndex;
        } 
        else {
            biggestChildIndex = rightChildIndex;
        }

        //bytter plass på nåværende node og største barn
        int temp = a[i];
        a[i] = a[biggestChildIndex];
        a[biggestChildIndex] = temp;

        //rekursjonskall på det største barnet
        downHeap(a, biggestChildIndex, stopIndex, print);
    }



    //siste element er pivot
    public int[] quickSort(int[] a, int start, int slutt, boolean print) {

        while (start < slutt) {
            int left = partition(a, start, slutt, print);

            //første del er minst
            if (left-start < slutt-left) {
                quickSort(a, start, left-1, print);
                start = left + 1;
            } 
            //andre del er minst
            else {
                quickSort(a, left + 1, slutt, print);
                slutt = left - 1;
            }
            
        }

        if (print) {print(a);}
        return a;
    }

    public int partition(int[] a, int start, int slutt, boolean print) {
        
        //pivot som siste element
        int pivot = a[slutt];
        int left = start; //left(gås gjennom riktig vei) rekursjon på venstre side
        int right = slutt; //right(gås gjennom motsatt vei) rekursjon på høyre side

        
        //finner et element større enn pivot
        while (left <= right) {
            //elementet på plass left er ikke større, øker left teller
            while (left < right && a[left] <= pivot) {
                left += 1;

            }
            //elementet på plass right er større/lik, minsker right teller
            while (left <= right && pivot <= a[right]) {
                right -= 1;

            }
            //bytter plass på elementene på posisjon left og right 
            if (left < right) {
                //String str = "Bytter verdi " + a[left] + ", " + a[right]; 
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                //str += " til " + a[left] + ", " + a[right];
                //System.out.println(str);
            }
        }

        //elementet på posisjon pivot plasseres på posisjon left
        int change = a[left];
        a[left] = a[slutt];
        a[slutt] = change;

        if (print) {print(a);}
        return left;
    }



    //midterste element er pivot
    public int[] quickSort2(int[] a, int start, int slutt, boolean print) {
        if (print) {print(a);}

        while (start < slutt) {
            int median = medianOf3(a, start, slutt, print); //pivot som midterste element
            int index = partition2(a, start, slutt, median, print);

            if (index - start < slutt - index) {
                quickSort2(a, start, index-1, print);
                start = index + 1;
            }
            else {
                quickSort2(a, index + 1, slutt, print);
                slutt = index-1;
            }
        }

        return a;
    }
    
    public int partition2(int[] a, int start, int slutt, int pivot, boolean print) {
        int left = start; //left(gås gjennom riktig vei) rekursjon på venstre side
        int right = slutt-1; //right(gås gjennom motsatt vei) rekursjon på høyre side

        while (left <= right) { 
            while (left <= right && a[left] <= pivot) { 
                left = left + 1;
            }
            while (right >= left && a[right] >= pivot) { 
                right = right - 1;
            }
            if (left < right) {
                //swap(a, left,right);
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        swap(a, left, slutt);
        /*int temp = a[left];
        a[left] = a[slutt]; 
        a[slutt] = temp;*/

        //if (print) {print(a);}
        return left;
    }

    public int medianOf3(int[] a, int start, int slutt, boolean print) {
        int middle = (start+slutt)/2;

        if (a[start] > a[middle]) {
            swap(a, start, middle);
        }
        if (a[start] > a[slutt]) {
            swap(a, start, slutt);
        }
        if (a[middle] > a[slutt]) {
            swap(a, middle, slutt);
        }

        swap(a, middle, slutt);

        if (print) {print(a);}
        //if (print) {System.out.println("Pivot: " + a[slutt]);}
        return a[slutt];
    }



    public void swap (int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }



    public int[] mergeSort(int[] a, boolean print) {
        if (print) {print(a);}

        int n = a.length;
        if (n == 1) {
            return null;
        }

        //kaller mergeSort() på første halvdel og andre halvdel av (sub)arrayet
        int separator = n/2;
        int[] a1 = new int[separator];
        int[] a2 = new int[n-separator];

        for (int i = 0; i < a1.length; i++) {
            //System.out.println(a1[i] + " blir til " + a[i]);
            a1[i] = a[i];
        }
        for (int i = 0; i < a2.length; i++) {
            //System.out.println(a2[i] + " blir til " + a[n/2+i]);
            a2[i] = a[n/2+i];
        }

        mergeSort(a1, print);
        mergeSort(a2, print);

        //setter sammen subarrays igjen
        merge(a, a1, a2, separator, n-separator, print);
        return a;
    }


    public int[] merge(int[] merge, int[] a1, int[] a2, int left, int right, boolean print) {
        int i = 0;
        int j = 0;
        int k = 0;

        //om begge subarrays en mindre 
        while (i < left && j < right) {
            //elementet i merge-arrayet settes til den minste verdien på posisjon i og j 
            if (a1[i] <= a2[j]) {
                merge[k++] = a1[i++];
            }
            else {
                merge[k++] = a2[j++];
            }
        }

        //om første subarray er mindre
        while (i < left) {
            merge[k++] = a1[i++];
        }

        //om andre subarray er mindre
        while (j < right) {
            merge[k++] = a2[j++];
        }

        if (print) {print(merge);}

        return merge;
    }



    public int[] bucketSort(int[] a, boolean print) {
        if (print) {print(a);}
        int max = findMax(a);
        int[] bucket = new int[max+1];
 
        //oppretter en tom bucket for hvert siffer
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
 
        //alle tall i a plasseres i passende bucket
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
 
        //fjerner alle tall fra buckets og plasseres på slutten av a
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++]=i;
            }
        }

        if (print) {print(a);}
        return a;
    }

    public int findMax(int[] a) {
        //finner største verdi i arrayet
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(a[i], max);
        }

        return max;
    }



    public int[] radixSort(int[] a, boolean print) {
        if (print) {print(a);}

        int n = a.length/*-1*/;
        int max = findMax(a);

        //counter for hvert siffer. Eksponentiell 
        for (int exp = 1; max/exp > 0; exp *= 10) {            
            countRadix(a, n, exp, print);
        }
        
        if (print) {print(a);}
        return a;

    }

    public void countRadix(int[] a, int n, int exp, boolean print) {
        int output[] = new int[n];
        int count[] = new int[10];

        //fyller arrayet med 0-verdier
        Arrays.fill(count, 0);

        //forekomster med samme siffer på plass havner i samme count[] bøtte
        for (int i = 0; i < n; i++) {
            int x = (a[i]/exp)%10;
            count[x]++; 
        } 

        //elementet på plass count[i] settes til riktig plass i output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        //bygger output[]
        for (int i = n-1; i >= 0; i--) {
            int x = (a[i]/exp)%10;
            output[count[x] - 1] = a[i];
            count[x]--;
        }

        //kopierer output[] til a[]
        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }

    }



    //Oppretter tilfeldige, sorterte og reverserte versjoner av arrayet
    public int[] generateArray(int[] a, String type, boolean valueLimit) { 

        //Tilfeldig rekkefølge 
        if (type == "random") {
            if (valueLimit == false) {
                for (int i = 0; i < a.length; i++) {
                Random ran = new Random();
                a[i] = ran.nextInt();
                }
            } else {
                for (int i = 0; i < a.length; i++) {
                Random ran = new Random();
                a[i] = ran.nextInt(100); //nextInt(100) gir et tall mellom 0-99
                }
            }
            
        }

        //Stigende rekkefølge
        else if (type == "ascending") {
            if (valueLimit == false) {
                for (int i = 0; i < a.length; i++) {
                    a[i] = i;
                }
            } else {
                for (int i = 0; i < a.length; i++) {
                    Random ran = new Random();
                    a[i] = ran.nextInt(100);
                }
                Arrays.sort(a);
            }
        }

        //Fallende rekkefølge
        else if (type == "descending") {
            if (valueLimit == false) {
                int top = a.length-1;
                for (int i = 0; i < a.length; i++) {
                    a[i] = top - i;
                }
            } else {
                for (int i = 0; i < a.length; i++) {
                    Random ran = new Random();
                    a[i] = ran.nextInt(100);
                }
                //sorteres in-place i motsatt rekkefølge
                Arrays.sort(a);
                if (a != null && a.length >= 2) {
                    for (int i = 0; i < a.length / 2; i++) {
                        int temp = a[i];
                        a[i] = a[a.length - 1 - i];
                        a[a.length - 1 - i] = temp;
                    }
                }
            }

        }

        return a;
    }



    public void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.print("\n"); 
    }

}