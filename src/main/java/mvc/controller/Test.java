package mvc.controller;

public class Test {
    public static void main(String[] args) {
        Main action = new Main();
        Test act = new Test();

        action.printMapCheck(action.toArrayLocationMap("[[1,1],[2,1],[1,2],[2,2]]"));
    }


    public void printArr(String[]arr){
        for (int i =0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
