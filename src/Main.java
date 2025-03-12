import java.util.*;

/*
 * DSA Task:
 * Implement a Doubly Linked List (DLL)
 * Convert the DLL into an array
 * Sort the array using Heap Sort
 * Implement a DFS search method to find a value in the DLL
 */
public class Main {
    // this represents a node in doubly linked list
    static class Node {
        int value; // store the value of the node
        Node prev, next; // pointer to the prev and nex node
        // constructor to initialize a new node
        Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    // implement doubly linked list
    static class DoublyLinkedList {
        Node head; // reference the first node in the ddl
        // add method to add a new node 
        public void add(int value) {
            if(head == null) {
                head = new Node(value); // add a new node with the giving value
                return;
            }

            // traverse to the end of the list
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }

            // create a new node and link it
            Node newNode = new Node(value);
            current.next = newNode;
            newNode.prev = current;
        }

        // method to print the linked list in both ways forward and backward
        public void display(){
            // assign the value of the first node
            Node current = head;

            // display the forward traversal
            System.out.print("Forward: ");
            while(current != null) {
                // print the value of the node
                System.out.print(current.value + " ");
                // moving to the next node
                current = current.next;
            }           

            // separator
            System.out.println();

            // display the backward traversal
            System.out.print("Backward: ");
            printReverse(head);
        }

        // method to print the linked list in reversed manner
        private void printReverse(Node current){
            if(current == null){
                return;
            }
            printReverse(current.next);
            System.out.print(current.value + " ");
        }

        /* 
        * heapify operation to build a max heap
        * arr is the array representing the heap
        * n size of the heap
        * i index of the current element
        */ 
        private void heapify(int[] arr, int n, int i) {
            int largest = i; // initialize largest as root
            int left = 2 * i + 1; // left child
            int right = 2 * i + 2; // right child
    
            // if left child is larger than root
            if(left < n && arr[left] > arr[largest]) {
                // largest now equals the left
                largest = left;
            }
            // if right child is larger than largest so far
            if(right < n && arr[right] > arr[largest]) {
                // largest now equals the right
                largest = right;
            }
            // if largest is not root we swap variables
            if(largest != i) {
                int tmp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = tmp;
    
                // recursively heapify again
                heapify(arr, n, right);
            }
        }
    
        /*
         * sort is basically a Heap Sort Algorithm
         * arr is the array that going to be sorted
         */
        private void sort(int[] arr) {
            int n = arr.length;

            // build the max heap
            for(int i = n / 2 - 1; i >= 0; i--){
                heapify(arr, n, i);
            }
    
            // extract the elements from the heap
            for(int i = n - 1; i > 0; i--){
                // swap max value with last element
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = tmp;
    
                // heapify the reduced heap
                heapify(arr, i, 0);
            }
        }

        // convert the linked list into an array on ints
        // dll is the linked list need to be converted
        public int[] convertToArray(DoublyLinkedList dll) {
            List<Integer> myArr = new ArrayList<>();
            Node current = dll.head;

            // traverse and store elements in list
            while(current != null) {
                myArr.add(current.value);
                current = current.next;
            }

            // converting linkedlist into an array
            int[] arr = new int[myArr.size()];
            for(int i = 0; i < myArr.size(); i++){
                arr[i] = myArr.get(i);
            }

            return arr;
        }

        // search method (search for a target using DFS)
        public int search(int target) {
            if (head == null) return -1;

            Stack<Node> stack = new Stack<>();
            Map<Node, Integer> indexMap = new HashMap<>();

            stack.push(head);  // start DFS from the head node
            indexMap.put(head, 0);

            System.out.print("DFS Traversal: ");
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                int index = indexMap.get(node);
                System.out.print(node.value + " ");

                // if the node is the target then return true
                if (node.value == target) {
                    System.out.println("\nFound at position: " + index);
                    return index;
                }

                // push next node (right direction) and update index
                if (node.next != null && !indexMap.containsKey(node.next)) {
                    stack.push(node.next);
                    indexMap.put(node.next, index + 1);
                }

                // push previous node (left direction) and update index
                if (node.prev != null && !indexMap.containsKey(node.prev)) {
                    stack.push(node.prev);
                    indexMap.put(node.prev, index - 1);
                }
            }

            System.out.println("Not Found.");
            return -1;
        }
    }

    public static void main(String args[]){
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(5);
        dll.add(2);
        dll.add(8);
        dll.add(1);

        dll.display();

        // convert doubly linked list to array
        int[] arr = dll.convertToArray(dll);

        // unsorted array
        System.out.println("\n" + "unsorted array: "+ Arrays.toString(arr));

        // sorting the array using heap sort
        dll.sort(arr);
        
        // sorted result
        System.out.println("\n" + "sorted array using heapsort: " + Arrays.toString(arr));

        // search for a target and retrieve the index
        dll.search(8);
    }
}

/*
 * study materials
 * my notes
 * https://www.youtube.com/watch?v=AK2sVIo2yfs
 * https://www.youtube.com/watch?v=ajdwLAMuvyE
 * https://youtu.be/N6dOwBde7-M?si=b-JU2rY6Z8CJvZGm
 * https://stackoverflow.com/questions/2304242/how-to-convert-linkedlist-to-array-using-toarray
 * https://www.geeksforgeeks.org/heap-sort/
 * https://www.youtube.com/watch?v=pcKY4hjDrxk
 * https://www.youtube.com/watch?v=PMMc4VsIacU&t=940s
 * https://youtu.be/-VgHk7UMPP4?si=GhcUBqie2Q3kZdmI
 * https://youtu.be/vyxjpTUnguc?si=nOnxXhaoamFg4NIT
 * https://youtu.be/AE5I0xACpZs?si=vc2lmAknEEHMOC70
 * https://youtu.be/uL0JwpGNiZE?si=IqWwuvRNMGC5nsR5
 * https://www.softwaretestinghelp.com/doubly-linked-list-in-java/
 * https://youtu.be/REOsj0nYWKE?si=8i7XXCmnIxHzXBgG
 * https://youtu.be/liLXlJehNs8?si=SA6-PdRcKq1B1Vv9
 * https://youtu.be/VOpjAHCee7c?si=bFBUD4FaAPau-tGZ
 * https://youtu.be/Cii93E1cZjw?si=UI12SXG-Dq5PLdwa
 * https://www.baeldung.com/java-depth-first-search
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 * https://www.baeldung.com/java-depth-first-search
 * some code was already in my notes + written before
 */