package task557;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Parser sc = new Parser(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<int[][]> arr = new ArrayList<>();
        int m,n,a = -1,b = -1,p;
        int[][] result;
        int[][] buf;
        m = sc.nextInt();
        n = sc.nextInt();
        a += sc.nextInt();
        b += sc.nextInt();
        p = sc.nextInt();
        for (int k = 0; k < m; k++){
            int[][] buf0 = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n;j++){
                    buf0[i][j] = sc.nextInt();
                }
            }
            arr.add(buf0);
        }
        switch (m){
            case 1:{
                if (arr.get(0)[a][b] >= p)
                    arr.get(0)[a][b] %= p;
                pw.println(arr.get(0)[a][b]);
                pw.flush();
            }break;
            case 2:{
                result = new int[n][n];
                multiplicationMatr(n,arr.get(0),arr.get(1), result,p);
                pw.println(result[a][b]);
                pw.flush();
            }break;
            default:{
                result = new int[n][n];
                buf = new int[n][n];
                multiplicationMatr(n,arr.get(0),arr.get(1),buf,p);
                for (int i = 2; i < arr.size(); i++){
                    multiplicationMatr(n,buf,arr.get(i),result,p);
                    if (i != arr.size() - 1){
                        buf = new int[n][n];
                        System.arraycopy(result,0,buf,0,result.length);
                        result = new int[n][n];
                    }else continue;
                }
                pw.println(result[a][b]);
                pw.flush();
            }
        }
    }
    static void multiplicationMatr(int n,int[][] matr1, int[][] matr2, int[][] result, int p){
        int r;
        for (int I = 0; I < n; I++) {
            for (int i = 0; i < n; i++) {
                r = matr1[I][i];
                for (int j = 0; j < n; j++) {
                    result[I][j] += r * matr2[i][j];
                    if (i == n - 1) {
                        if (result[I][j] >= p)
                            result[I][j] %= p;
                    } else continue;
                }
            }
        }
    }
    public static class Parser {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Parser(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead =  0;
        }
        public String nextString(int maxSize) {
            byte[] ch = new byte[maxSize];
            int point =  0;
            try {
                byte c = read();
                while (c == ' ' || c == '\n' || c=='\r')
                    c = read();
                while (c != ' ' && c != '\n' && c!='\r') {
                    ch[point++] = c;
                    c = read();
                }
            } catch (Exception e) {}
            return new String(ch, 0,point);
        }
        public int nextInt() {
            int ret =  0;
            boolean neg;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                neg = c == '-';
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                    c = read();
                } while (c > ' ');

                if (neg) return -ret;
            } catch (Exception e) {}
            return ret;
        }
        public long nextLong() {
            long ret =  0;
            boolean neg;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                neg = c == '-';
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                    c = read();
                } while (c > ' ');

                if (neg) return -ret;
            } catch (Exception e) {}
            return ret;
        }
        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer =  0, BUFFER_SIZE);
            } catch (Exception e) {}
            if (bytesRead == -1) buffer[ 0] = -1;
        }

        private byte read() {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
