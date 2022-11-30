//          1
//        /   \
//       2      3
//      /     /   \
//     4     5     6
//   / | \        / \
//  7  8  9     11   20

import java.util.ArrayList;

public class Task05H {
    public static void main(String[] args) {
        // Tree root = new Tree(1, new Tree(2, new Tree(4, new Tree(7), new Tree(8), new Tree(9)),null, null), null, new Tree(3, new Tree(5), null, new Tree(6, new Tree(11), null, new Tree(20))));

        Tree root = 
                new Tree(1, 
                    new Tree(2, 
                        new Tree(4, 
                            new Tree(7), 
                            new Tree(8), 
                            new Tree(9)),
                        null, 
                        null), 
                    null, 
                    new Tree(3, 
                        new Tree(5), 
                        null, 
                        new Tree(6, 
                            new Tree(11), 
                            null, 
                            new Tree(20))));

        System.out.println("Сумма значений веток дерева обходом в ширину: " + sumWide(root));
    }

    static class Tree {
        int value;
        Tree left;
        Tree middle;
        Tree right;

        public Tree(int value, Tree left, Tree middle, Tree right) {
            this.value = value;
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }
    }

    //Поиск суммы значений дерева обходом в ширину: 
    public static int sumWide(Tree root) {
        ArrayList<Tree> stack = new ArrayList<>();
        stack.add(root);

        int sum = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.remove(0);

            System.out.println(node.value);

            sum = sum + node.value;

            if (node.left != null) {
                stack.add(node.left);
            }
            
            if (node.middle != null) {
                stack.add(node.middle);
            }

            if (node.right != null) {
                stack.add(node.right);
            }    
        }
        return sum;
    }    
}
