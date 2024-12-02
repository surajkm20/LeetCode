class Pair{
    int xS;
    int xE;

    Pair(int xS, int xE){
        this.xS = xS;
        this.xE = xE;
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b)->Integer.compare(a[0], b[0]));
        ArrayList<Pair> list = new ArrayList<>();
        for(int[]num : points) System.out.println(num[0]+" ** "+num[1]);
        System.out.println("**END**");

        list.add(new Pair(points[0][0], points[0][1]));

        for(int i=1;i<n;i++){
            Pair peek = list.get(list.size()-1);
            int peekStart = peek.xS;
            int peekEnd = peek.xE;

            int currentStart = points[i][0];
            int currentEnd = points[i][1];
            System.out.println(peekStart+"****"+peekEnd);
            if(currentStart >= peekStart && currentStart < peekEnd){
                if(currentEnd <= peekEnd){
                    list.remove(list.size()-1);
                    list.add(new Pair(currentStart, currentEnd));
                }else{
                    list.remove(list.size()-1);
                    list.add(new Pair(currentStart, peekEnd));
                }
            }else if(currentStart > peekStart && currentStart > peekEnd){
                list.add(new Pair(currentStart, currentEnd));
            }
        }

        for(Pair num: list){
            System.out.println(num.xS+"****"+num.xE);
        }
        return list.size();
    }
}