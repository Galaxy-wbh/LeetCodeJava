package LeetCode.M_LC0990_等式方程的可满足性;

public class Solution {
    //并查集解法
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for(String equation:equations){
            char[] charArray = equation.toCharArray();
            int index1 = charArray[0] - 'a';
            int index2 = charArray[3] - 'a';
            unionFind.union(index1, index2);
        }

        for(String equation:equations){
            char[] charArray = equation.toCharArray();
            if(charArray[1] == '!'){
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';
                if(unionFind.isConnected(index1, index2)){
                    return false;
                }
            }
        }
        return true;

    }

    private class UnionFind{
        private int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];//路径压缩
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        String[] s = {"a==b","e==c","b==c","a!=e"};
        boolean flag = new Solution().equationsPossible(s);
        System.out.println(flag);
    }
}
