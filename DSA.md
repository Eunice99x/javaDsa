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
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
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
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
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
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++) L[i] = arr[left + i];
    for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }

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
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
```

### Heap Sort
Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. It divides the input into a sorted and an unsorted region, and iteratively shrinks the unsorted region by extracting the largest element.

**Time Complexity:** O(n log n)
**Space Complexity:** O(1)

```java
public void heapSort(int[] arr) {
    int n = arr.length;
    
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
    
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
}

private void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest])
        largest = left;
    
    if (right < n && arr[right] > arr[largest])
        largest = right;
    
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
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
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

## Data Structures

### Singly Linked List
A singly linked list is a data structure consisting of nodes where each node contains data and a reference to the next node in the sequence.

```java
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = new Node(data);
    }

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
    
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        
        Node current = head;
        while (current.next != null)
            current = current.next;
            
        Node newNode = new Node(data);
        current.next = newNode;
        newNode.prev = current;
    }

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

public void bfs(Map<Integer, List<Integer>> graph, int start) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    
    queue.add(start);
    visited.add(start);

    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");
        
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                queue.add(neighbor);
                visited.add(neighbor);
            }
        }
    }
}
```

### Depth-First Search (DFS)
DFS is an algorithm for traversing or searching tree or graph data structures. It starts at a chosen node and explores as far as possible along each branch before backtracking.

```java
import java.util.*;

public void dfs(Map<Integer, List<Integer>> graph, int start) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> visited = new HashSet<>();
    
    stack.push(start);

    while (!stack.isEmpty()) {
        int node = stack.pop();
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);
            
            for (int neighbor : graph.get(node)) {
                stack.push(neighbor);
            }
        }
    }
}
```

## Contributing
Feel free to contribute to this repository by submitting pull requests or creating issues for bugs and feature requests.

## License
This project is licensed under the MIT License - see the LICENSE file for details.