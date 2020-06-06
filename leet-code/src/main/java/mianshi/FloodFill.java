package mianshi;

/**
 * @author shengouqiang
 * @date 2020/5/29
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int y = image.length;
        int x = image[0].length;
        if ((sr >= x || sr < 0) || (sc >= y || sc < 0) || (image[sr][sc] == newColor)) {
            return image;
        }
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr >= image[0].length || sr < 0) {
            return;
        }
        if (sc >= image.length || sc < 0) {
            return;
        }
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, oldColor);
            dfs(image, sr + 1, sc, newColor, oldColor);
            dfs(image, sr, sc - 1, newColor, oldColor);
            dfs(image, sr, sc + 1, newColor, oldColor);
        }
    }
}
