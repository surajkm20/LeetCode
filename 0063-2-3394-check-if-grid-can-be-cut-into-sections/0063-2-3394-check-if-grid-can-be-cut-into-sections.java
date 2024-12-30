class Solution {
    public ArrayList<int[]> mergeArray(int[][] num){
        int n = num.length;
        ArrayList<int[]> arraylist = new ArrayList<>();
        arraylist.add(new int[]{num[0][0], num[0][1]});

        for(int i=1;i<n;i++){
            int[] temp = arraylist.remove(arraylist.size()-1);
            if(num[i][0] < temp[1]){
                int x = Math.min(num[i][0], temp[0]);
                int y = Math.max(num[i][1], temp[1]);
                arraylist.add(new int[]{x, y});
            }else{
                arraylist.add(temp);
                arraylist.add(new int[]{num[i][0], num[i][1]});
            }
        }

        for(int[] temp : arraylist){
            System.out.println(temp[0]+".   "+temp[1]);
        }
        System.out.println("end");

        return arraylist;
    }


    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] sortedX = new int[rectangles.length][2];
        int[][] sortedY = new int[rectangles.length][2];

        for(int i=0;i<rectangles.length;i++){
            int[] num = rectangles[i];

            sortedX[i][0] = num[0];
            sortedX[i][1] = num[2];

            sortedY[i][0] = num[1];
            sortedY[i][1] = num[3];
        }

       // Sort the arrays
        Arrays.sort(sortedX, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(sortedY, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> arrayX = mergeArray(sortedX);
        ArrayList<int[]> arrayY = mergeArray(sortedY);

        return arrayX.size() > 2 || arrayY.size() >2;
    }
}