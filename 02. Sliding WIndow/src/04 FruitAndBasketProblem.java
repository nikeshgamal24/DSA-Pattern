//Fruit Into Baskets
//You are visiting a farm that has a single row of fruit trees arranged from left to right.
// The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

//You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

    //You only have two baskets, and each basket can only hold a single type of fruit.
    // There is no limit on the amount of fruit each basket can hold.
    //Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
    // while moving to the right. The picked fruits must fit in one of your baskets.
    //Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
    //Given the integer array fruits, return the maximum number of fruits you can pick.

//Example 1:
//Input: fruits = [1,2,1]
//Output: 3
//Explanation: We can pick from all 3 trees.

//Example 2:
//Input: fruits = [0,1,2,2]
//Output: 3
//Explanation: We can pick from trees [1,2,2].

//If we had started at the first tree, we would only pick from trees [0,1].

//Example 3:
//Input: fruits = [1,2,3,2,2]
//Output: 4
//Explanation: We can pick from trees [2,3,2,2].

//If we had started at the first tree, we would only pick from trees [1,2].


import java.util.HashMap;

class FruitAndBasketProblem {
    public static void main(String [] args){
        int [] fruits1 = {1,2,1};
        int [] fruits2 = {0,1,2,2};
        int [] fruits3  = {1,2,3,2,2};
        System.out.println("Output 1: "+ fruitAndBasketProblem(fruits1));
        System.out.println("Output 2: "+ fruitAndBasketProblem(fruits2));
        System.out.println("Output 3: "+ fruitAndBasketProblem(fruits3));

    }

    public static int fruitAndBasketProblem(int [] fruits){
        //declare necessary variable
        int low = 0;
        int high;
        int res = Integer.MIN_VALUE;
        int noOfBasket = 2;
        // HashMap
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (high = 0; high < fruits.length; high++) {
            // get the elements and keep count on hash map
            // [1,2,1]
            frequencyMap.put(fruits[high],frequencyMap.getOrDefault(fruits[high],0)+1);

            // check if the count exceed two(number of basket) our maximum limit
            while (frequencyMap.size() > noOfBasket){
                //clear the fruits from the hashtable
                frequencyMap.put(fruits[low],frequencyMap.getOrDefault(fruits[low],0)-1);

                if(frequencyMap.getOrDefault(fruits[low],0) == 0){
                    frequencyMap.remove(fruits[low]);
                }

                low++;
            }

            int len = high - low + 1;
            res = Math.max(res, len);
        }
        return  res==Integer.MIN_VALUE ? -1 : res;
    }
}
