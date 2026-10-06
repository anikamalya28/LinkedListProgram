// ============================================================
// DAY 1 STARTER CODE — Singly Linked List
// Name:
// Date:
// ============================================================

public class LinkedList {

    // ----- Node class (inner) -----
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Add a node to the front of the list
    public void addFirst(String data) {

        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
        //size++;
    }

    // Add a node to the end of the list
    public void addLast(String data) {
        //System.out.print("bob");
        Node x = head;
        if (x == null) {
            x = new Node(data);
            x.next = null;
            head = x;
            this.size++;
            return;
        }
        while (x.next != null) {
            x = x.next;
        }
        //System.out.print("bob");
        x.next = new Node(data);
        this.size++;
        return;

    }

    // Remove and return the first element
    public String removeFirst() {
        String a = head.data;
        head = head.next;
        return a;

    }

    // Return the number of elements
    public int size() {
        return size;
    }

    // Return true if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return a string representation: [a -> b -> c -> null]
    public String toString() {
        // TODO: implement
        String fin = "[";
        Node x = head;
        while (x != null) {
            fin += x.data;
            fin += " -> ";
            x = x.next;

        }
        fin += "null]";

        return fin;
    }

    // ============================================================
    // CHALLENGE 1A: Reverse the linked list in place
    // ============================================================
    public void reverse() {
        if (size > 1) {
            Node prev = null;
            Node cur = head;
            Node n = head.next;
            while (n != null) {
                Node y = cur.next;
                cur.next = prev;
                n = y.next;
                prev = cur;
                cur = y;
            }
            head = cur;
        }
    }

    // ============================================================
    // CHALLENGE 1B: Return true if the list reads the same
    //               forwards and backwards (palindrome check)
    // ============================================================
    public boolean isPalindrome() {
        // TODO: implement
        return false;
    }

    // ============================================================
// TESTS — run main() to check your implementation
// ============================================================
    public static void main(String[] args) {
        System.out.println("===== BASIC OPERATIONS =====");
        LinkedList list = new LinkedList();
        if (!(list.isEmpty())) {
            System.out.println("FAIL: new list should be empty");
        }
        if (!(list.size() == 0)) {
            System.out.println("FAIL: new list size should be 0");
        } else {
            System.out.println("PASS: isEmpty and size on empty list");
        }
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        if (!(list.size() == 3)) {
            System.out.println(list.size());
            System.out.println("FAIL: size should be 3");
        }
        if (!(list.toString().equals("[a -> b -> c -> null]"))) {
            System.out.println("FAIL: toString wrong after addLast. Got: "
                    + list.toString());
        } else {
            System.out.println("PASS: addLast and toString");
        }
        list.addFirst("z");
        if (!(list.toString().equals("[z -> a -> b -> c -> null]"))) {
            System.out.println("FAIL: toString wrong after addFirst. Got: " + list.toString());
        } else {
            System.out.println("PASS: addFirst");
        }
        String removed = list.removeFirst();
        if (!(removed.equals("z"))) {
            System.out.println("FAIL: removeFirst should return 'z', got: " + removed);
        }
        if (!(list.size() == 3)) {
            System.out.println("FAIL: size should be 3 after removeFirst");
        } else {
            System.out.println("PASS: removeFirst");
        }
        System.out.println("\n===== CHALLENGE 1A: REVERSE =====");
        LinkedList rev = new LinkedList();
        rev.addLast("1");
        rev.addLast("2");
        rev.addLast("3");
        rev.reverse();
        if (!(rev.toString().equals("[3 -> 2 -> 1 -> null]"))) {
            System.out.println("FAIL: reverse wrong. Got: " +
                    rev.toString());
        } else {
            System.out.println("PASS: reverse [1->2->3] => [3->2->1]");
        }
        LinkedList single = new LinkedList();
        single.addLast("x");
        single.reverse();
        if (!(single.toString().equals("[x -> null]"))) {
            System.out.println("FAIL: reverse of single element wrong");
        } else {
            System.out.println("PASS: reverse single element");
        }
        LinkedList empty = new LinkedList();
        empty.reverse();
        if (!(empty.isEmpty())) {
            System.out.println("FAIL: reverse of empty list should stay empty");
        } else {
            System.out.println("PASS: reverse empty list");
        }
        System.out.println("\n===== CHALLENGE 1B: PALINDROME =====");
        LinkedList pal1 = new LinkedList();
        for (char c : "racecar".toCharArray())
            pal1.addLast(String.valueOf(c));
        if (!(pal1.isPalindrome())) {
            System.out.println("FAIL: 'racecar' should be a palindrome");
        } else {
            System.out.println("PASS: 'racecar' is a palindrome");
        }
        LinkedList pal2 = new LinkedList();
        for (char c : "hello".toCharArray())
            pal2.addLast(String.valueOf(c));
        if (!(!pal2.isPalindrome())) {
            System.out.println("FAIL: 'hello' should NOT be a palindrome");
        } else {
            System.out.println("PASS: 'hello' is not a palindrome");
        }
        LinkedList pal3 = new LinkedList();
        for (char c : "a".toCharArray()) pal3.addLast(String.valueOf(c));
        if (!(pal3.isPalindrome())) {
            System.out.println("FAIL: single character should be a palindrome");
        } else {
            System.out.println("PASS: single character is a palindrome");
        }
        LinkedList pal4 = new LinkedList();
        for (char c : "abba".toCharArray())
            pal4.addLast(String.valueOf(c));
        if (!(pal4.isPalindrome())) {
            System.out.println("FAIL: 'abba' should be a palindrome");
        } else {
            System.out.println("PASS: 'abba' is a palindrome");
        }
        System.out.println("\nAll Day 1 tests passed!");
    }
}
