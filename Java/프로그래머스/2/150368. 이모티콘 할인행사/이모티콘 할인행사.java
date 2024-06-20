class Solution {
    static int[] emoticon;
    static int[][] user;

    static int[] ans = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        user = users;
        emoticon = emoticons;

        dfs(0, new int[emoticons.length]);
        return ans;
    }

    public static void dfs (int dep, int[] sale) {
        if (dep == sale.length) {
            buy(sale);
            return;
        }

        for (int i=1; i<=4; i++){
            sale[dep] = i*10;
            dfs(dep+1, sale);
        }
    }

    public static void buy (int[] sale){
        int[] result = new int[2];

        for (int i=0; i<user.length; i++){
            int total = 0;
            for (int j=0; j<emoticon.length; j++)
                if (user[i][0] <= sale[j])
                    total += emoticon[j] * (100 - sale[j]) / 100;

            if (user[i][1] <= total)
                result[0]++;
            else
                result[1] += total;
        }
        ans = compared(ans, result);
    }

    public static int[] compared (int[] com1, int[] com2){
        if (com1[0] == com2[0])
            return com1[1] > com2[1]? com1 : com2;
        return com1[0]>com2[0]? com1 : com2;
    }
}