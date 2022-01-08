/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row =mat.length;
        int col=mat[0].length;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();        
       
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){                    
                    queue.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int level=1;
        while(!queue.isEmpty()){
            int n=queue.size();
            while(n!=0){
                int[] arr=queue.poll();
                for(int i=0;i<4;i++){
                    int r=arr[0]+directions[i][0];
                    int c=arr[1]+directions[i][1];
                    if(r<0 || r>=row || c<0 || c>=col || mat[r][c]!=-1)
                        continue;
                    
                    
                    mat[r][c]=level;
                    queue.add(new int[]{r,c});
                }
                n--;
            }
            level++;
        }
        return mat;
    }
}
