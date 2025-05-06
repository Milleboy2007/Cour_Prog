package exam.question2;

// Classe de la liste doublement chaînée
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    // Ajouter à la fin
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Ajouter au début
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

   

    // Affichage de la liste (vers l'avant)
    public void printForward() {
        Node current = head;
        System.out.print("Liste → ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Affichage de la liste (vers l'arrière)
    public void printBackward() {
        Node current = tail;
        System.out.print("Liste (revers) ← ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Obtenir la taille
    public int size() {
        return size;
    }

    public Node getElementFromStart(int index){
        if(index < 0 || index > this.size){
            System.out.println("Erreur");
            return null;
        }
        Node cur = this.head;
        for(int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        return cur;
    }

    //Remplisser cette méthode
    public void addBefore(Node nouveau, Node vieux){
        if (vieux.prev != null) {
            vieux.prev.next = nouveau;
            nouveau.prev = vieux.prev;
            nouveau.next = vieux;
            vieux.prev = nouveau;
        }else{
            head = nouveau;
            vieux.prev = nouveau;
            nouveau.next = vieux;
        }

        size++;
    }

   
    // Test de la liste
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.printForward();    // Liste → 5 10 20
        list.printBackward();   // Liste (revers) ← 20 10 5

        list.addBefore(new Node(88),list.getElementFromStart(1));
        list.printForward();    // Liste → 5 88 10 20
        list.printBackward();   // Liste (revers) ← 20 10 88 5


        list.addBefore(new Node(8),list.getElementFromStart(0));
        list.printForward();    // Liste → 8 5 88 10 20
        list.printBackward();    // Liste (revers) ← 20 10 88 5 8



        System.out.println("Taille: " + list.size()); // Taille: 5
    }
}

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
