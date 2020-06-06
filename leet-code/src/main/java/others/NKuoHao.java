package others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengouqiang
 * @date 2020/5/29
 */
public class NKuoHao {

    @Test
    public void testOne(){
        System.out.println(kuohao(3));
    }

    public List<String>  kuohao (int n){
        List<String> result = new ArrayList<>();
        if( n == 0){
            return  result;
        }
        dfs(n,0,0,"",result);
        return result;
    }

    private void dfs(int n,int left,int right,String str,List<String> result){
        if(left + right == 2 * n){
            result.add(str);
            return;
        }
        if(left < n){
            dfs(n,left + 1,right,str + "(",result);
        }
        if(right < left && right < n){
            dfs(n,left,right+1,str+ ")",result);
        }
    }

}
