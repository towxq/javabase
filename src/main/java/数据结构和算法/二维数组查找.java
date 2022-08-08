package 数据结构和算法;

/**
 * @author wxq
 * @ClassName 二维数组查找
 * @Description TODO
 * @date 2021/10/14  22:34
 */
public class 二维数组查找 {
    //    在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public static void main(String[] args) {

    }

    public boolean Find(int target, int [][] array) {
        //基本思路从左下角开始找，这样速度最快
        int row = array.length-1;//行
        int column = 0;//列
        //当行数大于0，当前列数小于总列数时循环条件成立
        while((row >= 0)&& (column< array[0].length)){
            if(array[row][column] > target){
                row--;
            }else if(array[row][column] < target){
                column++;
            }else{
                return true;
            }
        }
        return false;
    }
}
