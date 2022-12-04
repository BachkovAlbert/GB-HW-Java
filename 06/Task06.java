
public class Task06 {

    public static void main(String[] args) {
        Tree root = 
                new Tree(1, 
                    new Tree(2, 
                        new Tree(4, 
                            new Tree(7), 
                            new Tree(9)), 
                        null), 
                    new Tree(3, 
                        new Tree(5), 
                        new Tree(6, 
                            new Tree(11), 
                            new Tree(20))));
        
    printPreOrder(root); 
        System.out.print(" - Pre-order, NLR\n");
    printPostOrder(root); 
        System.out.print(" - Post-order, LRN\n");
    printInOrder(root); 
        System.out.print(" - In-order, LNR\n");    
    printReversePreOrder(root); 
        System.out.print(" - Reverse pre-order, NR\n");
    printReversePostOrder(root); 
        System.out.print(" - Reverse post-order, RLN\n");     
    printReverseInOrder(root); 
        System.out.print(" - Reverse in-order, RNL\n");       
    
    printVisual(root, ""); 
        System.out.print(" - point 2 in HW\n");   
    }
    
    static void printPreOrder(Tree root){
        if (root != null){
            System.out.print(root.value + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
            }
    }

    static void printPostOrder(Tree root){
        if (root != null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    static void printInOrder(Tree root){
        if (root != null){
            printInOrder(root.left);
            System.out.print(root.value + " ");
            printInOrder(root.right);
        }
    }

    static void printReversePreOrder(Tree root){
        if (root != null){
            System.out.print(root.value + " ");
            printReversePreOrder(root.right);
            printReversePreOrder(root.left);
        }
    }

    static void printReversePostOrder(Tree root){
        if (root != null){
            printReversePostOrder(root.right);
            printReversePostOrder(root.left);
            System.out.print(root.value + " ");
        }
    }

    static void printReverseInOrder(Tree root){
        if (root != null){
            printReverseInOrder(root.right);
            System.out.print(root.value + " ");
            printReverseInOrder(root.left);
        }
    }

    public static void printVisual(Tree root, String sp) {

        if (root != null){
            System.out.print(sp + root.value);
            printVisual(root.left, "("); 
            printVisual(root.right,  ",");

            if (root.left != null && root.right == null){
                System.out.print(",nil)");              
            }
            if (root.left == null && root.right == null){
                System.out.print("");
            }
            if (root.left == null && root.right != null){
                System.out.print("nil");              
            }
            if (root.left != null && root.right != null){
                System.out.print(")");        
            }               
        }
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }
    }
}
