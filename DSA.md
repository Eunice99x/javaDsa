# Data Structures and Algorithms in Java

A comprehensive guide to common data structures and algorithms implemented in Java, including sorting algorithms, searching techniques, linked lists, and graph traversal methods.

## Table of Contents
- [Sorting Algorithms](#sorting-algorithms)
  - [Bubble Sort](#bubble-sort)
  - [Insertion Sort](#insertion-sort)
  - [Merge Sort](#merge-sort)
  - [Quick Sort](#quick-sort)
  - [Heap Sort](#heap-sort)
- [Searching Algorithms](#searching-algorithms)
  - [Binary Search](#binary-search)
- [Data Structures](#data-structures)
  - [Singly Linked List](#singly-linked-list)
  - [Doubly Linked List](#doubly-linked-list)
- [Graph Algorithms](#graph-algorithms)
  - [Breadth-First Search (BFS)](#breadth-first-search-bfs)
  - [Depth-First Search (DFS)](#depth-first-search-dfs)

## Sorting Algorithms

### Bubble Sort
Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed.

**Time Complexity:** O(n²)
**Space Complexity:** O(1)

```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) { // Outer loop for passes
        for (int j = 0; j < n - i - 1; j++) { // Inner loop for comparisons
            if (arr[j] > arr[j + 1]) { // Swap if elements are in wrong order
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

### Insertion Sort
Insertion Sort builds the final sorted array one item at a time. It's much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

**Time Complexity:** O(n²)
**Space Complexity:** O(1)

```java
public void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) { // Start from the second element
        int key = arr[i]; // Element to be inserted
        int j = i - 1;
        // Shift elements greater than key to the right
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key; // Insert key in the correct position
    }
}
```

### Merge Sort
Merge Sort is an efficient, stable sorting algorithm that uses a divide-and-conquer strategy. It divides the input array into two halves, recursively sorts them, and then merges the sorted halves.

**Time Complexity:** O(n log n)
**Space Complexity:** O(n)

```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2; // Find the middle point
        mergeSort(arr, left, mid); // Sort the left half
        mergeSort(arr, mid + 1, right); // Sort the right half
        merge(arr, left, mid, right); // Merge the sorted halves
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1]; // Temporary arrays for left and right halves
    int[] R = new int[n2];

    // Copy data to temporary arrays
    for (int i = 0; i < n1; i++) L[i] = arr[left + i];
    for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

    // Merge the temporary arrays
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }

    // Copy remaining elements of L[] and R[]
    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}
```

### Quick Sort
Quick Sort is an efficient, in-place sorting algorithm that uses a divide-and-conquer strategy. It works by selecting a 'pivot' element and partitioning the array around it.

**Time Complexity:** 
- Average: O(n log n)
- Worst: O(n²)
**Space Complexity:** O(log n)

```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high); // Partition the array
        quickSort(arr, low, pi - 1); // Sort the left subarray
        quickSort(arr, pi + 1, high); // Sort the right subarray
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high]; // Choose the last element as the pivot
    int i = low - 1; // Index of smaller element
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) { // If current element is smaller than the pivot
            i++;
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    // Swap arr[i+1] and arr[high] (pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1; // Return the partition index
}
```

### Heap Sort
Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. It divides the input into a sorted and an unsorted region, and iteratively shrinks the unsorted region by extracting the largest element.

**Time Complexity:** O(n log n)
**Space Complexity:** O(1)

```java
public void heapSort(int[] arr) {
    int n = arr.length;
    // Build a max heap
    for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
    // Extract elements from the heap one by one
    for (int i = n - 1; i > 0; i--) {
        // Move the current root to the end
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        // Heapify the reduced heap
        heapify(arr, i, 0);
    }
}

private void heapify(int[] arr, int n, int i) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // Left child
    int right = 2 * i + 2; // Right child
    // If left child is larger than root
    if (left < n && arr[left] > arr[largest]) largest = left;
    // If right child is larger than largest so far
    if (right < n && arr[right] > arr[largest]) largest = right;
    // If largest is not root
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
}
```

## Searching Algorithms

### Binary Search
Binary Search is an efficient algorithm for searching a sorted array by repeatedly dividing the search interval in half.

**Time Complexity:** O(log n)
**Space Complexity:** O(1)

```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; // Avoids overflow
        if (arr[mid] == target) return mid; // Target found
        else if (arr[mid] < target) left = mid + 1; // Search the right half
        else right = mid - 1; // Search the left half
    }
    return -1; // Target not found
}
```

## Data Structures

### Singly Linked List
A singly linked list is a data structure consisting of nodes where each node contains data and a reference to the next node in the sequence.

```java
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; this.next = null; }
}

class LinkedList {
    Node head;
    // Add a node at the end
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = new Node(data);
    }
    // Print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

### Doubly Linked List
A doubly linked list is similar to a singly linked list, but each node has references to both the next and previous nodes.

```java
class Node {
    int data;
    Node prev, next;
    Node(int data) { this.data = data; this.prev = this.next = null; }
}

class DoublyLinkedList {
    Node head;
    // Add a node at the end
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        Node newNode = new Node(data);
        current.next = newNode;
        newNode.prev = current;
    }
    // Print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

## Graph Algorithms

### Breadth-First Search (BFS)
BFS is an algorithm for traversing or searching tree or graph data structures. It starts at a chosen node and explores all neighbors at the present depth before moving on to nodes at the next depth level.

```java
import java.util.*;

// Method to perform Breadth-First Search (BFS) on a graph
public void bfs(Map<Integer, List<Integer>> graph, int start) {
    // Queue to keep track of nodes to visit (FIFO structure)
    Queue<Integer> queue = new LinkedList<>();

    // Set to keep track of visited nodes and avoid reprocessing them
    Set<Integer> visited = new HashSet<>();
    
    // Start BFS from the given starting node
    queue.add(start);  // Enqueue the start node
    visited.add(start); // Mark the start node as visited

    // Continue processing until there are no more nodes to visit
    while (!queue.isEmpty()) {
        int node = queue.poll(); // Dequeue a node from the front of the queue
        System.out.print(node + " "); // Process (print) the node
        
        // Iterate through all its neighbors (adjacent nodes)
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) { // If neighbor is not visited
                queue.add(neighbor); // Enqueue the neighbor
                visited.add(neighbor); // Mark it as visited
            }
        }
    }
}

```

### Depth-First Search (DFS)
DFS is an algorithm for traversing or searching tree or graph data structures. It starts at a chosen node and explores as far as possible along each branch before backtracking.

```java
import java.util.*;

// Method to perform Depth-First Search (DFS) on a graph
public void dfs(Map<Integer, List<Integer>> graph, int start) {
    // Stack to keep track of nodes to visit (LIFO structure)
    Stack<Integer> stack = new Stack<>();

    // Set to track visited nodes and avoid revisiting them
    Set<Integer> visited = new HashSet<>();

    // Start DFS from the given starting node
    stack.push(start); // Push the start node onto the stack

    // Continue processing while there are nodes in the stack
    while (!stack.isEmpty()) {
        int node = stack.pop(); // Pop the top node from the stack

        // If the node has not been visited yet, process it
        if (!visited.contains(node)) {
            System.out.print(node + " "); // Print (process) the node
            visited.add(node); // Mark the node as visited

            // Push all unvisited neighbors onto the stack
            // We push neighbors in the order they appear, meaning deeper nodes are visited first
            for (int neighbor : graph.get(node)) {
                stack.push(neighbor);
            }
        }
    }
}
```
