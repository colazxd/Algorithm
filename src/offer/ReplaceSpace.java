package offer;

public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        int length = str.length();
        System.out.println(length);
        char[] charString = str.toString().toCharArray();
        int count = 0;
        //遍历字符串，得到空格数目
        for (int i = 0; i < length; i++) {
            if (charString[i] == ' ')
                count ++;
        }
        int newlen = length + 2*count;

        int indexOri = length - 1;
        int indexNew = newlen - 1;
        while(indexOri >= 0) {

        }

        return null;
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("happy day");
        ReplaceSpace rs = new ReplaceSpace();
        rs.replaceSpace(sb);
    }

}
