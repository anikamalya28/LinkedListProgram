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
        if (size <= 1) {return;}
        if (size > 1) {
            Node prev = null;
            Node cur = head;
            Node n = head.next;
            while (cur != null) {
                n = cur.next;
                cur.next = prev;
                prev = cur;
                cur = n;
            }
            head = prev;
        }
    }

    // ============================================================
    // CHALLENGE 1B: Return true if the list reads the same
    //               forwards and backwards (palindrome check)
    // ============================================================
    public boolean isPalindrome() {
        if (size <= 1) {return true;}
        String now = this.toString();
        this.reverse();
        String reversed = this.toString();
        this.reverse();
        return now.equals(reversed);
    }

    // ============================================================
    // CHALLENGE 2A: Return true if the list contains a cycle.
    // Use Floyd's Tortoise and Hare algorithm (two pointers).
    // ============================================================
    public boolean hasCycle() {
        // TODO: implement
        Node t = head;
        Node h = head;
        while (t != h) {
            //
        }
        return false;
    }

    // ============================================================
    // CHALLENGE 2B: Return the data stored in the MIDDLE node.
    // If the list has an even number of nodes, return the
    // second of the two middle nodes.
    // Do this in ONE pass without knowing the size in advance.
    // Use two pointers: one moves 1 step, one moves 2 steps.
    // ============================================================
    public String findMiddle() {
        // TODO: implement
        return null;
    }

    // ============================================================
    // CHALLENGE 2C (BONUS): If a cycle exists, return the node
    // data where the cycle begins. Return null if no cycle.
    // ============================================================
    public String findCycleStart() {
        // TODO: implement
        return null;
    }

    // Helper: creates a cycle for testing purposes only
    // (connects the last node back to the node at cycleIndex)
    public void createCycleForTesting(int cycleIndex) {
        if (head == null) return;
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        Node cycleNode = head;
        for (int i = 0; i < cycleIndex; i++) cycleNode = cycleNode.next;
        tail.next = cycleNode;
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
        System.out.println("===== CHALLENGE 2A: CYCLE DETECTION =====");

        LinkedList noCycle = new LinkedList();
        noCycle.addLast("a"); noCycle.addLast("b"); noCycle.addLast("c");
        if (!(!noCycle.hasCycle())) {
            System.out.println("FAIL: list with no cycle should return false");
        } else {
            System.out.println("PASS: no cycle detected in normal list");
        }

        LinkedList withCycle = new LinkedList();
        withCycle.addLast("a"); withCycle.addLast("b");
        withCycle.addLast("c"); withCycle.addLast("d");
        withCycle.createCycleForTesting(1); // tail -> node at index 1 ("b")
        if (!(withCycle.hasCycle())) {
            System.out.println("FAIL: list with cycle should return true");
        } else {
            System.out.println("PASS: cycle detected");
        }

        LinkedList emptyList = new LinkedList();
        if (!(!emptyList.hasCycle())) {
            System.out.println("FAIL: empty list should return false");
        } else {
            System.out.println("PASS: no cycle in empty list");
        }

        System.out.println("\n===== CHALLENGE 2B: FIND MIDDLE =====");

        LinkedList odd = new LinkedList();
        odd.addLast("a"); odd.addLast("b"); odd.addLast("c");
        odd.addLast("d"); odd.addLast("e");
        if (!("c".equals(odd.findMiddle()))) {
            System.out.println("FAIL: middle of 5-node list should be 'c', got: " + odd.findMiddle());
        } else {
            System.out.println("PASS: middle of [a,b,c,d,e] is 'c'");
        }

        LinkedList even = new LinkedList();
        even.addLast("a"); even.addLast("b"); even.addLast("c"); even.addLast("d");
        if (!("c".equals(even.findMiddle()))) {
            System.out.println("FAIL: middle of 4-node list should be 'c' (second middle), got: " + even.findMiddle());
        } else {
            System.out.println("PASS: middle of [a,b,c,d] is 'c' (second middle)");
        }

        LinkedList one = new LinkedList();
        one.addLast("x");
        if (!("x".equals(one.findMiddle()))) {
            System.out.println("FAIL: middle of single-node list should be 'x'");
        } else {
            System.out.println("PASS: middle of single-node list is 'x'");
        }

        System.out.println("\n===== CHALLENGE 2C (BONUS): FIND CYCLE START =====");

        LinkedList cs = new LinkedList();
        cs.addLast("0"); cs.addLast("1"); cs.addLast("2");
        cs.addLast("3"); cs.addLast("4");
        cs.createCycleForTesting(2); // cycle starts at index 2 ("2")
        if (!("2".equals(cs.findCycleStart()))) {
            System.out.println("FAIL: cycle start should be '2', got: " + cs.findCycleStart());
        } else {
            System.out.println("PASS: cycle start correctly identified as '2'");
        }

        LinkedList ncs = new LinkedList();
        ncs.addLast("a"); ncs.addLast("b");
        if (!(ncs.findCycleStart() == null)) {
            System.out.println("FAIL: no cycle, should return null");
        } else {
            System.out.println("PASS: no cycle start returns null");
        }

        System.out.println("\nAll Day 2 tests passed!");

    }
}
