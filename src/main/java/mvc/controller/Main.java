package mvc.controller;

import java.util.ArrayList;

public class Main {
    //https://leetcode.com/problems/last-day-where-you-can-still-cross/description/
    public static void main(String[] args) {
        Main action = new Main();
        int[][] mapCheck = action.mapByDay(3,3,"[[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]",6);
        System.out.println("----------------  Map check ---------------");
        System.out.println(action.isAliveMap(mapCheck));
    }

    //------------------------- Hàm logic -------------------------------
    public int latestDayToCross(int row, int col, int[][] cells) {
        int day =0;
        int[][] mapCheck = new int[row][col];
        for (int i = 0; i < cells.length; i++) {
            mapCheck[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        return 0;
    }

    public boolean isAliveMap(int[][] mapCheck) {
        for (int i=0; i< mapCheck.length;i++){
            int rowAvailable = mapCheck[i].length;
            for (int j=0; j<mapCheck[i].length; j++){
                if (mapCheck[i][j]==1){
                    rowAvailable--;
                }
            }
            if(rowAvailable==0){
                return false;
            }
        }
        return true;
    }

    public boolean isDeadPoint(int[][] currentMap, int[] location) {
        if(currentMap[location[0]][location[1]]==1){
            return false;
        }
        if (currentMap[location[0] + 1][location[1]] != 0 && currentMap[location[0] - 1][location[1]] != 0
                && currentMap[location[0]][location[1] + 1] != 0 && currentMap[location[0]][location[1] - 1] != 0) {
            return true;
        }
        return false;
    }

    public boolean isCheckPoint(int[][]currentMap, int[]location){
        int check =0;
        if(currentMap[location[0]+1][location[1]]==0){
            check++;
        }
        if(currentMap[location[0]-1][location[1]]==0){
            check++;
        }
        if(currentMap[location[0]][location[1]+1]==0){
            check++;
        }if(currentMap[location[0]][location[1]-1]==0){
            check++;
        }
        return check>=2;
    }

    public int[] nextCoord(int[] currentCoord, int [][] mapCheck){
        int row = mapCheck.length;
        int col = mapCheck[0].length;
        if (currentCoord[0]-1==0){

        }
        return currentCoord;
    }

//------------------------ Hàm in ---------------------------------
    public int[][] mapByDay(int row, int col, String mapString, int day){
        Main action = new Main();
        int[][] mapCheck = new int[row][col];
        System.out.println("---------------  Day 0  ----------------");
        action.printMapCheck(mapCheck);

        int[][] cells = action.toArrayLocationMap(mapString);
        if(day>cells.length){
            day=cells.length;
        }
        for (int i = 0; i < day; i++) {
            int mapRowCord = cells[i][0]-1;
            int mapColCord = cells[i][1]-1;
            if(mapRowCord>mapCheck.length-1|mapColCord>mapCheck[0].length-1){
                continue;
            }
            mapCheck[mapRowCord][mapColCord] = 1;
            System.out.println("----------------  Map day "+(i+1)+"  ---------------");
            action.printMapCheck(mapCheck);
        }

        return mapCheck;
    }

    public void printMapCheck(int[][] mapCheck) {
        int row = mapCheck.length;
        int col = mapCheck[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mapCheck[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] toArrayLocationMap(String s){
        String []string= s.trim().split("\\],\\[");
        int[][] result = new int[string.length][2];
        for (int i=0; i< string.length;i++){
            String[] sr = string[i].replaceAll("[^0-9\\,]+","").split(",");
            result[i][0]= Integer.valueOf(sr[0]);
            result[i][1]=Integer.valueOf(sr[1]);
        }
        return result;
    }
}
