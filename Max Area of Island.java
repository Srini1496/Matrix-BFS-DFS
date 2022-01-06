/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
*/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !visited[i][j])
                    max=Math.max(max,helper(i,j,row,col,grid,visited));
            }
        }
        return max;
    }
    
    public int helper(int i,int j,int row,int col,int[][] grid,boolean[][] visited){
        if(grid[i][j]==0)
            return 0;
        if(visited[i][j])
            return 0;
        int count=1;
        visited[i][j]=true;
        if(i>0)
            count+=helper(i-1,j,row,col,grid,visited);
        if(i<row-1)
            count+=helper(i+1,j,row,col,grid,visited);
        if(j>0)
            count+=helper(i,j-1,row,col,grid,visited);
        if(j<col-1)
            count+=helper(i,j+1,row,col,grid,visited);
        return count;
    }
}
