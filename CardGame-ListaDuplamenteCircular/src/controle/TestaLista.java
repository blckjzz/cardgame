package controle;

import java.util.Scanner;

import dominio.ListaDuplamenteCircular;

public class TestaLista {

public static void main(String[] args){            
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        ListaDuplamenteCircular  list = new ListaDuplamenteCircular();   
        System.out.println("Circular Doubly Linked List Test\n");          
        char ch;
        boolean keep = true;
		/*  Perform list operations  */
        do    
        {
            System.out.println("\nCircular Doubly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            System.out.println("7. Sair");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.next() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.next() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                Object num = scan.next() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos < 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;     
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;            
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;     
            case 7 : 
               keep = false; 
                break; 
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
                            
        } while (keep);               
    }
}
