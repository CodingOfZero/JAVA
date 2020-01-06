public class MinimumTimeVisitingAllPoints_1266 {
    /*public  int minTimeToVisitAllPoints(int[][] points) {
        int minTime=0;
        for(int i=1;i<points.length;i++){
            int prepoints_x=points[i-1][0];
            int prepoints_y=points[i-1][1];
            int curpoints_x=points[i][0];
            int curpoints_y=points[i][1];
            int totalXMovement = Math.abs(curpoints_x - prepoints_x);
            int totalYMovement = Math.abs(curpoints_y - prepoints_y);
            while(totalXMovement!=0 || totalYMovement!=0){
                if(totalXMovement!=0&&totalYMovement!=0){
                    minTime+=1;
                    totalXMovement--;
                    totalYMovement--;
                }else{
                    if(totalXMovement!=0){
                        minTime+=totalXMovement;
                        totalXMovement=0;
                    }
                    if(totalYMovement!=0){
                        minTime+=totalYMovement;
                        totalYMovement=0;
                    }
                }
            }
        }
        return minTime;
    }*/
    public static void main(String[] args){
        int[][] points={{1,1},{3,4},{-1,0}};
        int minTime=0;
        for(int i=1;i<points.length;i++){
            int prepoints_x=points[i-1][0];
            int prepoints_y=points[i-1][1];
            int curpoints_x=points[i][0];
            int curpoints_y=points[i][1];
            int totalXMovement = Math.abs(curpoints_x - prepoints_x);
            int totalYMovement = Math.abs(curpoints_y - prepoints_y);
            while(totalXMovement!=0 || totalYMovement!=0){
                if(totalXMovement!=0&&totalYMovement!=0){
                    minTime+=1;
                    totalXMovement--;
                    totalYMovement--;
                }else{
                    if(totalXMovement!=0){
                        minTime+=totalXMovement;
                        totalXMovement=0;
                    }
                    if(totalYMovement!=0){
                        minTime+=totalYMovement;
                        totalYMovement=0;
                    }
                }
            }
        }
        System.out.print(minTime);
    }
}
